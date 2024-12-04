<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script type="text/javascript">
	/* $(function() {
		$.ajax({
			type:'POST',
			url:"http://localhost:8080/test",
			data:{name:'你好'},
			success:function(data){
				
			}
		});
	}); */
</script>
</head>
<body>HelloWorld
<form action="http://localhost:8080/validator" method="post">
<input name="name" type="text">
<input type="submit">
</form>
</body>
</html>