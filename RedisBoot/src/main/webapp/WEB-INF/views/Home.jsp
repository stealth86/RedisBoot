<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="./addgreet" modelAttribute="gModel">
<table>
<tbody>
<tr>
<td>ID</td>
<td><form:input path="id"/></td>
</tr>
<tr>
<td>SubID</td>
<td><form:input path="gSubModel.subId"/></td>
</tr>
<tr>
<td>Name</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>SubName</td>
<td><form:input path="gSubModel.subName"/></td>
</tr>
</tbody>
</table>
<input type="submit" value="submit"/>
</form:form>
</body>
</html>