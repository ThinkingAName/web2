<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <center>
  <form name="myform" method="post" action="/web2/LoginServlet"> 
      
       用户名字： <input type="text" name="username"/><br/><br/>
      
       用户密码：<input type="text" name="userpwd"/><br/><br/>
      <input type="submit" value="登录"/>
      <a href="/web2/registerStudent.html">点击注册用户</a>
  </form>  
  </center>
  <a href="https://www.cnblogs.com/sky-z/p/4654987.html">点击查看原文章</a>
  </body>
</html>