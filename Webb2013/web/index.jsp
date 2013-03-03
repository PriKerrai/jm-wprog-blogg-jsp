<%-- 
    Document   : index
    Created on : 2013-feb-19, 18:44:33
    Author     : Josef Holmér, Martin Nilsson
--%>
<%@page import="Logic.BlogInfo"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%
	BlogInfo blogInfo = new BlogInfo();
	if (request.getParameter("blogid") != null) {
		if (!database.getLogin().equals("") &&
				!database.getPassword().equals("")) {
			int blogID = Integer.parseInt(request.getParameter("blogid"));
			String blogName = blogInfo.getBlogName(blogID);
			blogData.setBlogid(blogID);
			blogData.setBlogname(blogName);
%>
			<jsp:setProperty name="blogData" property="blogid" value="<%= blogID %>" />
			<jsp:setProperty name="blogData" property="blogname" value="<%= blogName %>" />
<%
		}
	} else {
		blogData.setBlogid(-1);
		blogData.setBlogname("Blogimus");
%>
		<jsp:setProperty name="blogData" property="blogid" value="-1" />
		<jsp:setProperty name="blogData" property="blogname" value="Blogimus" />
<%
	}
%>

<!DOCTYPE html>
<html>
    <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
			<link rel="stylesheet" type="text/css" href="obsidian.css" />
    </head>
		
    <body>
				
		<div id="wrapper">
			<div id="wrapper-north">
				<jsp:include page="header.jsp" />
			</div>
			<div id="center-wrapper">
				<jsp:include page="content.jsp" />
			</div>
			<div id="wrapper-south">
				<jsp:include page="footer.jsp" />
			</div>
		</div>
			
    </body>
		
</html>
