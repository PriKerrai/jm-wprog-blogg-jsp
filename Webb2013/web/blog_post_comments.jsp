<%-- 
    Document   : comments
    Created on : 2013-feb-26, 17:25:08
    Author     : Josef
--%>

<%@page import="Database.DBManager"%>
<%@page import="Interface.iDBManager"%>
<%@page import="Logic.Comment"%>
<%@page import="Logic.BlogInfo"%>

<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<div id="comments-box">
	<p id="comments-title">Comments</p>
  <%
		BlogInfo blogInfo = new BlogInfo();
		
		// Hämta senaste blogginlägget från nuvarande blogg från DB
		int postID = blogInfo.getLatestBlogPost(blogData.getBlogid());
		if (request.getParameter("postid") != null)
			postID = Integer.parseInt(request.getParameter("postid"));
		
    int[] idList = blogInfo.getAllCommentID(postID);
    Comment[] commentList = blogInfo.getAllComments(postID);
      
    if (commentList.length > 0) {
			for (int i = 0; i < commentList.length; i++)
				out.println(
					"<div class=\"comment-box\">"
          + "<p class=\"comment-user\">"+commentList[i].getUser()+"</p>"
          + "<p class=\"comment-text\">"+commentList[i].getText()+"</p>"
          + "<p class=\"comment-date\">"+commentList[i].getDate()+"</p>"
          + "</div>"
          + "<br/>"
        );
    }
	%>
</div>
