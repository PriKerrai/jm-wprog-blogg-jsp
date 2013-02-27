<%-- 
    Document   : process_register_form
    Created on : 2013-feb-20, 22:23:10
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:setProperty name="user" property="*"/>
<jsp:useBean id="registerError" class="Bean.Error" scope="session" />

<%@ page import="Logic.ProcessRegisterForm"
				 import="java.io.*"
				 import="java.util.*" 
%>

<%
	ProcessRegisterForm process = new ProcessRegisterForm();
	if (!process.isValidRegInput(user)) {
		registerError.setError("UserID and/or Username already in use.");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp?register=true");
	} else {
		registerError.setError("");
		process.registerUser(user);
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "index.jsp");
	}
%>
