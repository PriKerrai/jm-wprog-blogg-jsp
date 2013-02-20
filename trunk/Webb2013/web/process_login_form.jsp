<%-- 
    Document   : process_login_form
    Created on : 2013-feb-20, 22:16:32
    Author     : Josef
--%>

<jsp:useBean id="user" class="Bean.UserData" scope="application" />
<jsp:setProperty name="user" property="*"/>
<%
	Logic.ProcessLoginForm process = new Logic.ProcessLoginForm(user);
	
	
%>