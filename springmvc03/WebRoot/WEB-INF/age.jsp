<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
  <head>
  </head>
  
  <body>
    <h2>年龄计算器</h2>
      <form action="age.do" method="post">
      请输入生日:<input type="text" name="birth">
         <input type="submit" value="开始计算">
      </form>
      <hr/>
      ${msg }
  </body>
</html>
