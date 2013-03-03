<%-- 
    Document   : sidebar
    Created on : 2013-feb-20, 16:57:05
    Author     : Josef
--%>

<%@page import="Logic.BlogInfo"%>
<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />

<%
	int[] idList = new int[0];
	String[] postList = new String[0];
	int blogID = -1;
	if (request.getParameter("blogid") != null &&
			!database.getLogin().equals("") &&
			!database.getPassword().equals("")) {
		blogID = Integer.parseInt(request.getParameter("blogid"));
		
		BlogInfo blogInfo = new BlogInfo();
		idList = blogInfo.getAllBlogPostID(blogID);
		postList = blogInfo.getBlogPostList(blogID);
	}
%>
<div id="blogpost-list-box">
	<%
		for (int i = 0; i < postList.length; i++)
			out.println("<a href=\"index.jsp?blogid="+blogID+"&postid="+idList[i]+"\">"+postList[i]+"</a>");
	%>
</div>