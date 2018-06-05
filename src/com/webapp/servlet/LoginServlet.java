package com.webapp.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.StudentDAO;
import com.webapp.dao.StudentPO;

public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");        
        String username=request.getParameter("username");
        String userpwd=request.getParameter("userpwd");
        
        System.out.println(username);
        System.out.println(userpwd);
        
        StudentDAO sd = new StudentDAO();
        try {
            StudentPO sp=sd.doLogin(username, userpwd);
            if(sp==null){
                response.sendRedirect("/web2/login.jsp");
            }else{
                request.setAttribute("student", sp);
                if(sp.getUserPower()==1)
                    request.getRequestDispatcher("/main.jsp").forward(request, response);
                else if(sp.getUserPower()==0)
                    request.getRequestDispatcher("/user.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}