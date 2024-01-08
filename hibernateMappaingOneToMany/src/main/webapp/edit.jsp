<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>Edit Page!!</title>
</head>
<body>
    <form action="EmpController" method="post">
        <p:forEach items="${sessionScope.Data}" var="i">
        <input type="hidden" name="id" value="${i.id}">
            FirstName : <input type="text" name="firstname" value="${i.firstname}"><br><br>
            LastName : <input type="text" name="lastname" value="${i.lastname}"><br><br>
            Email : <input type="email" name="email" value="${i.email}"><br><br>
            Department : <input type="text" name="department" value="${i.company.department}"><br><br>
            Post : <input type="text" name="post" value="${i.company.post}"><br><br>
            <input type="submit" value="Update">
            <input type="hidden" name="flag" value="update">
        </p:forEach>
    </form>
</body>
</html>
