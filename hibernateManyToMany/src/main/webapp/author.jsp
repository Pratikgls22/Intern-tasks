<%--
  Created by IntelliJ IDEA.
  User: dev1071
  Date: 08/01/24
  Time: 4:42 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author Page</title>
</head>
<body>
    <form action="AuthorController" method="post">
        AuthorName: <input type="text" name="aname"><br><br>
        <input type="submit" value="Add">
        <input type="hidden" name="f" value="fAuthor">
    </form>
</body>
</html>
