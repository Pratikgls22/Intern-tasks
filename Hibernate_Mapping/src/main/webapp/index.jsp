<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Index Page</title>
</head>
<body>
    <form action="RegController" method="post">
        First Name: <input type="text" name="firstname"><br><br>
        Last Name: <input type="text" name="lastname"><br><br>
        Email: <input type="email" name="email"><br><br>
        Password: <input type="password" name="pass"><br><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="flag" value="insert"><br><br>
    </form>
</body>
<button><a href="RegController?flag=search">Search</a></button>
</html>
