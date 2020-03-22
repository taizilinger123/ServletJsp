<%@page pageEncoding="utf-8"  contentType="text/html;charset=utf-8"%>
<%@page import="java.util.*" %>
<html>
   <head></head>
   <body style="font-size:30px;">
       ${1 + 1}<br/>
       ${"2" + "4"}<br/>
       ${2 > 1}<br/>
       <%
          request.setAttribute("str1","abc");
       %>
        <%-- ${sessionScope.str1 == "abc"}
      ${requestScope.str1 == "abc"}--%>
       ${str1 == "abc"}<br/>
       ${ 1 < 2 && 2 > 3 }<br/>
       <%
         List list1 = new ArrayList(); 
         //list1.add("a");
         request.setAttribute("list", list1);
       %>
       ${empty list}<br/>
       <%
         request.setAttribute("str2", "");
       %>
       ${empty str2}<br/>
       ${empty null}<br/>
       ${empty aaa }
   </body>
</html>