<%-- 
    Document   : sidebar
    Created on : 2013-feb-20, 16:57:05
    Author     : Josef
--%>

<%@page import="Logic.BlogInfo"%>
<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<%
	int[] idList = new int[0];
	String[] postList = new String[0];
	int blogID = blogData.getBlogid();
	if (!database.getLogin().equals("") &&
			!database.getPassword().equals("")) {
		BlogInfo blogInfo = new BlogInfo();
		idList = blogInfo.getAllBlogPostID(blogID);
		postList = blogInfo.getBlogPostList(blogID);
	}
%>
<div id="blogpost-list-box">
	<%
		if (blogData.getBlogid() > 0) {
	%>
		<p id="blogpost-list-title">Archive</p>
	<%
		}
		for (int i = postList.length-1; i >= 0; i--) {
			out.println("<a href=\"index.jsp?blogid="+blogID+"&postid="+idList[i]+"\">"+postList[i]+"</a>");
			out.println("<br/>");
		}
	%>
</div>