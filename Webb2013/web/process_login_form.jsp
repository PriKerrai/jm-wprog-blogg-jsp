<%-- 
    Document   : process_login_form
    Created on : 2013-feb-20, 22:16:32
    Author     : Josef
--%>

<jsp:useBean id="userLogin" class="Bean.UserData" scope="session" />
<jsp:setProperty name="userLogin" property="*" />
<jsp:useBean id="loginError" class="Bean.Error" scope="session" />

<%@ page import="Logic.ProcessLoginForm"
				 import="java.io.*"
				 import="java.util.*" 
%>

<%
	ProcessLoginForm process = new ProcessLoginForm();
	userLogin = process.login(userLogin);
	
	if (userLogin.getUserID().equals("")) {
		loginError.setError("Invalid username or password.");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?login=true");
	} else {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?login=success");
	}
%>