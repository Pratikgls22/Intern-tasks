<html>
<body>
<form action="EmpController" method="post">
    FirstName: <input type="text" name="firstname"><br><br>
    LastName: <input type="text" name="lastname"><br><br>
    Email: <input type="email" name="email"><br><br>
    Department: <input type="text" name="department"><br><br>
    Post: <input type="text" name="post"><br><br>
    <input type="submit" value="Submit"><br><br>
    <input type="hidden" name="flag" value="insert">
    <button><a href="EmpController?flag=search">Serach Page!!</a></button>
</form>
</body>
</html>
