<%@page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@page import="dao.*,entity.*,java.util.*"%>
<html>
   <head></head>
   <body style="font-size:30px;">
      <table width="60%" border="1" cellpadding="0" cellspacing="0">
          <tr>
	          <td>ID</td>
	          <td>姓名</td>
	          <td>薪水</td>
	          <td>年龄</td>
          </tr>
          <%
            EmployeeDAO dao = new EmployeeDAO();
            List<Employee> employees = dao.findAll();
            for(int i = 0;i < employees.size(); i ++){
            	Employee e = employees.get(i);
            	%>
            	  <tr>
            	    <td><%=e.getId()%></td>
            	    <td><%=e.getName()%></td>
            	    <td><%=e.getSalary()%></td>
            	    <td><%=e.getAge()%></td>
            	  </tr>
            	<%
            }
          %>
          
      </table>
   </body>
</html>