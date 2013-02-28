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
	
	int blogID;
	String blogPage = "";
	
	if (request.getParameter("blogid") != null) {
		blogID = Integer.parseInt(request.getParameter("blogid"));
		
		// Hämta senaste blogginlägget från nuvarande blogg från DB
		int postID = dbManager.getLatestBlogPost(blogID);
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
	} else
		out.println("Something went wrong");
	
%>
