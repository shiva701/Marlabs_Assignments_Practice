<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="ecomm.customers.login.page.title"/></title>
<style type="text/css">
span {
	color: red;
	font-family: verdana;
	font-size: 10px
}
</style>
</head>
<body>
	<form:form action="userLogin" method="POST" modelAttribute="loginForm">
		<table>
			<tr>
				<td><spring:message code="ecomm.customers.login.page.uname.label"/></td>
				<td><form:input path="username" /></td>
				<td><span></span>
				<form:errors path="username" /></span></td>
			</tr>
			<tr>
				<td><spring:message code="ecomm.customers.login.page.pword.label"/></td>
				<td><form:input type="password" path="password" /></td>
				<td><span></span>
				<form:errors path="password" /></span></td>
			</tr>
			<tr>
				<td><input type="submit" value='<spring:message code="ecomm.customers.login.page.submit.label"/>' /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>