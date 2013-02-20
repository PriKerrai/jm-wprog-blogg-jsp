/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Interface.iDBManager;

/**
 *
 * @author Josef
 */
public class DBManager implements iDBManager {

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
}
