package com.Lisiwu.week3.demo;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/Register"},loadOnStartup = 1
)

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        /*String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        con= (Connection) getServletContext().getAttribute("con");//name of attribute
        //please check the video live demo#4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username1 = request.getParameter("username");
        String password = request.getParameter("password");
        String email1 = request.getParameter("email");
        String gender1 = request.getParameter("gender");
        String birthdate1 = request.getParameter("birthdate");

        String sql1 = "insert into usertable values(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, username1);
            pstmt.setString(2, password);
            pstmt.setString(3, email1);
            pstmt.setString(4, gender1);
            pstmt.setString(5, birthdate1);
            pstmt.executeUpdate();

            //response.setContentType("textml");
            //PrintWriter out = response.getWriter();
            //here is html code --- move these html code in a jsp page - user1l1ist.jsp
        /*out.println("<html>");
        out.println("<head><title>Register</title></head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr><td>ID</td><td>username</td><td>password</td><td>email</td><td>gender</td><td>birthdate</td></tr>");*/
            String sql2 = "select * from usertable";
            ResultSet rs = null;
            rs = con.createStatement().executeQuery(sql2);
            /*while(rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("username");
                String password1=rs.getString("password");
                String email=rs.getString("email");
                String gender=rs.getString("gender");
                String birthdate=rs.getString("birthdate");
                out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+password1+"</td><td>"+email+"</td><td>"+gender+"</td><td>"+birthdate+"</td></tr>");*/
            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("i am in RedirectServlet-->doPost()-->after forward()");
            //ok - done
            //after register a new user - user can login
            response.sendRedirect("login.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //out.println("</table>");
        // out.println("</body>");
        // out.println("</html>");
        //use request attribute
        //set rs into request attribute

        /*request.getRequestDispatcher("userList.jsp").forward(request,response);//at this point request given to user
        //at this point request given to userList.jsp
        //url doesnot change
        //no more here
        System.out.println("i am in RegisterServlet-->doPost-->after forward()");//no see this line
    */
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

