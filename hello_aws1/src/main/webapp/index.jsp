<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First AWS Application</title>
<style type="text/css">
h3 {
	color: blue;
}
</style>
</head>
<body>
	<h3>
		<%
		out.println(new Date());
		%>
	</h3>
</body>
</html>