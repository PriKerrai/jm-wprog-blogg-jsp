<%-- 
    Document   : process_register_form
    Created on : 2013-feb-20, 22:23:10
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="application" />
<jsp:setProperty name="user" property="*"/>

<%@ page import="Logic.ProcessRegisterForm"
				 import="java.io.*"
				 import="java.util.*" 
%>
<%
	ProcessRegisterForm process = new ProcessRegisterForm(user);
	
	// Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>
