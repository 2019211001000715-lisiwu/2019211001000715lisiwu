package com.Lisiwu.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value = "LiSiWu"),
                @WebInitParam(name="studentId",value = "2019211001000715"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        String id = config.getInitParameter("studentId");
        PrintWriter writer = response.getWriter();
        writer.println("Name:" + name);
        writer.println("studentId:" + id);
    }
}
