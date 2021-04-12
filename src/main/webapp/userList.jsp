<%--
  Created by IntelliJ IDEA.
  User: 武
  Date: 2021/4/11
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@page import="java.sql.ResultSet" %>
<h1>User List</h1>h1>
<table border=1>
    <tr>
        <td>id</td><td>password</td><td>email</td><td>gender</td><td>birthday</td>
    </tr>
    <%
     ResultSet rs=(ResultSet) request.getAttribute("rsname");
     if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String birthdate = rs.getString("birthdate");
            out.println("<tr><td>" + id + "</td><td>" + username + "</td><td>" + password + "</td><td>" + email + "</td><td>" + gender + "</td><td>" + birthdate + "</td></tr>");
        }
        //we will get data in next demo - 6.LiveDemo #3
    }%>
</table>

<%@include file="footer.jsp"%>