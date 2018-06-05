<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.webapp.dao.StudentPO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    List<StudentPO> list=(List<StudentPO>)request.getAttribute("students");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showStudents.jsp' starting page</title>
    
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
  <table border="1" bordercolor="red" align="center">
  <tr>
      <th>用户ID</th>
      <th>真实姓名</th>
      <th>用户姓名</th>
      <th>用户年龄</th>
      <th>用户权限</th>
  </tr>
    <%
        for(StudentPO s :list){
    %>
    <tr>
        <td><%=s.getUserId() %></td>
        <td><%=s.getRealName() %>></td>
        <td><%=s.getUserName() %></td>
        <td><%=s.getUserAge() %></td>
        <td><%=s.getUserPower() %></td>
    </tr>
    
    <% 
        }
     %>
     </table>
  </body>
</html>