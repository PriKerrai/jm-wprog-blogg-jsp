<%-- 
    Document   : process_new_blog_post
    Created on : 2013-feb-28, 18:10:18
    Author     : Kerrai
--%>

<jsp:useBean id="newblogentry" class="Bean.BlogPost" scope="session" >
<jsp:setProperty name="newblogentry" property="*" />
</jsp:useBean>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%@ page import="Logic.ProcessNewBlogPostForm"
				 import="java.io.*"
				 import="java.util.*" 
%>

<%
	ProcessNewBlogPostForm process = new ProcessNewBlogPostForm(newblogentry, user);
	
        // Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>