<%--
  Created by IntelliJ IDEA.
  User: dev1071
  Date: 04/01/24
  Time: 2:53 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="e" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Edit Page</title>
</head>
<body>
    <form action="RegController" method="post"></form>
    <e:forEach items="${sessionScope.Data}" var="i">
        <input type="hidden" name="id" value="${i.id}">
        FirstName : <input type="text" name="firstname" value="${i.firstname}}"><br><br>
        LastName : <input type="text" name="lastname" value="${i.lastname}"><br><br>
        Email: <input type="email" name="email" value="${i.loginVo.email}"><br><br>
        Password: <input type="password" name="pass" value="${i.loginVo.pass}"><br><br>
        <input type="submit" value="update"><br><br>
    <input type="hidden" name="flag" value="update">
    </e:forEach>
</body>
</html>
