<%-- 
    Document   : process_create_blog_form
    Created on : 2013-feb-25, 10:34:16
    Author     : Kerrai
--%>

<%-- 
	Notera att detta inte är samma BlogData böna som används i t.ex.
	index.jsp och header.jsp.
--%>
<jsp:useBean id="newBlogData" class="Bean.BlogData" scope="session" >
<jsp:setProperty name="newBlogData" property="*" />
</jsp:useBean>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%@ page import="Logic.ProcessCreateBlogForm"
				 import="java.io.*"
				 import="java.util.*"
%>

<%
	ProcessCreateBlogForm process = new ProcessCreateBlogForm(newBlogData, user);
        
	// Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>
