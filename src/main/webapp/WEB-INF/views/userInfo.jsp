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
<%
user user=(user) request.getAttribute("user");
%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td>username:</td><td><%=request.getAttribute("username")%></td>--%>
<%--    </tr><tr>--%>
<%--        <td>password:</td><td><%=request.getAttribute("password")%></td>--%>
<%--    </tr><tr>--%>
<%--        <td>email:</td><td><%=request.getAttribute("email")%></td>--%>
<%--    </tr><tr>--%>
<%--        <td>gender:</td><td><%=request.getAttribute("gender")%></td>--%>
<%--    </tr><tr>--%>
<%--        <td>birthdate:</td><td><%=request.getAttribute("birthdate")%></td>--%>
<%--    </tr>--%>
<%--</table>--%>
<%@include file="footer.jsp"%>