<%--
    Document   : content
    Created on : 2013-feb-20, 16:25:43
    Author     : Josef
--%>

<div id="wrapper-west">
	
</div>
<div id="wrapper-center">
	<%
		if (request.getParameter("login") != null) {
			out.println(new GUI.LoginForm().getLoginForm());
		} else if (request.getParameter("register") != null) {
			out.println(new GUI.RegisterForm().getRegisterForm());
		}
	%>

</div>
<div id="wrapper-east">
	<jsp:include page="sidebar.jsp" />
</div>
