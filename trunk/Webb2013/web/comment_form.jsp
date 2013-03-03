<%-- 
    Document   : comment_form
    Created on : 2013-mar-03, 21:28:34
    Author     : Kerrai
--%>
<%@page import="Database.DBManager"%>
<%@page import="Interface.iDBManager"%>

<%
	iDBManager dbManager = new DBManager();
	
	int blogID = Integer.parseInt(request.getParameter("blogid"));
	// Hämta senaste blogginlägget från nuvarande blogg från DB
	int postID = dbManager.getLatestBlogPost(blogID);
	if (request.getParameter("postid") != null)
		postID = Integer.parseInt(request.getParameter("postid"));
%>
<div id="comment-form-box">
    <p id="comment-form-title">Write a new comment</p>
    <form action="process_blog_comment_form.jsp" method="post">
        <div>
            <textarea id="comment-form-textarea" name="comment"></textarea>
            <input type="hidden" name="postid" value="<%= postID %>" />
            <br/>
            <input type="submit" name="submit" value="Submit" />
        </div>
    </form>
</div>