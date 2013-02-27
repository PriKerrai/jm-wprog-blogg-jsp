<%-- 
    Document   : register_form
    Created on : 2013-feb-25, 14:42:09
    Author     : Josef
--%>

<jsp:useBean id="registerError" class="Bean.Error" scope="session" />

<div id="register-form-box">
	<p id="register-form-title">Register</p>
	<form action="process_register_form.jsp" method="post">
		<div id="register-form-text-box">
			UserID:
			<br />
			Username:
			<br />
			Password:
		</div>
		<div id="register-form-input-box">
			<input type="text" name="userid" value="" />
			<br />
			<input type="text" name="username" value="" />
			<br />
			<input type="password" name="password" value="" />
		</div>
		<div class="clear"></div>
		<button type="submit">Submit</button>
	</form>
</div>
<% if (!registerError.getError().equals("")) { %>
	<p class="error-msg"><% out.println("Error: "+registerError.getError()); %></p>
<% } %>
<% registerError.setError(""); %>