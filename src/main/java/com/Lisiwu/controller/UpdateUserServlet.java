package com.Lisiwu.controller;

import com.Lisiwu.dao.userDao;
import com.Lisiwu.model.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update user info - can update password,email,gender,birthdate
        String id = request.getParameter("id");
        String Username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        String Date=request.getParameter("birthDate");

        user user = new user();
        user.setId(Integer.parseInt(id));
        user.setUsername(Username);
        user.setPassword(password);
        user.setEmail(Email);
        user.setGender(Gender);
        user.setBirthdate(Date);

        userDao userDao = new userDao();

        try {
            userDao.updateUser(con,user);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",user);
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

