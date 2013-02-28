<%--
    Document   : content
    Created on : 2013-feb-20, 16:25:43
    Author     : Josef

--%>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />

<div id="wrapper-west">

</div>
<div id="wrapper-center">
    <% if (request.getParameter("login") != null) {%>
    <% if (request.getParameter("login").equals("success")) {%>
    <p class="content-msg">Login successfull: <% out.println(user.getUserID() + ":" + user.getUsername() + "-" + user.getPassword());%></p>
    <% } else {%>
    <jsp:include page="login_form.jsp" />
    <% }%>
    <% } else if (request.getParameter("dbtlogin") != null) {%>
    <jsp:include page="dbt_login_form.jsp" />
    <% } else if (request.getParameter("register") != null) {%>
    <% if (request.getParameter("register").equals("success")) {%>
    <p class="content-msg">Registration successfull.</p>
    <% } else {%>
    <jsp:include page="register_form.jsp" />
    <% }%>
    <% } else if (request.getParameter("createblog") != null) {%>
    <jsp:include page="create_blog_form.jsp" />
    <% } else if (request.getParameter("blogid") != null) {%>
    <jsp:include page="blog_post.jsp" />
    <% } else if (request.getParameter("newBlogPost") != null) {%>
    <jsp:include page="new_blog_post.jsp" />
    <% if (user.getUserID() != "") {%>
    <br/>
    <jsp:include page="comments.jsp" />
    <% }%>
    <% } //else
            // Lista alla bloggar som finns registrerade i systemet?
%>
</div>
<div id="wrapper-east">
    <jsp:include page="sidebar.jsp" />
</div>
