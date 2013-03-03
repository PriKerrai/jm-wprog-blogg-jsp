<%-- 
    Document   : comment_form
    Created on : 2013-mar-03, 21:28:34
    Author     : Kerrai
--%>

<div id="comment-form-box">
    <p id="comment-form-title">Write a new comment</p>
    <form action="process_blog_comment_form.jsp" method="post">
        <div>
            <textarea id="comment-form-textarea" name="comment"></textarea>
            <input type="hidden" name="postid" value="<%= request.getParameter("postid") %>" />
            <br/>
            <input type="submit" name="submit" value="Submit" />
        </div>
    </form>
</div>