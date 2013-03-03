<%-- 
    Document   : blog_comment
    Created on : 2013-mar-01, 19:40:39
    Author     : Kerrai
--%>

<div id="blogpost-form-box">
	<p id="blogpost-form-title">Create new blog post</p>
  <form action="process_new_blog_post_form.jsp" method="post">
		<div>
			Headline
			<br/>
			<input id="blogpost-form-headline-input" type="text" name="blogheadline">
			<br/>
			Text
		</div>
		<div>
			<textarea id="blogpost-form-textarea" name="text"></textarea>
			<br/>
			<input type="submit" name="submit" value="Submit" />
			</div>
    </form>
</div>