<%@page import="java.sql.Connection"%>
<%@page import="in.cutm.dbConnection.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<%@ include file="component/bootStrapLink.jsp" %>
</head>
<body class="bg-light">
	<%@ include file="component/navBar.jsp" %>
	
	<%
		Connection con = ConnectDB.dbconnect();
		out.print(con);
		
	%>

</body>
</html>