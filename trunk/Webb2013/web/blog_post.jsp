<%-- 
    Document   : blog_post.jsp
    Created on : 2013-feb-24, 20:20:40
    Author     : Josef
--%>

<%@page import="Logic.BlogInfo"%>
<%@page import="Logic.BlogPostInfo"%>

<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<%
	BlogInfo blogInfo = new BlogInfo();
	BlogPostInfo postInfo = new BlogPostInfo();

	int blogID = 0, postID = 0;
	String blogPage = "";
	
	if (blogData.getBlogid() > 0) {
		blogID = blogData.getBlogid();
		
		// Hämta senaste blogginlägget från nuvarande blogg från DB
		postID = blogInfo.getLatestBlogPost(blogID);
		
		if (request.getParameter("postid") != null) {
			// Om post id finns i url fältet, hämta denna post
			postID = Integer.parseInt(request.getParameter("postid"));
		}
		
		if (postID > 0) {
			String postTitle = postInfo.getBlogPostTitle(postID);
			String postContent = postInfo.getBlogPostContent(postID);
			String postDate = postInfo.getBlogPostDate(postID);
			String postAuthor = postInfo.getBlogPostAuthor(blogID);

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
