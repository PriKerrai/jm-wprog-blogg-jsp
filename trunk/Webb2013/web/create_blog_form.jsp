<%-- 
    Document   : create_blog_form
    Created on : 2013-feb-24, 20:14:00
    Author     : Kerrai
--%>

<div id="createblog-form-box">
	<h1 id="createblog-form-title">Create Blog</h1>
  <form action="process_create_blog_form.jsp" method="post">
		<div id="createblog-form-text-box">
			Name your blog:
			<input type="text" name="blogName">
			<br />
			Please enter your password:
			<input type="password" name="databasePassword">
			<br />
			<input type="submit" name="submit" value="Submit" />
		</div>
	</form>
</div>
