<%-- 
    Document   : logout.jsp
    Created on : 2013-feb-27, 14:55:28
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<%
	user.setUserID("");
	user.setUsername("");
	user.setPassword("");
	
	// Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>
