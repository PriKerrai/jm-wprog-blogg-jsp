/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Bean.UserData;
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
		private static final String GET_USER = "SELECT * FROM JM_UserInformation WHERE ";
    private static final String GET_USER_ID = "SELECT UserID FROM JM_UserInformation WHERE Username = '";
    private static final String GET_USERNAME = "SELECT Username FROM JM_UserInformation WHERE UserID = '";
    private static final String GET_PASSWORD = "SELECT Password FROM JM_UserInformation WHERE UserID = '";
		
		private static final String INSERT_USER = "INSERT INTO JM_UserInformation VALUES (";
    
    //BLOGG
    private static final String GET_BLOGG_ID = "SELECT BloggID FROM JM_BloggInformation WHERE UserID = '";
    private static final String GET_BLOGG_HEADER = "SELECT BloggHeader FROM JM_BloggInformation WHERE BloggID = '";
    private static final String GET_BLOGG_POST_DATE = "SELECT BloggPostDate FROM JM_BloggInformation WHERE BloggID = '";
    private static final String GET_BLOGG_TEXT = "SELECT BloggText FROM JM_BloggInformation WHERE BloggID = '";
    
    //COMMENT
    private static final String GET_COMMENT_ID = "SELECT CommentID FROM JM_BloggComment WHERE TODO = '";
    private static final String GET_COMMENT_POST_DATE = "SELECT CommentPostDate FROM JM_BloggComment WHERE TODO = '";
    private static final String GET_COMMENT_TEXT = "SELECT CommentText FROM JM_BloggComment WHERE TODO = '";
    
    // User Table
    private static final String CREATE_TABLE_USER =
            "CREATE TABLE JM_UserInformation("
            + "UserID VARCHAR(30) NOT NULL,"
            + "Username VARCHAR(30) NOT NULL,"
            + "Password VARCHAR(30) NOT NULL,"
            + "PRIMARY KEY(UserID))";
    
    // Blogg Table
    private static final String CREATE_TABLE_BLOG =
            "CREATE TABLE JM_BlogInformation("
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
    
    private static Connection connection;
    private Statement statement;
    
    public DBManager() {
        
    }

    public Connection connectDB(String username, String password) {
			try {
				Class.forName(DRIVER_PATH);
				connection = DriverManager.getConnection(DATABASE_PATH, username, password);
				statement = connection.createStatement();
				statement.executeUpdate("DROP TABLE JM_UserInformation");
				statement.executeUpdate(CREATE_TABLE_USER);
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
				GET_USER + "UserID = '" + userID + "'" +
				"OR Username = '" + username + "'"
			);
			
			if (result.next())
				return false;
			
			return true;
		}
		
		@Override
		public void registerUser(UserData user)
		throws SQLException {
			System.out.println("Register User: "+user.getUserID()+":"+user.getUsername()+":"+user.getPassword());
			statement = connection.createStatement();
			statement.executeUpdate(
				INSERT_USER + "'" + user.getUserID() + "',"
				+ "'" + user.getUsername() + "',"
				+ "'" + user.getPassword() + "')"
			);
		}
		
		@Override
		public boolean isValidLogin(String username, String password)
		throws SQLException {
			statement = connection.createStatement();
      ResultSet result = statement.executeQuery(
				GET_USER + "Username = '" + username + "'"
				+ "AND Password = '" + password + "'"
			);
			
			if (!result.next())
				return false;
			
			return true;
		}
		
		@Override
		public UserData userLogin(String username, String password)
		throws SQLException {
			UserData tmp = new UserData();
			
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(
				GET_USER + "Username = '" + username + "'"
				+ "AND Password = '" + password + "'"
			);
			
			if (result.next()) {
				tmp.setUserID(result.getString("UserID"));
				tmp.setUsername(result.getString("Username"));
				tmp.setPassword(result.getString("Password"));
				System.out.println("User Login ResultSet: "+result.getString("UserID")+":"+result.getString("Username")+":"+result.getString("Password"));
				System.out.println("TMP: "+tmp.getUserID()+":"+tmp.getUsername()+":"+tmp.getPassword());
			}
			
			return tmp;
		}
    
    public int getUserID(String username) throws SQLException {
        int userID = -1;
        statement = connection.createStatement();
        ResultSet result = statement.executeQuery(GET_USER_ID + username + "'");
        while (result.next()) {
            userID = result.getInt("UserID");
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
}
