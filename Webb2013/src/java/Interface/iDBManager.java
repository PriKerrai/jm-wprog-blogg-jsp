/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Bean.BlogComment;
import Bean.BlogData;
import Bean.UserData;
import java.sql.Connection;
import java.sql.SQLException;
import Bean.BlogPost;
import Logic.Comment;
import Logic.Post;
import java.util.Date;

/**
 *
 * @author Josef
 */
public abstract interface iDBManager {
	
	/*
	 * General note:
	 * BlogID is the same as UserID, just renamed to make sence in its context.
	 */
	
	public abstract Connection connectDB(String username, String password);
	
	public abstract int getNumberOfBlogs()
	throws SQLException;
	
	public abstract int[] getAllBlogID()
	throws SQLException;
	
	public abstract String getBlogName(int blogID)
	throws SQLException;
	
	public abstract String[] getAllBlogNames()
	throws SQLException;
	
	public abstract int getNumberOfPosts()
	throws SQLException;
	
	public abstract int[] getAllBlogPostID()
	throws SQLException;
	
	public abstract Post[] getAllBlogPosts()
	throws SQLException;
	
	public abstract String getBlogPostTitle(int postID)
	throws SQLException;
	
	public abstract String getBlogPostContent(int postID)
	throws SQLException;
	
	public abstract String getBlogPostDate(int postID)
	throws SQLException;
	
	public abstract String getBlogPostAuthor(int blogID)
	throws SQLException;
	
	public abstract int getMaxBlogPostID() 
	throws SQLException;
	
	public abstract int getLatestBlogPost(int blogID)
	throws SQLException;
	
	public abstract void registerNewBlog(BlogData newBlog, UserData user)
	throws SQLException;
	
	public abstract void registerNewBlogPost(BlogPost blogPost, UserData user)
	throws SQLException;
        
	public void registerNewBlogComment(BlogData blogData, UserData user, BlogComment blogComment)
	throws SQLException;
        
  public abstract int[] getAllCommentID(int blogPostID)
	throws SQLException;
        
	public abstract Comment getComment(int commentID)
	throws SQLException;
        
	public abstract Comment[] getAllComments(int blogPostID)
	throws SQLException;
	
	public abstract boolean isValidLogin(String username, String password)
	throws SQLException;
	
	public abstract UserData userLogin(String username, String password)
	throws SQLException;
	
	public abstract boolean isValidRegInput(String useralias, String username)
	throws SQLException;
	
	public abstract void registerUser(UserData user)
	throws SQLException;

	public abstract String getPassword(int userID)
	throws SQLException;
	
	public abstract Date getCurrentDate(); 

}
