<%-- 
    Document   : blog_comment
    Created on : 2013-mar-01, 19:40:39
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
        <textarea id="blogPost" name="blogText">Skriv skit här</textarea>
        <input type="submit" name="submit" value="Submit" />
 </form>
</div>
</div>