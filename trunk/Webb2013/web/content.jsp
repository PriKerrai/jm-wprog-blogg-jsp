<%--
    Document   : content
    Created on : 2013-feb-20, 16:25:43
    Author     : Josef
--%>
<div id="wrapper-west">

</div>
<div id="wrapper-center">
	<jsp:useBean id="user" class="Bean.UserData" scope="application" />
<%	if (request.getParameter("login") != null) { %>
			<jsp:include page="login_form.jsp" />
<%	} else if (request.getParameter("register") != null) { %>
			<jsp:include page="register_form.jsp" />
<%	} else if (request.getParameter("createblog") != null) { %>
			<jsp:include page="create_blog_form.jsp" />
<%	} else if (request.getParameter("blogid") != null) { %>
			<jsp:include page="blog_post.jsp" />
<%		if (user.getUserID() != "") {
				out.println("<br />");
				//<jsp:include page="comments.jsp" />
				out.println("Comment section");
			}
		} else
			out.print("Something");
%>
</div>
<div id="wrapper-east">
	<jsp:include page="sidebar.jsp" />
</div>
