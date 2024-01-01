<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="v" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="RegController" method="post">
    <v:forEach items="${sessionScope.Data}" var="i">
        <input type="hidden" name="id" value="${i.id}">
        First Name:<input name="fn" type="text" value="${i.firstname}">
        Last Name:<input name="ln" type="text" value="${i.lastname}">
        <input type="submit" value="update">
        <input type="hidden" name="flag" value="update">
    </v:forEach>
</form>
</body>
</html>
