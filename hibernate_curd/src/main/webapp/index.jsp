<html>
<body>
<h2>Hello World!</h2>
<form action="RegController" method="post">
    First Name:<input type="text" name="firstname"><br><br>
    Last Name:<input type="text" name="lastname"><br><br>
    <input type="submit" value="submit">
    <input type="hidden" name="flag" value="insert"><br><br>
</form>
<button><a href="RegController?flag=search">Search Data</a></button>
</body>
