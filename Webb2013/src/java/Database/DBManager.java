/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Bean.BlogComment;
import Bean.BlogData;
import Bean.BlogPost;
import Bean.UserData;
import Interface.iDBManager;
import Logic.Comment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author Josef
 */
public class DBManager implements iDBManager {

    private static final String DRIVER_PATH = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_PATH = "jdbc:sqlserver://idasql-db.hb.se:56077;"
            + "databaseName=dbtht1204;selectMethod=cursor";
    // USER | BLOG
    private static final String GET_USER = "SELECT * FROM JM_UserInformation WHERE ";
    private static final String GET_USER_ID = "SELECT UserID FROM JM_UserInformation WHERE Username = '";
    private static final String GET_MAX_USER_ID = "SELECT TOP(1) UserID FROM JM_UserInformation ORDER BY UserID DESC";
    private static final String GET_USERNAME = "SELECT Username FROM JM_UserInformation WHERE UserID = '";
    private static final String GET_PASSWORD = "SELECT Password FROM JM_UserInformation WHERE UserID = '";
    private static final String INSERT_USER = "INSERT INTO JM_UserInformation VALUES (";
    private static final String GET_BLOG_NAME = "SELECT Blog FROM JM_UserInformation WHERE UserID = '";
    private static final String GET_NUM_BLOGS = "SELECT COUNT(Blog) as NumBlogs FROM JM_UserInformation WHERE Blog <> ''";
    // "GET_ALL_BLOGID" är lite missledande. Denna returnerar UserID
    // för alla users som har registrerat en blogg, dvs. där Blog inte är NULL.
    private static final String GET_ALL_BLOGID = "SELECT UserID FROM JM_UserInformation WHERE Blog <> ''";
    private static final String INSERT_BLOG = "UPDATE JM_UserInformation SET Blog='";
    // BLOG POST
    private static final String GET_BLOG_POST_ID = "SELECT BlogPostID FROM JM_BlogPost WHERE UserID = '";
    private static final String GET_MAX_BLOG_POST_ID = "SELECT TOP(1) BlogPostID FROM JM_BlogPost WHERE UserID ='";
    private static final String GET_BLOG_POST_HEADLINE = "SELECT BlogPostHeader FROM JM_BlogPost WHERE ";
    private static final String GET_BLOG_POST_DATE = "SELECT BlogPostDate FROM JM_BlogPost WHERE ";
    private static final String GET_BLOG_POST_TEXT = "SELECT BlogPostText FROM JM_BlogPost WHERE ";
    private static final String GET_BLOG_POST_AUTHOR = "SELECT Username FROM JM_UserInformation WHERE UserID ='";
    private static final String GET_NUM_POSTS = "SELECT COUNT(*) as NumPosts FROM JM_BlogPost WHERE UserID = '";
    private static final String INSERT_BLOG_POST = "INSERT INTO JM_BlogPost VALUES (";
    // COMMENT
    private static final String GET_COMMENT = "SELECT * FROM JM_BlogComment WHERE CommentID = '";
    private static final String GET_COMMENT_ID = "SELECT CommentID FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String GET_COMMENT_DATE = "SELECT CommentDate FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String GET_COMMENT_TEXT = "SELECT CommentText FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String GET_MAX_COMMENT_ID = "SELECT TOP(1) CommentID FROM JM_BlogComment WHERE BlogPostID ='";
    private static final String INSERT_COMMENT = "INSERT INTO JM_BlogComment VALUES (";
    private static final String GET_NUM_COMMENTS = "SELECT COUNT(*) as NumComments FROM JM_BlogComment WHERE BlogPostID ='";
    // USER
    
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE JM_UserInformation("
            + "UserID VARCHAR(30) NOT NULL,"
            + "Username VARCHAR(30) NOT NULL,"
            + "Password VARCHAR(30) NOT NULL,"
            + "PRIMARY KEY(UserID))";
    // BlogPost Table
    private static final String CREATE_TABLE_BLOG_POST =
            "CREATE TABLE JM_BlogPost("
            + "BlogPostID SMALLINT NOT NULL,"
            + "BlogPostHeader VARCHAR(50) NOT NULL,"
            + "BlogPostDate DATE NOT NULL,"
            + "UserID VARCHAR(30) NOT NULL,"
            + "BlogPostText VARCHAR(5000) NOT NULL,"
            + "PRIMARY KEY(UserID),"
            + "PRIMARY KEY(BlogPostID),"
            + "FOREIGN KEY(UserID) REFERENCES JM_UserInformation(UserID))";
    // Comment Table
    private static final String CREATE_TABLE_COMMENT =
            "CREATE TABLE JM_BlogComment("
            + "UserID VARCHAR(30) NOT NULL,"
            + "BlogPostID SMALLINT NOT NULL,"
            + "CommentDate Date NOT NULL,"
            + "CommentID SMALLINT NOT NULL,"
            + "CommentText VARCHAR(500) NOT NULL,"
            + "PRIMARY KEY(UserID),"
            + "FOREIGN KEY(UserID) REFERENCES JM_UserInformation(UserID))";
    private static Connection connection;
    private Statement statement;

    public DBManager() {
    }

    @Override
    public Connection connectDB(String username, String password) {
        try {
            Class.forName(DRIVER_PATH);
            connection = DriverManager.getConnection(DATABASE_PATH, username, password);
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String getBlogPostTitle(int blogID, int postID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_BLOG_POST_HEADLINE
                + "UserID = '" + blogID + "' AND "
                + "BlogPostID = '" + postID + "'");

        if (result.next()) {
            return result.getString("BlogPostHeader");
        }
        return "Empty Headline";
    }

    @Override
    public String getBlogPostContent(int blogID, int postID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_BLOG_POST_TEXT
                + "UserID = '" + blogID + "' AND "
                + "BlogPostID = '" + postID + "'");

        if (result.next()) {
            return result.getString("BlogPostText");
        }
        return "Nothing to read here.";
    }

    @Override
    public String getBlogPostDate(int blogID, int postID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_BLOG_POST_DATE
                + "UserID = '" + blogID + "' AND "
                + "BlogPostID = '" + postID + "'");

        if (result.next()) {
            return result.getString("BlogPostDate");
        }
        return "Date missing";
    }

    @Override
    public String getBlogPostAuthor(int blogID, int postID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_BLOG_POST_AUTHOR + blogID + "'");

        if (result.next()) {
            return result.getString("Username");
        }
        return "Username missing";
    }

    @Override
    public boolean isValidRegInput(String useralias, String username)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_USER + "UserAlias = '" + useralias + "'"
                + "OR Username = '" + username + "'");

        if (result.next()) {
            return false;
        }

        return true;
    }

    @Override
    public void registerUser(UserData user)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_MAX_USER_ID);

        int newID = 1;
        if (result.next()) {
            newID = result.getInt("UserID") + 1;
        }

        statement.executeUpdate(
                INSERT_USER + "'" + newID + "',"
                + "'" + user.getUseralias() + "',"
                + "'" + user.getUsername() + "',"
                + "'" + user.getPassword() + "',"
                + "'')");
    }

    @Override
    public void registerNewBlog(BlogData newBlog, UserData user)
            throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(
                INSERT_BLOG + newBlog.getBlogname() + "'"
                + "WHERE UserID='" + user.getUserid() + "'");
    }

    @Override
    public void registerNewBlogPost(BlogPost blogPost, UserData user)
            throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(
                INSERT_BLOG_POST + "'" + (getMaxBlogPostID(user.getUserid())+1) + "',"
                + "'" + blogPost.getBlogheadline() + "',"
                + "'" + blogPost.getText() + "',"
                + "'" + getCurrentDate() + "',"
                + "'" + user.getUserid() + "')");
    }

    @Override
    public void registerNewBlogComment(BlogData blogData, UserData user,
            BlogComment blogComment)
            throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(
                INSERT_COMMENT + "'" + (getMaxCommentID(blogData.getBlogid(), blogComment.getPostid()) + 1) + "',"
                + "'" + blogComment.getComment() + "',"
                + "'" + getCurrentDate() + "',"
                + "'" + blogData.getBlogid() + "',"
                + "'" + user.getUserid() + "')");

    }

    @Override
    public boolean isValidLogin(String username, String password)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_USER + "Username = '" + username + "'"
                + "AND Password = '" + password + "'");

        if (!result.next()) {
            return false;
        }

        return true;
    }

    @Override
    public UserData userLogin(String username, String password)
            throws SQLException {
        UserData tmp = new UserData();

        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_USER + "Username = '" + username + "'"
                + "AND Password = '" + password + "'");

        if (result.next()) {
            tmp.setUserid(result.getInt("UserID"));
            tmp.setUseralias(result.getString("UserAlias"));
            tmp.setUsername(result.getString("Username"));
            tmp.setPassword(result.getString("Password"));
            tmp.setBlog(result.getString("Blog"));
        }

        return tmp;
    }

    public int getUserID(String username)
            throws SQLException {
        int userID = -1;
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_USER_ID + username + "'");
        while (result.next()) {
            userID = result.getInt("UserID");
        }
        return userID;
    }

    public String getUseralias(int userID)
            throws SQLException {
        String alias = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_USERNAME + userID + "'");
        while (resultSet.next()) {
            alias = resultSet.getString("UserAlias");
        }
        return alias;
    }

    public String getUsername(int userID)
            throws SQLException {
        String username = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_USERNAME + userID + "'");
        while (resultSet.next()) {
            username = resultSet.getString("Username");
        }
        return username;
    }

    @Override
    public String getPassword(int userID)
            throws SQLException {
        String password = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_PASSWORD + userID + "'");
        while (resultSet.next()) {
            password = resultSet.getString("Password");
        }
        return password;
    }

    @Override
    public Timestamp getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return timeStamp;

    }

    public int getMaxCommentID(int blogPostID, int blogID) throws SQLException {
        
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_MAX_COMMENT_ID + blogPostID + "'ORDER BY CommentID DESC");

        if (result.next()) {
            return result.getInt("CommentID");
        }

        return 1;

    }

    @Override
    public int getMaxBlogPostID(int blogID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_MAX_BLOG_POST_ID + blogID + "' ORDER BY BlogPostID DESC");

        if (result.next()) {
            return result.getInt("BlogPostID");
        }
        return 1;
    }

    @Override
    public int getNumberOfPosts(int blogID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_NUM_POSTS + blogID + "'");

        if (result.next()) {
            return result.getInt("NumPosts");
        }
        return 0;
    }

    @Override
    public int[] getAllBlogPostID(int blogID)
            throws SQLException {
        int[] idList = new int[getNumberOfPosts(blogID)];
        int i = 0;

        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_BLOG_POST_ID + blogID + "' ORDER BY BlogPostID DESC");

        while (result.next()) {
            idList[i] = result.getInt("BlogPostID");
            i++;
        }

        return idList;
    }

    @Override
    public String[] getAllBlogPosts(int blogID)
            throws SQLException {
        String[] postList = new String[getNumberOfPosts(blogID)];
        int i = 0;

        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_BLOG_POST_HEADLINE + "UserID ='" + blogID + "'");

        while (result.next()) {
            postList[i] = result.getString("BlogPostHeader");
            i++;
        }

        return postList;
    }

    @Override
    public int getNumberOfBlogs()
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_NUM_BLOGS);

        if (result.next()) {
            return result.getInt("NumBlogs");
        }

        return 0;

    }

    @Override
    public int[] getAllBlogID()
    throws SQLException {
        int[] idList = new int[getNumberOfBlogs()];
        int i = 0;

        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_ALL_BLOGID + " ORDER BY UserID DESC");

        while (result.next()) {
            idList[i] = result.getInt("UserID");
            i++;
        }

        return idList;
    }

    @Override
    public String getBlogName(int blogID)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_BLOG_NAME + blogID + "'");

        if (result.next()) {
            return result.getString("Blog");
        }

        return "";
    }

    @Override
    public String[] getAllBlogNames()
    throws SQLException {
        int numBlogs = getNumberOfBlogs();
        int[] idList = getAllBlogID();
        String[] blogList = new String[numBlogs];

        for (int i = 0; i < numBlogs; i++) {
            blogList[i] = getBlogName(idList[i]);
        }

        return blogList;
    }
    
    public int getNumberOfComments(int blogPostID) throws SQLException {
        
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_NUM_COMMENTS + blogPostID + "'");
        
        if (result.next()) {
            return result.getInt("NumComments");
        }
        
        return 0;
    }
    
    @Override
    public int[] getAllCommentID(int blogPostID) throws SQLException  {
        int[] idList = new int[getNumberOfComments(blogPostID)];
        int i = 0;

        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
            GET_COMMENT_ID + blogPostID + "' ORDER BY CommentID DESC"
        );

        while (result.next()) {
            idList[i] = result.getInt("CommentID");
            i++;
        }

        return idList;
    }
    
    @Override
    public Comment getComment(int commentID)
    throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
            GET_COMMENT + commentID + "'"
        );
        
        Comment comment = new Comment();
        if (result.next()) {
            comment.setCommentID(result.getInt("CommentID"));
            comment.setBlogPostID(result.getInt("BlogPostID")); // vet inte om den behövs
            comment.setUser(getUsername(result.getInt("UserID")));
            comment.setDate(result.getString("CommentDate"));
            comment.setText(result.getString("CommentText"));
        }
        return comment;
    }
    
    @Override
    public Comment[] getAllComments(int blogID, int blogPostID)
    throws SQLException {
        int numComments = getNumberOfComments(blogPostID);
        int[] idList = getAllCommentID(blogPostID);
        Comment[] commentList = new Comment[numComments];
        
        for (int i = 0; i < numComments; i++) {
            commentList[i] = getComment(idList[i]);
        }
        return commentList;
    }
}

