<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.webapp.dao.StudentPO"%>
<%
//java脚本
//写java的代码
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    StudentPO stu=(StudentPO)request.getAttribute("student");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
  <body>
      <!-- java表达式 -->
      当前网站的根目录：<%=path %><BR/>
      当前网站的全目录：<%=basePath %><br/>
       欢迎<%=stu.getUserName() %>登录！！！<BR/>
       <a href="/web2/QueryOnlyOne?userid=<%=stu.getUserId() %>">查看自己信息</a>
  </body>
</html>