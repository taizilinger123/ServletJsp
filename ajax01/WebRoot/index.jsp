<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
  <head>
  <script type="text/javascript">
      //创建XMLHttpRequest
      function getXhr(){
        var xhr;
        if(window.XMLHttpRequest){//如果支持该类型
              xhr = new XMLHttpRequest();
        }else{//ie
              xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xhr;
      };
      //发送HTTP请求
      function sendRequest(){
             var xhr = getXhr();//获取XMLHttpRequest对象
             xhr.open("GET","/ajax01/demo1.do");//创建一个HTTP请求
             //注册一个回调函数，请求处理时自动调用
             xhr.onreadystatechange = function(){
                if(xhr.readyState==4){//4表示请求处理完毕
                   //获取服务器返回的信息
                   var msg = xhr.responseText;
                   //将消息放到id=msg的span显示
                   document.getElementById("msg").innerHTML=msg;
                }
             };
             xhr.send(null);//发送HTTP请求
      };
  </script>
  <script type="text/javascript">
    //检查用户名是否可用
    function checkname(){
        //获取请求参数
        var name = document.getElementById("username").value;
        //发送ajax请求
		var xhr = getXhr();//获取XMLHttpRequest对象
		xhr.open("POST", "/ajax01/check.do");//创建请求
		xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");//给HTTP协议设置请求头参数
		//注册回调函数
		xhr.onreadystatechange = function(){
		   //如果请求处理完毕
           if(xhr.readyState==4 && xhr.status==200){
             var msg = xhr.responseText;
             document.getElementById("username_msg").innerHTML=msg;
           }
	    }
		xhr.send("name="+name);//发送请求
		document.getElementById("username_msg").innerHTML="正在检测...";
    }
  </script>
  </head>
  <body>
     <a href="#"  onclick="sendRequest()">查看上证指数</a>
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
     <input type="text"  id="username" onblur="checkname()">
     <span id="username_msg"></span>
  </body>
</html>
