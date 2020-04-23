<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  
  <body>
    <h2>人员列表</h2>
    <table>
       <tr>
          <td>用户名</td>
          <td>密码</td>
       </tr>
       <c:forEach items="${users}" var="user">
          <tr>
             <td>${user.username}</td>
             <td>${user.password}</td>
          </tr>
       </c:forEach>
    </table>
  </body>
</html>
