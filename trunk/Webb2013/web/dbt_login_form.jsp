<%-- 
    Document   : dbt_login_form
    Created on : 2013-feb-26, 17:16:01
    Author     : Martin
--%>

<jsp:useBean id="dbtError" class="Bean.Error" scope="session" />

<div id="dbtlogin-form-box">
	<h1 id="dbtlogin-form-title">Database Login</h1>
	<form action="process_database_login_form.jsp" method="post">
		<div>
			Database Login
			<br/>
      <input type="text" name="login">
			<br/>
      Database Password
			<br/>
      <input type="password" name="password">
			<br/>
      <input type="submit" name="submit" value="Submit" />
		</div>
	</form>
</div>
<% if (!dbtError.getError().equals("")) { %>
	<p class="error-msg"><% out.println("Error: "+dbtError.getError()); %></p>
<% } %>
<% dbtError.setError(""); %>