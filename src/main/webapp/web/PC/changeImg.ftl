<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传头像</title>
</head>
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/js/jquery-form.min.js"></script>
<script type="text/javascript" src="/js/changeimg-ajax.js"></script>
<body>
	<div align="center">
		<h1>上传头像</h1>
		<hr>
	</div>
	<div align="center">
		<img src="${user.userhead}" width="150">
		<form action="/index/changeImg/changing" id="formID"
		method="post" enctype="multipart/form-data">
			<input type="file" name="uploadhead"> <input type="reset"
				value="重置"> <input type="button" onclick="addRemark()" value="上传">
		</form>
	</div>
</body>
</html>