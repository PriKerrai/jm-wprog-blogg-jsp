<%--
    Document   : content
    Created on : 2013-feb-20, 16:25:43
    Author     : Josef
--%>
<div id="wrapper-west">
	
</div>
<div id="wrapper-center">
	<jsp:useBean id="user" class="Bean.UserData" scope="application" />
	<%
		if (request.getParameter("login") != null) {
			out.println(new GUI.LoginForm().getLoginForm());
		} else if (request.getParameter("register") != null) {
			out.println(new GUI.RegisterForm().getRegisterForm());
                } else {
			// Print blogg post content
			out.println(new GUI.BlogPage(1).getBlogPage());
			if (user.getUserID() != null) {
				out.println("<br />");
				// Print blogg comment form
				out.println("Comment section");
			}
		}
	%>
</div>
<div id="wrapper-east">
	<jsp:include page="sidebar.jsp" />
</div>