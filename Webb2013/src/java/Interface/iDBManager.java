/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

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
	
}
