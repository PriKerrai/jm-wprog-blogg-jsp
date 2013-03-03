<%-- 
    Document   : blog_post.jsp
    Created on : 2013-feb-24, 20:20:40
    Author     : Josef
--%>

<%@ page import="Interface.iDBManager"
				 import="Database.DBManager"
%>
<%
	
	iDBManager dbManager = new DBManager();
	
	int blogID, postID = 0;
	String blogPage = "";
	
	if (request.getParameter("blogid") != null) {
		blogID = Integer.parseInt(request.getParameter("blogid"));
		
		// Hämta senaste blogginlägget från nuvarande blogg från DB
		postID = dbManager.getMaxBlogPostID(blogID);
		
		if (request.getParameter("postid") != null) {
			// Om post id finns i url fältet, hämta denna post
			postID = Integer.parseInt(request.getParameter("postid"));
		}
		
		if (postID > 0) {
			String postTitle = dbManager.getBlogPostTitle(blogID, postID);
			String postContent = dbManager.getBlogPostContent(blogID, postID);
			String postDate = dbManager.getBlogPostDate(blogID, postID);
			String postAuthor = dbManager.getBlogPostAuthor(blogID, postID);

			blogPage =
				"<div id=\"blog-post-content-box\">"+
					"<p id=\"blog-post-title\">"+postTitle+"</p>"+
					"<p id=\"blog-post-date\">Posted on: "+postDate+"</p>"+
					"<p id=\"blog-post-content\">"+postContent+"</p>"+
					"<p id=\"blog-post-author\">Written by: "+postAuthor+"</p>"+
				"</div>";

			out.println(blogPage);
		} else {
			out.println("<h1 class=\"content-page-title\">This blog is empty</h1>");
			out.println("<p class=\"content-msg\">This user has not yet posted anything on his/her blog.</p>");
		}
	} else
		out.println("Something went wrong");
%>
