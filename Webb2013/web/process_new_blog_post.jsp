<%-- 
    Document   : process_new_blog_post
    Created on : 2013-feb-28, 18:10:18
    Author     : Kerrai
--%>

<jsp:useBean id="createBlog" class="Bean.BlogPost" scope="session" >
<jsp:setProperty name="createBlog" property="*" />
</jsp:useBean>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%@ page import="Logic.ProcessNewBlogPost"
				 import="java.io.*"
				 import="java.util.*" 
%>

<%
	ProcessNewBlogPost process = new ProcessNewBlogPost(createBlog, user);
	
        // Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>