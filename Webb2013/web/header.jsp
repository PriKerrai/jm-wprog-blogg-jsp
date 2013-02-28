<%-- 
    Document   : header
    Created on : 2013-feb-20, 16:21:25
    Author     : Josef
--%>
<jsp:useBean id="user" class="Bean.UserData" scope="session" />
<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />

<a id="blog-title" href="?index=true"><% out.print("Insert Blog Title");%></a>
<div id="nav-bar-content">
    <ul>
        <li><a href="?index=true">Home</a></li>
        <li><a href="?register=true">Register</a></li>
        <% if (user.getUserID().equals("")) {%>
        <li><a href="?login=true">Login</a></li>
        <% } else {%>
        <li>
            <form action="logout.jsp">
                <button id="logout-button" type="submit">Logout</button>
            </form>
        </li>
        <% }%>
        <% if (database.getDatabaseLogin().equals("") && database.getDatabasePassword().equals("")) {%>
        <li><a href="?dbtlogin=true">Dbt Login</a></li>
        <% }%>
        <%// if(user.getUserID() != "") { %>
        <li> <a href="?newBlogPost=true">New blog post</a></li>
        <%// } %>
        <%// if(user.getUserID() != "") { %>
        <li id="nav-bar-createblog"><a href="?createblog=true">Create Blog</a></li>
        <%// } %>

    </ul>
    <div class="clear"></div>
</div>
<hr />
