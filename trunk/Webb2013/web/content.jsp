<%--
    Document   : content
    Created on : 2013-feb-20, 16:25:43
    Author     : Josef

--%>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="session" />

<div id="wrapper-west">

</div>
<div id="wrapper-center">
	<% if (request.getParameter("login") != null) { %>
		<% if (request.getParameter("login").equals("success")) { %>
			<h1 class="content-page-title">Login successfull</h1>
			<p class="content-msg">Loged in as <%= user.getUsername() %></p>
		<% } else { %>
			<jsp:include page="login_form.jsp" />
		<% } %>
	<% } else if (request.getParameter("dbtlogin") != null) { %>
		<% if (request.getParameter("dbtlogin").equals("success")) { %>
			<h1 class="content-page-title">Database login successfull</h1>
			<p class="content-msg">Loged in @ <%= database.getLogin() %></p>
		<% } else {%>
			<jsp:include page="dbt_login_form.jsp" />
		<% } %>
	<% } else if (request.getParameter("register") != null) { %>
		<% if (request.getParameter("register").equals("success")) { %>
			<h1 class="content-page-title">Registration successfull</h1>
			<p class="content-msg">
				<% out.println(user.getUserid()+" : "+user.getUsername()+" : "+user.getPassword()); %>
			</p>
		<% } else { %>
			<jsp:include page="register_form.jsp" />
		<% } %>
	<% } else if (request.getParameter("createblog") != null) { %>
		<jsp:include page="create_blog_form.jsp" />
	<% } else if (request.getParameter("createpost") != null) { %>
    <jsp:include page="blog_post_form.jsp" />
	<% } else if (request.getParameter("blogid") != null) { %>
		<jsp:include page="blog_post.jsp" />
		<% if (user.getUserid() != "") { %>
			<br/>
			<jsp:include page="blog_post_comments.jsp" />
		<% } %>
	<% } else { %>
		<jsp:include page="blog_list.jsp" />
	<% } %>
</div>
<div id="wrapper-east">
    <jsp:include page="sidebar.jsp" />
</div>
<div class="clear"></div>