<%-- 
    Document   : header
    Created on : 2013-feb-20, 16:21:25
    Author     : Josef
--%>
<jsp:useBean id="user" class="Bean.UserData" scope="page" />

<a id="blog-title" href="?index=true"><% out.print("Insert Blog Title"); %></a>
<div id="nav-bar-content">
	<ul>
		<li><a href="?index=true">Home</a></li>
		<li><a href="?login=true">Login</a></li>
		<li><a href="?register=true">Register</a></li>
		<li><a href="?dbtlogin=true">Dbt Login</a></li>
		<% //if(user.getUserID() != "") { %>
			<li id="nav-bar-createblog"><a href="?createblog=true">Create Blog</a></li>
		<% //} %>
	</ul>
	<div class="clear"></div>
</div>
<hr />
