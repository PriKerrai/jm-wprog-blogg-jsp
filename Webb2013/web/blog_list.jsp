<%-- 
    Document   : blog_list
    Created on : 2013-mar-02, 09:42:34
    Author     : Josef
--%>

<%@ page import="Logic.BlogInfo" %>

<%
	BlogInfo blogInfo = new BlogInfo();
	int[] idList = blogInfo.getAllBlogID();
	String[] blogList = blogInfo.getBlogList();
%>
<h1 class="content-page-title">Registered Blogs</h1>
<div id="blog-list-box">
    <%
        if (blogList.length > 0) {
            for (int i = 0; i < blogList.length; i++)
                out.println("<a href=\"index.jsp?blogid="+idList[i]+"\">"+blogList[i]+"</a><br/>");
        } else
            out.println("<p class=\"content-msg\">There are currently no registered blogs.</p>");
    %>
</div>