<%--
  Created by IntelliJ IDEA.
  User: amei
  Date: 17-3-23
  Time: 下午12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>temp page</title>
</head>
<body>
<span>${msg}</span>
<span id = "span-status" style="display: none">${status}</span>
<span id="span-name" style="display: none">${nickname}</span>

<form id="form1" runat="server">
    <div id='div1'>
    </div>
</form>
</body>
</html>

<script type="text/javascript">
    var status = document.getElementById("span-status").innerText;
    var nickname = document.getElementById("span-name").innerText;
    url = ""
    if (status == 0 )
        url = '/HituServer/user/reset?nickname='+nickname
    else
        url='/HituServer/user/loginpage'
    //执行showTime()
    showTime()
</script>

<script type="text/javascript">
    //设定倒数秒数
    var t = 5;
    //显示倒数秒数
    function showTime(){
        t -= 1;
        document.getElementById('div1').innerHTML= t;
        if(t==0){
            location.href=url
        }
        //每秒执行一次,showTime()
        setTimeout("showTime()",1000);
    }
    //执行showTime()
    showTime();
</script>