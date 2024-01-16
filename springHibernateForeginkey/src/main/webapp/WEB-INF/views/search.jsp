<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Search Page!</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>UserEmail</th>
            <th>UserAge</th>
            <th>UserCity</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <p:forEach items="${searchList}" var="i">
            <tr>
                <td>${i.userId}</td>
                <td>${i.userName}</td>
                <td>${i.userEmail}</td>
                <td>${i.info.userAge}</td>
                <td>${i.info.userCity}</td>
                <td><a href="delete?id=${i.userId}">Delete</a></td>
                <td><a href="edit?id=${i.userId}">Edit</a></td>
            </tr>
        </p:forEach>
    </table>
</body>
</html>
