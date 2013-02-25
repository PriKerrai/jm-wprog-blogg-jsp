<%-- 
    Document   : index
    Created on : 2013-feb-19, 18:44:33
    Author     : Josef Holmér, Martin Nilsson
--%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>JSP Page</title>
			<link rel="stylesheet" type="text/css" href="obsidian.css" />
    </head>
		
    <body>
				
		<div id="wrapper">
			<div id="wrapper-north">
				<jsp:include page="header.jsp" />
			</div>
			<div id="center-wrapper">
				<jsp:include page="content.jsp" />
			</div>
			<div id="wrapper-south">
				<jsp:include page="footer.jsp" />
			</div>
		</div>
			
    </body>
		
</html>
