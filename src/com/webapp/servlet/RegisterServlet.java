package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.StudentDAO;

public class RegisterServlet extends HttpServlet{
    /*
     * HttpServlet中有两个方法需要我们自己重写
     * 需要在web.xml文件中进行注册
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //1.接受客户端数据
        //按照客户端调教数据的name-value的形式来提取数据
        String userid=req.getParameter("userid");
        String username = req.getParameter("username");
        String realname=req.getParameter("realname");
        String userpwd=req.getParameter("userpwd");
        String userage=req.getParameter("userage");
        String userpower=req.getParameter("power");
        
        int id = Integer.parseInt(userid);
        int age = Integer.parseInt(userage);
        int power=Integer.parseInt(userpower);
        //2.使用JDBC，将数据添加到数据库中
        StudentDAO sd = new StudentDAO();
        //3.HttpServletResponse对象
        //将HTML代码以数据流的形式响应给客户端
        //客户端使用IE浏览器来解析响应的HTML数据流
        
        //获得一个输出流对象
//        PrintWriter out = resp.getWriter();
//        
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta http-equiv='content-type' content='text/html; charset=UTF-8'>");
//        out.println("</head>");
//        out.println("<body>");
        
        
        try {
            int result=sd.add(id,username,userpwd,age,realname,power);
            if(result>0){
                //1.站内跳转,请求转发
                //只能转发网站内部的资源
                //转发的是同一个请求和响应对象
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
                
                //2.重定向跳转
                //可以请求外部资源
                //由于是客户端重新发起的请求，所以请求和响应对象不是同一个
                //resp.sendRedirect("/webDemo/success.jsp");
                
                //out.println("添加成功");
            }else{
                //out.println("添加失败");
            }
        } catch (SQLException e) {
            //out.println("添加失败");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
    
}
