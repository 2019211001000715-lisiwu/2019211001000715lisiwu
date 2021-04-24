<%@ page import="com.Lisiwu.model.user" %><%--
  Created by IntelliJ IDEA.
  User: 武
  Date: 2021/4/12
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%--<%--%>
<%--    Cookie[] allCookies=request.getCookies();--%>
<%--    for(Cookie c:allCookies){--%>
<%--        out.println("<br/>"+ c.getName()+"----"+c.getValue());--%>
<%--    }--%>
<%--%>--%>
<%
    user u=(user)session.getAttribute("user");
%>
<table>
    <tr>
        <td>username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
    <td>password:</td><td><%=u.getPassword()%></td>
</tr><tr>
    <td>email:</td><td><%=u.getEmail()%></td>
</tr><tr>
    <td>gender:</td><td><%=u.getGender()%></td>
</tr><tr>
    <td>birthdate:</td><td><%=u.getBirthdate()%></td>
</tr>
</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>