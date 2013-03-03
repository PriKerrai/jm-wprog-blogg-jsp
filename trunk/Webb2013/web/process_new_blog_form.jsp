<%-- 
    Document   : process_create_blog_form
    Created on : 2013-feb-25, 10:34:16
    Author     : Kerrai
--%>

<%-- 
	Notera att detta inte är samma BlogData böna som används i t.ex.
	index.jsp och header.jsp.
--%>
<jsp:useBean id="newBlogData" class="Bean.BlogData" scope="session" />
<jsp:setProperty name="newBlogData" property="*" />
<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:useBean id="blogError" class="Bean.Error" scope="session" />

<%@ page import="Logic.ProcessCreateBlogForm"
				 import="java.io.*"
				 import="java.util.*"
%>

<%
	ProcessCreateBlogForm process = new ProcessCreateBlogForm();
	System.out.println("Blog: \""+newBlogData.getBlogname()+"\" : "+user.getPassword());
	if(!process.isValidBlogInput(newBlogData, user)) {
		System.out.println("IF");
		blogError.setError("Invalid blog name or password.");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?createblog=true");
	} else {
		System.out.println("ELSE");
		process.registerBlog(newBlogData, user);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?createblog=success");
	}
%>
