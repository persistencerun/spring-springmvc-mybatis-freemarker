function addRemark(){
	alert("heheheh");
	
	if(($("#useraccount").val())!= ""){
       	if(($("#userpsw").val())==""){
       		alert("密码不能空");
    	}else{
    		
    		
    		//ajax
    	    $.ajax({
    	        url:"/springmvc-mybatis/logining",    //请求的url地址
    	        dataType:"json",   //返回格式为json
    	        async:true,//请求是否异步，默认为异步，这也是ajax重要特性
    	        data:{"useraccount":$("#useraccount").val(),"userpsw":$("#userpsw").val()},    //参数值
    	        type:"post",   //请求方式
    	        beforeSend:function(){
    	            //请求前的处理
    	        },
    	        success:function(data){
    	            //请求成功时处理
    	        	if(data.res==100){
    					alert("登录成功");
    					window.location.href = "/springmvc-mybatis/index/";
    	        	}else if(data.res==59){
    	        		alert("账号不存在");
    	        	}else if(data.res==60){
    	        		alert("密码错误");
    	        	}
    	        },
    	        complete:function(){
    	            //请求完成的处理
    	        },
    	        error:function(){
    	            //请求出错处理
    	        }
    	    });
           
   	    }
    } else{
    	alert("账号不能为空");
    }
	
	
    
	
	
	
}	