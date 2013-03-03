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
	
	public String getBlogName(int blogID) throws SQLException {
		return dbManager.getBlogName(blogID);
	}
	
	public int[] getAllBlogID() throws SQLException{
		return dbManager.getAllBlogID();
	}
	
	public String[] getBlogList() throws SQLException {
		return dbManager.getAllBlogNames();
	}
	
	public int[] getAllBlogPostID(int blogID) throws SQLException {
		return dbManager.getAllBlogPostID(blogID);
	}
	
	public String[] getBlogPostList(int blogID) throws SQLException {
		return dbManager.getAllBlogPosts(blogID);
	}
	
        public int[] getAllCommentID(int blogPostID) throws SQLException {
            return dbManager.getAllCommentID(blogPostID);
        }
        
        public Comment[] getAllComments(int blogID, int blogPostID) 
        throws SQLException {
            return dbManager.getAllComments(blogID, blogPostID);
        }
}
