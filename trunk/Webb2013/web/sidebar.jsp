<%-- 
    Document   : sidebar
    Created on : 2013-feb-20, 16:57:05
    Author     : Josef
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="Logic.Post" %>
<%@page import="Logic.BlogInfo" %>

<jsp:useBean id="database" class="Bean.DatabaseLoginData" scope="application" />
<jsp:useBean id="blogData" class="Bean.BlogData" scope="session" />

<%
	int blogID = blogData.getBlogid();
	if (!database.getLogin().equals("") &&
			!database.getPassword().equals("")) {
		BlogInfo blogInfo = new BlogInfo();
		int[] idList = blogInfo.getAllBlogPostID();
		Post[] postList = blogInfo.getBlogPostList();
%>
		<div id="blogpost-list-box">
		<p id="blogpost-list-title">Archive</p>
<% 
		for (int i = postList.length-1; i >= 0; i--) {
			out.println(
				"<div class=\"blogpost-box\">"
					+"<a href=\"index.jsp?blogid="+postList[i].getUserID()+"&postid="+idList[i]+"\">"
						+postList[i].getHeadline()
					+"</a>"
					+"<p class=\"blogpost-author\">"
						+postList[i].getAuthor()
					+"</p>"
					+"<p class=\"blogpost-numcomments\">"
						+postList[i].getNumComments()+" comments"
					+"</p>"
				+"</div>"
				+"<br/>"
			);
		}
%>
		</div>
<% 
	}
%>