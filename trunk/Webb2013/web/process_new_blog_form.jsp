<%-- 
    Document   : process_create_blog_form
    Created on : 2013-feb-25, 10:34:16
    Author     : Kerrai
--%>

<jsp:useBean id="createBlog" class="Bean.BlogData" scope="session" >
<jsp:setProperty name="createBlog" property="*" />
</jsp:useBean>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%@ page import="Logic.ProcessCreateBlogForm"
				 import="java.io.*"
				 import="java.util.*"
%>

<%
	ProcessCreateBlogForm process = new ProcessCreateBlogForm(createBlog, user);
        
	// Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>
