<%--
  Created by IntelliJ IDEA.
  User: dev1071
  Date: 02/01/24
  Time: 2:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="2">
        <tr>
            <td>ID</td>
            <td>FirstName</td>
            <td>LastName</td>
            <td>Delete</td>
            <td>Edit</td>
        </tr>

        <c:forEach items="${SearchList}" var="i" >
            <tr>
                <td>${i.id}</td>
                <td>${i.firstname}</td>
                <td>${i.lastname}</td>
                <td colspan="2">
                    <a href="delete.html?id=${i.id}">Delete</a>
                    <a href="edit.html?id=${i.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
