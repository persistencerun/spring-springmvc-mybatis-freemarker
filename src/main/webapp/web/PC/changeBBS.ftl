
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<script type="text/javascript" src="/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/js/jquery-form.min.js"></script>
<script type="text/javascript" src="/js/changebbs-ajax.js"></script>
<body>
<form method="post" action="/index/changeBBS/save" id="form" name="form">
    <div align="center">
        标 题：<input type="text" width=10000 value="${bbs.bbsTitle}" id="bbsTitle"
                   name="bbsTitle"><br>
    </div>
    <div align="center">
        内 容：
        <textarea name="userBBS" cols="100" rows="30" id="userBBS" >${bbs.userBBS}</textarea>
    </div>
    <div align="center">
        <input type="button" onclick="addRemark(),time()" value="保存"><input
            type="reset"><a href="/index/"><input type="button"
                                                     value="返回"></a>最后一次更改时间：<input type="text" readonly="readonly"
                                                                                    id="data"  name="data" value="2016/7/1" >
    </div>
</form>
</body>
<script type="text/javascript">
//js获取日期
function time()
{
  var now= new Date();
  var year=now.getFullYear();
  var month=now.getMonth();
  var date=now.getDate();
//写入相应id
 document.getElementById("data").innerHTML=year+"年"+(month+1)+"月"+date+"日";
}
</script>
</html>