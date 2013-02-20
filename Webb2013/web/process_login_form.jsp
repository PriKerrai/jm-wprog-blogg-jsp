<%-- 
    Document   : process_login_form
    Created on : 2013-feb-20, 22:16:32
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="application" />
<jsp:setProperty name="user" property="*"/>

<%@ page import="Logic.ProcessLoginForm"
				 import="java.io.*"
				 import="java.util.*" 
%>
<%
	ProcessLoginForm process = new ProcessLoginForm(user);
	
	// Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>