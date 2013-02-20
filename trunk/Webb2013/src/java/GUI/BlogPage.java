
package GUI;

import Database.DBManager;
import Interface.iDBManager;

/**
 *
 * @author Josef
 */
public class BlogPage {
	
	iDBManager dbManager = new DBManager();
	
	String blogPage = "";
	
	public BlogPage(int blogID) {
		// Hämta senaste blogginlägget från nuvarande blogg från DB
		int postID = dbManager.getLatestBlogPost(blogID);
		String postTitle = dbManager.getBlogPostTitle(blogID, postID);
		String postContent = dbManager.getBlogPostContent(blogID, postID);
		String postDate = dbManager.getBlogPostDate(blogID, postID);
		String postAuthor = dbManager.getBlogPostAuthor(blogID, postID);
		
		constructPageContent(postTitle, postContent, postDate, postAuthor);
	}
	
	private void constructPageContent(String postTitle, String postContent,
																		String postDate, String postAuthor) {
		blogPage =
			"<div id=\"blog-content-box\">"+
				"<p id=\"blog-post-title\">"+postTitle+"</p>"+
				"<p id=\"blog-post-date\">Posted on: "+postDate+"</p>"+
				"<p id=\"blog-post-content\">"+postContent+"</p>"+
				"<p id=\"blog-post-author\">Written by: "+postAuthor+"</p>"+
			"</div>";
	}
	
	public String getBlogPage() {
		return blogPage;
	}
}
