<!-- h5  -->
<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>



<script type="text/javascript" src="/springmvc-mybatis/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/springmvc-mybatis/js/jquery-form.min.js"></script>
<script type="text/javascript" src="/springmvc-mybatis/js/userlogin-ajax.js"></script>


<body>
		<div align="center"><h1>lueor:吴喆私人论坛</h1><br><h5>登录</h5></div>
		<div align="center">
			<form  method="post" id="formID" action="/springmvc-mybatis/logining">
				<table>
					<tr>
						<td>UserAccound:</td>
						<td><input type="text" name="useraccount" value="" id="useraccount"></td>
					</tr>
					<tr>
						<td>UserPassword:</td>
						<td><input type="password" name="userpsw" value="" id="userpsw"></td>
					</tr>
					<tr>
					<td></td>
					<td>
					<input type="button" value="登录" onclick="addRemark()">
					<a href="/springmvc-mybatis/register/"><input type="button" value="注册"></a>
					</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>