<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="b" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b:form action="insert" method="post" modelAttribute="RegVo">
    FirstName : <b:input path="firstname"/><br><br>
    LastName : <b:input path="lastname"/><br><br>
    <b:hidden path="id"/>
    <b:button value="submit">Submit</b:button>
</b:form>

</body>
</html>
