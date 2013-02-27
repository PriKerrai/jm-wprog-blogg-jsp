<%-- 
    Document   : login_form.jsp
    Created on : 2013-feb-24, 20:13:47
    Author     : Josef
--%>
<jsp:useBean id="registerError" class="Bean.Error" scope="session" />

<div id="login-form-box">
	<p id="login-form-title">Login</p>
	<% if (!registerError.getError().equals("")) { %>
		<p><% out.println("Error: "+registerError.getError()); %></p>
	<% } %>
	<form action="process_login_form.jsp" method="post">
		<div id="login-form-text-box">
			Username: 
			<br />
			Password:
		</div>
		<div id="login-form-input-box">
			<input type="text" name="username" value="" />
			<br />
			<input type="password" name="password" value="" />
		</div>
		<div class="clear"></div>
		<button type="submit">Submit</button>
	</form>
</div>
