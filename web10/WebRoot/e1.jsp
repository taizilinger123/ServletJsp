<%@page pageEncoding="utf-8"  contentType="text/html;charset=utf-8"%>
<%@page import="bean.*"%>
<html>
   <head></head>
   <body style="font-size:30px;">
       <%
         User user = new User();
         user.setName("Sally");
         user.setAge(22);
         request.setAttribute("user",user);
         
         User user2 = new User();
         user2.setName("Eric");
         user2.setAge(32);
         session.setAttribute("user",user2);
       %>
       name:
       <%
         //User user1 = (User)request.getAttribute("user");
         //out.println(user1.getName());
       %>
       <br/>
       name:${sessionScope.user.name}
       <br/>
       方式二:<br/>
       name:${user["name"]}
   </body>
</html>