function check() {
	
	if ($("#userAccount").val().length < 6) {
		alert("用户名必须不小于6位");
		return;
	} else if ($("#userpsw").val().length < 6) {
		alert("密码必须不小于6位");
		return;
	} else if ($("#verifyuserpsw").val() != $("#userpsw").val()) {
		alert("两次密码不同");
		return;
	}
	
	
	var options = {
			dataType : 'json',
			type : 'post',
			success : function(data) {
				if (data.res == 1) {
					alert("账号不能小于6位");
				} else if (data.res == 2) {
					alert("密码不能小于6位");
				} else if (data.res == 3) {
					alert("两次密码不相同");
				} else if (data.res == 4) {
					alert("验证码不正确");
				} else if (data.res == 5) {
					alert("该账号已被注册");
				} else {
					alert("注册成功，点击确认以跳转个人页面");
					window.location.href = "/springmvc-mybatis/index/";
				}
			}
		};
	
	
	//jquery
	$("#form").ajaxSubmit(options);
}