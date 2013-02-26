<%-- 
    Document   : dbt_login_form
    Created on : 2013-feb-26, 17:16:01
    Author     : Martin
--%>

<div id="dbtlogin-form-box">
	<p id="dbtlogin-form-title">Database Login</p>
	<form action="process_database_login_form.jsp" method="post">
		<div id="dbtlogin-form-text-box">
			Database Login
			<br/>
      <input type="text" name="databaseLogin">
			<br/>
      Database Password
			<br/>
      <input type="password" name="databasePassword">
			<br/>
      <input type="submit" name="submit" value="Submit" />
		</div>
	</form>
</div>
