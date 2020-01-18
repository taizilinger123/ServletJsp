<%@page import="java.util.*,java.text.*" %>
<html>
   <head>
   </head>
   <body style="font-size:30px;">
      date:<%
         Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      %>
      <%=sdf.format(date)%>
   </body>
</html>