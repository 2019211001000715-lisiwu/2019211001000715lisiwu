<%--
  Created by IntelliJ IDEA.
  User: 武
  Date: 2021/3/14
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        div{text-align: center;color: black;font: size:20px;
        background-color: aqua;width: 400px;height: 200px;}
    </style>
</head>
<body>
<form>
    <div>
    username :<input type="text" name="username" required><br/>
    password :<input type="password" name="password" required minlength="8"><br/>
    email    :<input type="email" name="email" required><br/>
    <input name="sex" type="radio" value="Male"/>Male
    <input name="sex" type="radio" value="Female"/>Female<br/>
    birthdate:<input type="datetime-local" name="yyyy-mm-dd" required><br/>
    <input name="b1" type="submit" id="b1" value="Register" required><br/>
    </div>
</form>
</body>
</html>
