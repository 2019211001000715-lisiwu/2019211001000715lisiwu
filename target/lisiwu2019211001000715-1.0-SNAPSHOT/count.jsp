<%--
  Created by IntelliJ IDEA.
  User: 武
  Date: 2021/4/5
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<b>Login</b><br>
<form method="post" action="login">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>
