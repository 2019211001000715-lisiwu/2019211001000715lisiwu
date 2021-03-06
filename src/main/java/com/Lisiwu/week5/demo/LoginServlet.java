package com.Lisiwu.week5.demo;


import com.Lisiwu.dao.userDao;
import com.Lisiwu.model.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //when user click login menu - request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        // now move jdbc code in dao - MVC design
        //write mvc code
        //user model and dao
        userDao userDao=new userDao();
        try {
            user user=userDao.findByUsernamePassword(con,username,password);//this methods use for login
            if (user!=null){
                //Cookie c=new Cookie("sessionid",""+user.getId());
                //c.setMaxAge(10*60);
                //valid
                //set user into request
                //response.addCookie(c);
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }


                HttpSession session=request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);//get user info in jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                //invalid
                request.setAttribute("message","username or password Error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
            //forward - JSP

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>login</title></head>");
        out.println("<body>");*/
        /*String sql="select * from usertable where  username=? and password=?";
        PreparedStatement pstmt=null;
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
                if (rs.next()) {
                    //out.println("<b>"+"Login Success!!!"+"<br>");
                    //out.println("<b>"+"Welcome,"+"<b>" + "<b>"+username+"<b>");
                    request.setAttribute("id", rs.getInt("id"));
                    request.setAttribute("username", rs.getString("username"));
                    request.setAttribute("password", rs.getString("password"));
                    request.setAttribute("email", rs.getString("email"));
                    request.setAttribute("gender", rs.getString("gender"));
                    request.setAttribute("birthdate", rs.getString("birthdate"));
                    request.getRequestDispatcher("userInfo.jsp").forward(request, response);
                }else {
                    //out.println("login Error!!");
                    request.setAttribute("message","username or password Error");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");*/
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
