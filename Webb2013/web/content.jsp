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
		String contentPage = "";
		String commentBox = "";
		if (request.getParameter("login") != null) {
			contentPage = "login_form.jsp";
		} else if (request.getParameter("register") != null) {
			contentPage = "register_form.jsp";
    } else {
			// Print blogg post content
			contentPage = "blog_post.jsp";
			if (user.getUserID() != null) {
				out.println("<br />");
				// Print blogg comment form
				//commentBox = "comment_box.jsp";
				out.println("Comment section ");
			}
		}
	%>
	<jsp:include page="<%= contentPage %>" />
	<jsp:include page="<%= commentBox %>" />
</div>
<div id="wrapper-east">
	<jsp:include page="sidebar.jsp" />
</div>