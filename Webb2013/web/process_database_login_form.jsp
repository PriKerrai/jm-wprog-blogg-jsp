<%-- 
    Document   : process_database_login_form
    Created on : 2013-feb-21, 12:25:57
    Author     : Kerrai
--%>

<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<jsp:setProperty name="database" property="*" />

<%@ page import="Logic.ProcessDatabaseLogin"
				 import="java.io.*"
				 import="java.util.*"
%>

<%
        ProcessDatabaseLogin process = new ProcessDatabaseLogin(database);
        
        // Redirect user back to index
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	response.setHeader("Location", "index.jsp"); 
%>

