<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>
</head>



<script type="text/javascript" src="/springmvc-mybatis/js/jquery-1.4.4.min.js"></script>



<body>
	<div id="header" style="background-color: #FFA500; height: 50px;">
		<h1>
			<a href="/springmvc-mybatis/index/logout">注销登录</a>
		</h1>
	</div>
	<div id="menu"
		style="background-color: #FFD700; height: 500px; width: 100px; float: left;">
		<div>
			<div class="img_bg">
				<a href="/springmvc-mybatis/index/changeImg"><img src="${user.userhead}"
					alt="点击修改头像" width="100" /></a><br>
			</div>
			用户名:${user.userAccount}<br> 生 日:${user.userBirth}<br>
		</div>
	</div>
	<div id="content"
		style="background-color: #EEEEEE; height: 500px; width: 957px; float: left;">
		<table>
		<#list pageBean.getList() as x >
			<tr>
				<td style="text-align: left;">标题：${x.bbsTitle}
					&nbsp;&nbsp;&nbsp;</td>
				<td style="text-align: left;">内容：${x.userBBS}&nbsp;&nbsp;&nbsp;</td>
				<td style="text-align: left;">时间：${x.data}</td>
				<td style="text-align: left;"><a
					href="/index/changeBBS/${x.userId}"><input type="button"
						value="修改"></a>
			</tr>
			</#list>
		</table>
		<#include "_paginate.ftl" /> 
<@paginate  currentPage=pageBean.pageNumber totalPage=pageBean.totalPage
		actionUrl="/springmvc-mybatis/index/"/> <a href="/springmvc-mybatis/index/addbbs"><input type="button"
			value="添加" /></a>
	</div>

</body>
</html>