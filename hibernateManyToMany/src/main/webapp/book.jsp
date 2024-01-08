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
    <title>Book Page</title>
</head>
<body>
<form action="BookController" method="post">
    BookName: <input type="text" name="bname" placeholder="enter your book name"><br><br>
    <input type="submit" value="Enter">
    <input type="hidden" name="flag" value="fBook">
</form>
</body>
</html>
