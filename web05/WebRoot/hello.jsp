 <%@page import="java.util.*"%>
 <%@page contentType="text/html;charset=utf-8"%>
<html>
   <head></head>
   <body style="font-size:30px;">
     当我长发及腰，用来拖地可好
     time:<%       
         Date date = new Date();
         out.println(date);
     %>
     <br/>
     time:<%=new Date()%><br/>
     <%
       for(int i = 0;i < 100; i ++){
    	     out.println("hello Kitty<br/>");
       }
     %>
   </body>
</html>
