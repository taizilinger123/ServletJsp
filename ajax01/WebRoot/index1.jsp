<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
  <head>
  <!-- 引入jQuery函数库 -->
  <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
  <script type="text/javascript">
    $(function(){//页面载入完毕后执行
       //给id=showBtn的元素绑定一个function
       $("#showBtn").click(function(){
           //发送ajax
           $.ajax({
              url:"/ajax01/demo1.do",
              type:"get",
              success:function(result){
                 //result等价于xhr.responseText
                 //result就是服务器返回的内容
                 //将result放到id=msg的span中显示
                 $("#msg").html(result);
                 //$("#msg").text(result);
                 //$("#msg").html("<a href='#'>信息</a>");
                 //$("#msg").text("<a href='#'>信息</a>");
              }
           });
           
       });
    });
  </script>
  <script type="text/javascript">
     $(function(){
        //给输入框追加焦点移开事件
        $("#username").blur(function(){
           //获取用户名
           var name = $("#username").val();
           //发送ajax检测  
           $("#username_msg").html("正在检测..."); 
           $.ajax({
               type:"post",
               url:"/ajax01/check.do",
               data:{"name":name},
               success:function(result){
                 //result就是服务器返回的信息
                 $("#username_msg").html(result); 
               }
           });
        });
     });
  </script>
  </head>
  <body>
     <a href="#" id="showBtn">查看上证指数</a>
     <span id="msg"></span>
     <hr/>
     <table>
        <tr>
           <td>新闻标题</td>
           <td>时间</td>
        </tr>
        <tr>
           <td>习近平和英九在新加坡相会</td>
           <td>2015-11-11</td>
        </tr>
        <tr>
           <td>经济指数有所改观</td>
           <td>2015-11-10</td>
        </tr>
        <tr>
           <td>大宗商品价格下跌</td>
           <td>2015-11-10</td>
        </tr>
     </table>
     <hr/>
     <input type="text"  id="username">
     <span id="username_msg"></span>
  </body>
</html>
