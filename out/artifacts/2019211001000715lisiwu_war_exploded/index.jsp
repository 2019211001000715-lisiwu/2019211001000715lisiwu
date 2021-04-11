<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<from>
    <span style="...">New User Registration</span><br/><br/>
    <span style="...">Username</span><input type="text" name="name" required="true" style="..."><br/><br/>
    <span style="...">Password</span><input type="password" name="password" required="true" style="..."><br/><br/>
    <span style="...">Email</span><input type="email" name="email" required="true" style="..."><br/><br/>
    <span style="...">Gender</span>
    <span style="...">Male</span><input type="radio">
    <span style="...">Female</span><input type="radio"></from>
    <span style="...">Date of birth(yyy-mm-dd)</span>
</from>
<%@include file="footer.jsp"%>