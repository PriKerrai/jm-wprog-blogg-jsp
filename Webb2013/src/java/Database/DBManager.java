/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Interface.iDBManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Josef
 */
public class DBManager implements iDBManager {

    private static final String DRIVER_PATH = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_PATH = "jdbc:sqlserver://idasql-db.hb.se:56077;"
            + "databaseName=dbtht1204;selectMethod=cursor";
    
    //USER
    private static final String GET_USER_ID = "SELECT UserID FROM UserInformation WHERE Nick = '";
    private static final String GET_NICK = "SELECT * FROM UserInformation WHERE Email = '";
    private static final String GET_PASSWORD = "SELECT * FROM UserInformation WHERE UserID = '";
    
    //BLOGG
    private static final String GET_BLOGG_ID = "SELECT BloggID FROM BloggInformation WHERE UserID = '";
    private static final String GET_BLOGG_HEADER = "SELECT BloggHeader FROM BloggInformation WHERE BloggID = '";
    private static final String GET_BLOGG_POST_DATE = "SELECT BloggPostDate FROM BloggInformation WHERE BloggID = '";
    private static final String GET_BLOGG_TEXT = "SELECT BloggText FROM BloggInformation WHERE BloggID = '";
    
    //COMMENT
    private static final String GET_COMMENT_ID = "SELECT CommentID FROM BloggComment WHERE TODO = '";
    private static final String GET_COMMENT_POST_DATE = "SELECT CommentPostDate FROM BloggComment WHERE TODO = '";
    private static final String GET_COMMENT_TEXT = "SELECT CommentText FROM BloggComment WHERE TODO = '";
    
    // User Table
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE JM_UserInformation("
            + "UserID SMALLINT NOT NULL,"
            + "Nick VARCHAR(30) NOT NULL,"
            + "Password VARCHAR(30)NOT NULL,"
            + "PRIMARY KEY(UserID))";
    
    // Blogg Table
    private static final String CREATE_TABLE_BLOGG =
            "CREATE TABLE JM_BloggInformation("
            + "BloggID SMALLINT NOT NULL,"
            + "BloggHeader VARCHAR(50) NOT NULL,"
            + "BloggPostDate SMALLINT NOT NULL,"  //Date??
            + "UserID SMALLINT NOT NULL,"
            + "BloggText VARCHAR(5000) NOT NULL,"
            + "PRIMARY KEY(UserID),"  //UserID och BloggId??
            + "FOREIGN KEY(UserID) references UserInformation(UserID)";  //Bah, memory of databases is bad ;p och skall nog inte se ut så här
    
    // Comment Table
    private static final String CREATE_TABLE_COMMENT =
            "CREATE TABLE JM_BloggComment("
            + "UserID SMALLINT NOT NULL,"
            + "BloggID SMALLINT NOT NULL,"
            + "CommentPostDate Date NOT NULL,"
            + "CommentID SMALLINT NOT NULL,"
            + "CommentText VARCHAR(500) NOT NULL,"
            + "PRIMARY KEY(UserID),"  // BloggID + UserID i wonder? 
            + "FOREIGN KEY(UserID) references UserInformation(UserID))";
    
    private Connection connection;
    private Statement statement;
    
    public DBManager() {
        
    }

    public Connection connectDB(String username, String password) {
        try {
            Class.forName(DRIVER_PATH);

            System.out.println(username + password);
             Connection connection = DriverManager.getConnection(DATABASE_PATH,username,password);
             System.out.println(connection.getClientInfo());
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
    
    public int getUserID(String nick) throws SQLException {
        int userID = -1;
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_USER_ID + nick + "'");
        while (result.next()) {
            userID = result.getInt("UserID");
        }
        return userID;
    }
    
    public String getNick(String userID) throws SQLException {
        String nick = "";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_NICK + userID + "'");
        while (resultSet.next()) {
            nick = resultSet.getString("Nick");
        }
        return nick;
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
}
