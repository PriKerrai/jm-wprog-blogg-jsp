<%-- 
    Document   : process_register_form
    Created on : 2013-feb-20, 22:23:10
    Author     : Josef
--%>

<%@ page import="Logic.ProcessRegisterForm"
				 import="java.io.*"
				 import="java.util.*" 
%>

<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:setProperty name="user" property="*" />
<jsp:useBean id="registerError" class="Bean.Error" scope="session" />

<%
	ProcessRegisterForm process = new ProcessRegisterForm();
	
	if (!process.isValidRegInput(user)) {
		registerError.setError("User alias and/or username already in use.");
%>
		<jsp:setProperty name="user" property="userid" value="-1" />
		<jsp:setProperty name="user" property="useralias" value="" />
		<jsp:setProperty name="user" property="username" value="" />
		<jsp:setProperty name="user" property="password" value="" />
<%
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?register=true");
	} else {
		process.registerUser(user);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?register=success");
	}
%>
