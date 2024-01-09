<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Page!!</title>
</head>
<body>
    <form action="AuthorController" method="post">

        <input type="hidden" name="f" value="update">
        <table>
            <s:forEach items="${sessionScope.data}" var="i">
                <tr>
                    <th>Id</th>
                    <td><input type="text" name="updateId" value="${i.id}"></td>
                </tr>
                <tr>
                    <th>AuthorName</th>
                    <td><input type="text" name="updateAuthorName" value="${i.authorName}"></td>
                </tr>
            </s:forEach>

            <t:forEach items="${sessionScope.dataBook}" var="j">
                <tr>
                    <th>BookName</th>
                    <td><input type="text" name="updateBookName" value="${j.books.bName}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </t:forEach>
        </table>
    </form>
</body>
</html>
