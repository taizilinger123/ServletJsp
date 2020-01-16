 <%@page import="java.util.*"%>
<html>
   <head></head>
   <body style="font-size:30px;">
    
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
