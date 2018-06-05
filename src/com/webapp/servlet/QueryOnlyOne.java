package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.StudentDAO;
import com.webapp.dao.StudentPO;

public class QueryOnlyOne extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO sd = new StudentDAO();
        StudentPO  sp = new StudentPO();
        String id=request.getParameter("userid");
        int userid = Integer.parseInt(id);
        
        try {
                //将对象保存在请求对象中
                List<StudentPO> list=sd.queryStudentById(userid);
                 request.setAttribute("students", list);
                request.getRequestDispatcher("/showStudents.jsp").forward(request, response);
            
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
