function addRemark(){
	var options = {
		dataType : 'json',
		type : 'post',
        success : function(data)
        {  
        	if(data.res==100)
        	{
				alert("头像更换成功");
				window.location.href = "/index/";
        	}else if(data.res==59){
        		alert("请选择正确的图片格式");
        	}else if(data.res==60){
        		alert("头像更换失败");
        	}
        }
	};
    $("#formID").ajaxSubmit(options);
}	