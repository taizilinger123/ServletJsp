<%@page pageEncoding="utf-8"  contentType="text/html;charset=utf-8"%>
<%@page import="bean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head></head>
   <body style="font-size:30px;">
       <%
         User user = new User();
         user.setName("梅长苏");
         user.setGender("f");
         request.setAttribute("user",user);
       %>
       姓名:${user.name}
       <!-- 等价于user.getName -->
       性别:<c:if test="${user.gender == 'm'}" var="flag" scope="request">男</c:if>
            <c:if test="${!flag}">女</c:if>
   </body>
</html>