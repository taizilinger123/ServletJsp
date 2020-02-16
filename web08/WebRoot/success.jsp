<%
   Object obj = session.getAttribute("user");
   if(obj == null){
	   response.sendRedirect("login.jsp");
	   return;
   }
%>

<h1>login success</h1>
<%
   System.out.println("login success...");
%>
