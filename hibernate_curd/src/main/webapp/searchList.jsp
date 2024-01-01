<%--
  Created by IntelliJ IDEA.
  User: dev1071
  Date: 29/12/23
  Time: 12:26 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Search Page</title>
</head>
<body>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${sessionScope.searchList}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.firstname}</td>
                <td>${i.lastname}</td>
                <td><a href="RegController?id=${i.id}&flag=delete">Delete</a> </td>
                <td><a href="RegController?id=${i.id}&flag=edit">Edit</a> </td>

            </tr>
        </c:forEach>

    </table>
</body>
</html>
