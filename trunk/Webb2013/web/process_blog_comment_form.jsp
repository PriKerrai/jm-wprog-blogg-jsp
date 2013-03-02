<%-- 
    Document   : process_new_blog_post
    Created on : 2013-feb-28, 18:10:18
    Author     : Kerrai
--%>

<jsp:useBean id="blogComment" class="Bean.BlogComment" scope="session" >
<jsp:setProperty name="blogComment" property="*" />
</jsp:useBean>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<%@ page import="Logic.ProcessBlogCommentForm"
				 import="java.io.*"
				 import="java.util.*" 
%>

<%
	ProcessBlogCommentForm process = new ProcessBlogCommentForm(user, blogData, blogComment);
	
  // Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>