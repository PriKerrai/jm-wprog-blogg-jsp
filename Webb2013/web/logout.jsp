<%-- 
    Document   : logout.jsp
    Created on : 2013-feb-27, 14:55:28
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:setProperty name="user" property="userid" value="-1" />
<jsp:setProperty name="user" property="useralias" value="" />
<jsp:setProperty name="user" property="username" value="" />
<jsp:setProperty name="user" property="password" value="" />

<%
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>
