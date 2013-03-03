<%-- 
    Document   : header
    Created on : 2013-feb-20, 16:21:25
    Author     : Josef
--%>
<%@page import="Logic.BlogInfo" %>

<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<%
	int blogID = blogData.getBlogid();
%>
<a id="blog-title"
	 href="index.jsp<% if(blogID > 0) out.println("?blogid="+blogID); %>"
>
	<%= blogData.getBlogname() %>
</a>
<div id="nav-bar-content">
	<ul>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="?register=true">Register</a></li>
		<% if (user.getUserid() < 1) { %>
			<li><a href="?login=true">Login</a></li>
		<% } else { %>
			<li>
				<form action="logout.jsp">
					<button id="logout-button" type="submit">Logout</button>
				</form>
			</li>
		<% } %>
		<% if (database.getLogin().equals("") && database.getPassword().equals("")) { %>
			<li><a href="?dbtlogin=true">Dbt Login</a></li>
		<% } %>
		<% if (user.getUserid() > 0 && !user.getBlog().equals("")) { %>
			<li> <a href="?createpost=true">New blog post</a></li>
    <% } %>
		<% if (user.getUserid() > 0 && user.getBlog().equals("")) { %>
			<li id="nav-bar-createblog"><a href="?createblog=true">Create Blog</a></li>
		<% } %>
	</ul>
	<div class="clear"></div>
</div>
<hr />
