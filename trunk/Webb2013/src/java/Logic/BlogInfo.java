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
public class BlogInfo {
	
	private iDBManager dbManager = new DBManager();
	
	public BlogInfo() {
		
	}
	
	public String getBlogName(int blogID)
	throws SQLException {
		return dbManager.getBlogName(blogID);
	}
	
	public int[] getAllBlogID()
	throws SQLException{
		return dbManager.getAllBlogID();
	}
	
	public String[] getBlogList()
	throws SQLException {
		return dbManager.getAllBlogNames();
	}
	
	public int[] getAllBlogPostID()
	throws SQLException {
		return dbManager.getAllBlogPostID();
	}
	
	public Post[] getBlogPostList()
	throws SQLException {
		return dbManager.getAllBlogPosts();
	}
	
	public int getLatestBlogPost(int blogID)
	throws SQLException {
		return dbManager.getLatestBlogPost(blogID);
	}
	
	public int[] getAllCommentID(int blogPostID)
	throws SQLException {
		return dbManager.getAllCommentID(blogPostID);
  }
        
	public Comment[] getAllComments(int blogPostID) 
	throws SQLException {
		return dbManager.getAllComments(blogPostID);
	}
}
