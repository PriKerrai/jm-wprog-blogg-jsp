<%-- 
    Document   : create_blog_form
    Created on : 2013-feb-24, 20:14:00
    Author     : Kerrai
--%>





<div id="login-form-text-box">
    <p id="login-form-title">Database Login</p>
    <form action="process_create_blog_form.jsp" method="post">
        <div id="login-form-text-box">
            Name your blog
            <input type="createBlog" name="blogName">
            <br />
            Please enter account password 
            <input type="password" name="databasePassword">
            <input type="submit" name="submit" value="Login" />
        </div>

    </form>
</div>
