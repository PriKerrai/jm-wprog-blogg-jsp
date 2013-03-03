<%-- 
    Document   : comments
    Created on : 2013-feb-26, 17:25:08
    Author     : Josef
--%>

<%@page import="Logic.Comment"%>
<%@page import="Logic.BlogInfo"%>

<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<div id="comemnts-box">
    <p id="comments-title">Comments</p>
    <%
      int postID = Integer.parseInt(request.getParameter("postid"));
      BlogInfo blogInfo = new BlogInfo();
      int[] idList = blogInfo.getAllCommentID(postID);
      Comment[] commentList = blogInfo.getAllComments(blogData.getBlogid(), postID);
      
      if (commentList.length > 0) {
        for (int i = 0; i < commentList.length; i++)
            out.println(
                "<div class=\"comment-box\">"
                + "<p class=\"comment-user\">"+commentList[i].getUser()
                + "<p class=\"comment-text\">"+commentList[i].getText()
                + "<p class=\"comment-date\">"+commentList[i].getDate()
                + "</div>"
            );
      }
    %>
</div>
<div id="comment-form-box">
    <p id="comment-form-title">Write a new comment</p>
    <form action="process_blog_comment_form.jsp" method="post">
        <div>
            <textarea id="comment-textarea" name="comment"></textarea>
            <input type="hidden" name="postid" value="<%= request.getParameter("postid") %>" />
            <br/>
            <input type="submit" name="submit" value="Submit" />
        </div>
    </form>
</div>
