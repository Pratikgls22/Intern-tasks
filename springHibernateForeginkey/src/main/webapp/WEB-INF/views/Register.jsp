<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<%--<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>--%>
<html>
<head>
    <title>Register Page !!</title>
</head>
<body>
    <p:form action="insert" method="post" modelAttribute="User">
        <p:hidden path="userId"/>
        UserName : <p:input path="userName"/><br><br>
        UserEmail : <p:input path="userEmail"/><br><br>
        UserAge : <p:input path="info.userAge"/><br><br>
        UserCity: <p:input path="info.userCity"/><br><br>

        <p:button value="submit" type="submit">Submit</p:button>
    </p:form>
</body>
</html>
