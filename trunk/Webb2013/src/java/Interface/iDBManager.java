/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Bean.UserData;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Josef
 */
public abstract interface iDBManager {
	
	public abstract int getLatestBlogPost(int blogID);
	
	public abstract String getBlogPostTitle(int blogID, int postID);
	
	public abstract String getBlogPostContent(int blogID, int postID);
	
	public abstract String getBlogPostDate(int blogID, int postID);
	
	public abstract String getBlogPostAuthor(int blogID, int postID);
	
  public abstract Connection connectDB(String username, String password);
	
	public abstract boolean isValidLogin(String username, String password) throws SQLException;
	
	public abstract UserData userLogin(String username, String password);
	
	public abstract boolean isValidRegInput(String userID, String username);
	
	public abstract void registerUser(UserData user);

}
