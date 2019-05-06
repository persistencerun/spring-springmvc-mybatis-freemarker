	function addRemark() {
		var options = {
			dataType : 'json',
			type : 'post',
			success : function(data) {
				if (data.res == 100) {
					alert("保存成功");
				} else {
					alert("保存失败");
				}
			}
		};
		$("#form").ajaxSubmit(options);
			   return false;  
		}