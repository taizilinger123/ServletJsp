<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>员工列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
						<div id="rightheader">
							<p>
							    2020/1/30
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						员工列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								薪水
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>
                        <c:forEach items="${employees}" var="e" varStatus="s"> 
						<tr class="row${s.index % 2 + 1}">
							<td>
								${e.id}
							</td>
							<td>
								${e.name}
							</td>
							<td>
								${e.salary}
							</td>
							<td>
								${e.age}
							</td>
							<td>
								<a href="del.do?id=${e.id}"
								 onclick="return confirm('确定删除${e.name}吗?');">删除</a>&nbsp;
								<a href="load.do?id=${e.id}">修改</a>
							</td>
						</tr>	
                        </c:forEach>
					</table>
					<p>
						<input type="button" 
						class="button" 
						value="添加员工" 
						onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
