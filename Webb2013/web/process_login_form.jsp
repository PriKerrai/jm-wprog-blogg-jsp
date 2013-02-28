<%-- 
    Document   : process_login_form
    Created on : 2013-feb-20, 22:16:32
    Author     : Josef
--%>

<%@ page import="Logic.ProcessLoginForm"
				 import="java.io.*"
				 import="java.util.*"
%>

<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:setProperty name="user" property="*" />
<jsp:useBean id="loginError" class="Bean.Error" scope="session" />

<%
	ProcessLoginForm process = new ProcessLoginForm();
	user = process.login(user);
%>
	<jsp:setProperty name="user" property="userid" value="<%= user.getUserid() %>" />
	<jsp:setProperty name="user" property="username" value="<%= user.getUsername() %>" />
	<jsp:setProperty name="user" property="password" value="<%= user.getPassword() %>" />
<%
	if (user.getUserid().equals("")) {
		loginError.setError("Invalid username or password.");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?login=true");
	} else {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?login=success");
	}
%>