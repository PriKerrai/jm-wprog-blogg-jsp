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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josef
 */
public class DBManager implements iDBManager {

    private static final String DRIVER_PATH = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_PATH = "jdbc:sqlserver://idasql-db.hb.se:56077;"
            + "databaseName=dbtht1204;selectMethod=cursor";
   
		//USER
    private static final String GET_USER = "SELECT * FROM JM_UserInformation WHERE ";
    private static final String GET_USER_ID = "SELECT UserID FROM JM_UserInformation WHERE Username = '";
    private static final String GET_USERNAME = "SELECT Username FROM JM_UserInformation WHERE UserID = '";
    private static final String GET_PASSWORD = "SELECT Password FROM JM_UserInformation WHERE UserID = '";
    private static final String INSERT_USER = "INSERT INTO JM_UserInformation VALUES (";
    
		//BLOGG
    private static final String GET_BLOG_POST_ID = "SELECT BlogPostID FROM JM_BlogPost WHERE UserID = '";
    private static final String GET_MAX_BLOG_ID = "SELECT TOP(1) BlogPostID FROM JM_BlogPost ORDER BY BlogPostID DESC";
    private static final String GET_BLOG_POST_HEADER = "SELECT BlogPostHeader FROM JM_BlogPost WHERE BlogPostID = '";
    private static final String GET_BLOG_POST_DATE = "SELECT BlogPostDate FROM JM_BlogPost WHERE BlogPostID = '";
    private static final String GET_BLOG_POST_TEXT = "SELECT BlogText FROM JM_BlogPost WHERE BlogPostID = '";
    private static final String INSERT_BLOG = "INSERT INTO JM_BlogPost VALUES (";
    
		//COMMENT
    private static final String GET_COMMENT_ID = "SELECT CommentID FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String GET_COMMENT_DATE = "SELECT CommentDate FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String GET_COMMENT_TEXT = "SELECT CommentText FROM JM_BlogComment WHERE BlogPostID = '";
    private static final String INSERT_COMMENT = "INSERT INTO JM_BlogComment VALUES (";
    
		// User Table
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE JM_UserInformation("
            + "UserID VARCHAR(30) NOT NULL,"
            + "Username VARCHAR(30) NOT NULL,"
            + "Password VARCHAR(30) NOT NULL,"
            + "PRIMARY KEY(UserID))";
    
		// Blogg Table
    private static final String CREATE_TABLE_BLOG =
            "CREATE TABLE JM_BlogPost("
            + "BlogPostID SMALLINT NOT NULL,"
            + "BlogPostHeader VARCHAR(50) NOT NULL,"
            + "BlogPostDate DATE NOT NULL,"
            + "UserID VARCHAR(30) NOT NULL,"
            + "BlogPostText VARCHAR(5000) NOT NULL,"
            + "PRIMARY KEY(UserID),"
						+ "PRIMARY KEY(BlogPostID),"
            + "FOREIGN KEY(UserID) REFERENCES JM_UserInformation(UserID)";
    
    // Comment Table
    private static final String CREATE_TABLE_COMMENT =
            "CREATE TABLE JM_BlogComment("
            + "UserID VARCHAR(30) NOT NULL,"
            + "BlogID SMALLINT NOT NULL,"
            + "CommentPostDate Date NOT NULL,"
            + "CommentID SMALLINT NOT NULL,"
            + "CommentText VARCHAR(500) NOT NULL,"
            + "PRIMARY KEY(UserID)," 
            + "FOREIGN KEY(UserID) REFERENCES JM_UserInformation(UserID))";
    
		private static Connection connection;
    private Statement statement;

    public DBManager()  {
    }

    @Override
    public Connection connectDB(String username, String password) {
        try {
            Class.forName(DRIVER_PATH);
            connection = DriverManager.getConnection(DATABASE_PATH, username, password);
						//statement = connection.createStatement();
						//statement.executeUpdate("DROP TABLE JM_BlogPost");
						//statement.executeUpdate(CREATE_TABLE_BLOG);
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int getLatestBlogPost(int blogID) {
        // Fetch latest blogpost where userID == this.blogID
        return 1;
    }

    @Override
    public String getBlogPostTitle(int blogID, int postID) {
        // Fetch title of post where userID == this.blogID
        // and postID == this.postID
        return "Blog Post Title";
    }

    @Override
    public String getBlogPostContent(int blogID, int postID) {
        // Fetch content of post where userID == this.blogID
        // postID == this.postID
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Phasellus a eros eros. Morbi vestibulum, dolor vitae molestie "
                + "ullamcorper, dolor sapien porttitor sem, vitae facilisis dolor "
                + "arcu eu justo. Vivamus lorem leo, euismod id scelerisque non, "
                + "laoreet sed metus. Donec quis scelerisque dui. "
                + "Etiam fermentum, neque sed varius laoreet, "
                + "odio enim blandit nunc, non interdum ligula arcu et augue. "
                + "Ut placerat semper nulla sed lacinia. "
                + "Proin faucibus pretium diam eget tempor. "
                + "Sed eros elit, faucibus at tristique non, cursus quis dui. "
                + "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices "
                + "posuere cubilia Curae; Morbi non libero augue, "
                + "quis viverra massa. Phasellus non cursus velit. Nulla facilisi. "
                + "Sed viverra mollis quam, eget accumsan sapien interdum vitae. "
                + "Suspendisse lobortis mauris in magna viverra consequat. "
                + "Maecenas mollis tristique dui a ultrices. ";
    }

    @Override
    public String getBlogPostDate(int blogID, int postID) {
        // Fetch date of post where userID == this.blogID
        // postID == this.postID
        return "February 20, 2013";
    }

    @Override
    public String getBlogPostAuthor(int blogID, int postID) {
        // Fetch author of post where userID == this.blogID
        // postID == this.postID
        return "SlimeFish";
    }

    public String getUserID() {
        return "Banana";
    }

    public String getUsernickname() {
        return "kerrai";
    }

    public String getUserPassword() {
        return "password";
    }

    @Override
    public boolean isValidRegInput(String userID, String username)
            throws SQLException {
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                GET_USER + "UserID = '" + userID + "'"
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
        statement.executeUpdate(
                INSERT_USER + "'" + user.getUserid() + "',"
                + "'" + user.getUsername() + "',"
                + "'" + user.getPassword() + "')");
    }

    @Override
    public void registerNewBlogMessage(BlogPost blogPost, UserData user) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(
                INSERT_BLOG + "'" + getMaxBlogID() + "',"
                + "'" + blogPost.getBlogHeadline() + "',"
                + "'" + blogPost.getBlogText() + "',"
                + "'" + getCurrentDate() + "',"
                + "'" + user.getUserid() + "')");

    }
    
    @Override
    public void registerNewBlogComment(BlogData blogData, UserData user, BlogComment blogComment) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(
                INSERT_COMMENT + "'" + getCommentID() + "',"
                + "'" + blogComment.getBlogComment() + "',"
                + "'" + getCurrentDate() + "',"
                + "'" + user.getUserid() + "',"
                + "'" + blogData.getBlogID() + "')");

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
            tmp.setUserid(result.getString("UserID"));
            tmp.setUsername(result.getString("Username"));
            tmp.setPassword(result.getString("Password"));
        }

        return tmp;
    }

    public String getUserID(String username) throws SQLException {
        String userID = "";
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_USER_ID + username + "'");
        while (result.next()) {
            userID = result.getString("UserID");
        }
        return userID;
    }

    public String getUsername(String userID) throws SQLException {
        String username = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_USERNAME + userID + "'");
        while (resultSet.next()) {
            username = resultSet.getString("Username");
        }
        return username;
    }

    public char[] getPassword(String userID) throws SQLException {
        String password = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_PASSWORD + userID + "'");
        while (resultSet.next()) {
            password = resultSet.getString("Password");
        }
        char[] charPassword = password.toCharArray();
        return charPassword;
    }

    @Override
    public Timestamp getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());
        return timeStamp;
        
    }
    
    public int getCommentID() {
        //Fetch the current highest comment ID on the blog you are visiting.
        return 1;
    }
    
    
        public int getMaxBlogID() {
        int count = 0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_MAX_BLOG_ID);
            while (resultSet.next()) {
                count = resultSet.getInt("BlogID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count + 1;
    }
}
