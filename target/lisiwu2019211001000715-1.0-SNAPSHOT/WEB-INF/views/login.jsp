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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",remeberMeVal="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                remeberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
  Username: <input type="text" name="username" value="<%=username%>"><br>
  Password: <input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="remember" value="1" <%=remeberMeVal.equals("1")?"checked":""%>checked/>RememberMe<br/>
  <input type="submit" value="Submit">
</form>
<%@include file="footer.jsp"%>