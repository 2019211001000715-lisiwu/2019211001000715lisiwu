<%--
  Created by IntelliJ IDEA.
  User: 武
  Date: 2021/4/5
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<b>Login</b><br>
<%
    if (!((request.getAttribute("message"))==null)){
      out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="login">
  Username: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" value="login">
</form>
<%@include file="footer.jsp"%>