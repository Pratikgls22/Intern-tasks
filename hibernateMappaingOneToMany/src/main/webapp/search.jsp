<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="b" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Search Page!!</title>
</head>
<body>
<table border="2px">
    <tr>
        <td>Id</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>Email</td>
        <td>Department</td>
        <td>Post</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>

    <b:forEach items="${sessionScope.searchList}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.firstname}</td>
            <td>${i.lastname}</td>
            <td>${i.email}</td>
            <td>${i.company.department}</td>
            <td>${i.company.post}</td>
            <td><a href="EmpController?id=${i.id}&flag=delete">Delete</a></td>
            <td><a href="EmpController?id=${i.company.id}&flag=delete">Edit</a></td>
        </tr>
    </b:forEach>
</table>
</body>
</html>
