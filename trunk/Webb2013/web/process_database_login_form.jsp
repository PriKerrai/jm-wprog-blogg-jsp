<%-- 
    Document   : process_database_login_form
    Created on : 2013-feb-21, 12:25:57
    Author     : Kerrai
--%>

<%@ page import="Logic.ProcessDatabaseLogin"
				 import="java.io.*"
				 import="java.util.*"
%>

<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<%--
		<jsp:setProperty name="database" property="*" /> 
		Doesn't work here for some reason, so we had to use the below 
		mix of code instead as a last resort ...
--%>
<% 
	String login, password;
	login = request.getParameter("login");
	password = request.getParameter("password");
%>
<jsp:setProperty name="database" property="login" value="<%= login %>" />
<jsp:setProperty name="database" property="password" value="<%= password %>" />
<jsp:useBean id="dbtError" class="Bean.Error" scope="session" />

<%
	ProcessDatabaseLogin process = new ProcessDatabaseLogin();

	database.setLogin(request.getParameter("login"));
	database.setPassword(request.getParameter("password"));
	
	if (!process.connect(database)) {
		dbtError.setError("Could not connect to database, please try again.");
%>
		<jsp:setProperty name="database" property="login" value="" />
		<jsp:setProperty name="database" property="password" value="" />
<%
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?dbtlogin=true");
	} else {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?dbtlogin=success");
	}
%>

