<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Search Page!!</title>
</head>
<body>
    <form action="AuthorController" method="post">
        <table border="1px">
            <tr>
                <th>Id</th>
                <th>AuthorName</th>
<%--                <th>BookName</th>--%>
                <th>Delete</th>
                <th>Edit</th>
            </tr>

            <p:forEach items="${sessionScope.searchList}" var="i">
                <tr>
                    <td>${i.id}</td>
                    <td>${i.authorName}</td>
<%--                    <td>${i.books.bName}</td>--%>
                    <td><a href="AuthorController?id=${i.id}&flag=delete">Delete</a></td>
                    <td><a href="AuthorController?id=${i.id}&flag=edit">Edit</a></td>
                </tr>

            </p:forEach>
        </table>
    </form>
</body>
</html>
