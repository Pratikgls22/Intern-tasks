<%--
  Created by IntelliJ IDEA.
  User: dev1071
  Date: 03/01/24
  Time: 2:46 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SErach Page</title>
</head>
<body>
<table border="2px">
    <tr>
        <td>ID</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>Email</td>
        <td>Pass</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>

    <b:forEach items="${sessionScope.searchList}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.firstname}</td>
            <td>${i.lastname}</td>
            <td>${i.loginVo.email}</td>
            <td>${i.loginVo.pass}</td>
            <td><a href="RegController?id=${i.id}&flag=delete">Delete</a></td>
            <td><a href="RegController?id=${i.id}&flag=edit">Edit</a></td>
        </tr>
    </b:forEach>

</table>

</body>
</html>
