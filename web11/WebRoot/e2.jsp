<%@page pageEncoding="utf-8"  contentType="text/html;charset=utf-8"%>
<%@page import="bean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head></head>
   <body style="font-size:30px;">
       <%
          User user = new User();
          user.setName("谢玉");
          user.setGender("m");
          request.setAttribute("user",user);
       %>
       姓名:${user.name}<br/>
       性别:<c:choose>
               <c:when test="${user.gender == 'm'}">男</c:when>
               <c:when test="${user.gender == 'f'}">女</c:when>
               <c:otherwise>保密</c:otherwise>
            </c:choose>
   </body>
</html>