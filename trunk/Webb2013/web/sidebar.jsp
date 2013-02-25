<%-- 
    Document   : sidebar
    Created on : 2013-feb-20, 16:57:05
    Author     : Josef
--%>



<div id="databaselogin-form-box">
    <p id="databaselogin-form-title">Database Login</p>
    <form action="process_database_login_form.jsp" method="post">
        <div id="databaselogin-form-text-box">
            Database Login 
            <input type="login" name="databaseLogin">
            <br />
            Database Password 
            <input type="password" name="databasePassword">
            <input type="submit" name="submit" value="Login" />
        </div>

    </form>
</div> 