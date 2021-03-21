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
        div{text-align: center;color: black;font-size:20px ;
        background-color: aqua;width: 400px;height: 200px;}
    </style>
</head>
<body>
<form method="post" action="register"><!--within doPost() in servlet-->
    username :<input type="text" name="username"/><br/>
    password :<input type="" name="password"/><br/>
    email    :<input type="email"password name="email"/><br/>
    gender   :<input type="radio" name="gender"value="male" >Male<input type="radio" name="gender"value="female">Female<br/>
    <!--if name is some it make array-->
    birthdate:<input type="text" name="birthdate"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
