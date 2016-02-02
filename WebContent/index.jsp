<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登陆</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
<style type="text/css">
body,td,th { font-family: "Source Sans Pro", sans-serif; }
body { background-color: #2B2B2B; }
</style>
</head>
<body>
	<div class="wrapper">
	
	<div class="container">
		<h1>Welcome</h1>
		<c:if test="${!empty errorMsg }">
			<div style="color:#FFFF00">${errorMsg }</div>
		</c:if>
		<form class="form" action="/Spring_Hibernate_Project/login/do.html" method="post">
			<input type="text" placeholder="Username" name="username"/>
			<input type="password" placeholder="Password" name="password"/>
			<button type="submit" id="login-button">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
 $('#login-button').click(function(event){
	/* event.preventDefault(); */ /* 取消点击动作的默认导航行为 */
	//$('form').fadeOut(500);  /* 通过淡出的方式隐藏匹配元素 */
	//$('.wrapper').addClass('form-success');
}); 
</script>
</body>
</html>