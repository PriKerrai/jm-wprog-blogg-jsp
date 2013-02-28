<%-- 
    Document   : create_blog_form
    Created on : 2013-feb-24, 20:14:00
    Author     : Kerrai
--%>

<div id="blog-post-box">
    <p id="blog-post-title">Create new blog post</p>
    <form action="process_new_blog_post.jsp" method="post">
        <div id="blog-post-box">
            Headline of new blog message
            <input type="text" name="blogHeadline">
            <br />
            Blog Text
        </div>
        <div>
        <textarea id="commentBox" name="blogText">Skriv skit här</textarea>
        <input type="submit" name="submit" value="Submit" />
 </form>
</div>
</div>