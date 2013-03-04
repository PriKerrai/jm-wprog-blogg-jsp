/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Database.DBManager;
import Interface.iDBManager;
import java.sql.SQLException;

/**
 *
 * @author Josef
 */
public class BlogPostInfo {
	
	private iDBManager dbManager = new DBManager();
	
	public BlogPostInfo() {
		
	}
	
	public String getBlogPostTitle(int postID)
	throws SQLException {
		return dbManager.getBlogPostTitle(postID);
	}
	
	public String getBlogPostContent(int postID)
	throws SQLException {
		return dbManager.getBlogPostContent(postID);
	}
	
	public String getBlogPostDate(int postID)
	throws SQLException {
		return dbManager.getBlogPostDate(postID);
	}
	
	public String getBlogPostAuthor(int blogID)
	throws SQLException {
		return dbManager.getBlogPostAuthor(blogID);
	}
	
}
