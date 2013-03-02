<%-- 
    Document   : comments
    Created on : 2013-feb-26, 17:25:08
    Author     : Josef
--%>

<div id="comments-box">
	<%
		
		// Fetch le comments
	%>
	<p id="comments-box-title">Comment the post</p>
  <form action="process_blog_comment_form.jsp" method="post">
		<div>
			<textarea id="comment-textarea" name="blogComment"></textarea>
			<br/>
      <input type="submit" name="submit" value="Submit" />
		</div>
	</form>
</div>
