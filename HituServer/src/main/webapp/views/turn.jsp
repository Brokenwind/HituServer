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
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <link href="/HituServer/resources/turn/css/turn.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<span></span>
<span id="span-url" style="display: none">${url}</span>

<div class="container">
    <div class="row">
        <div class="col-lg-10 col-md-10 col-sm-10 ">
            <div class="head-sec">
                <i class="fa fa-bicycle fa-5x"></i>
                <h2 class="domain-header">信息验证结果</h2>
                <h4>
                <p class="col-lg-10 col-md-10 col-sm-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
                    ${msg}
                </p>
                </h4>
            </div>
            <!--HEADER SECTION END-->
            <div class="text-center">
                <div class="domain-sale-div">
                    LEAVE
                    <br />
                    <span id="leave-sec"></span>
                    <br />
                    秒
                </div>
            </div>
            <div class="text-center">
                <h4 ><strong  >如有问题请联系我们</strong> </h4>
                <hr class="hr-set" />
                <h5  ><strong>邮箱 : </strong>wangkun6536@163.com </h5>
                <h5  ><strong>电话 :</strong> +96-456-908-8899</h5>
                <br />
                <a  href="mailto:info@wangkun6536@163?Subject=HituServer Question" class="btn btn-primary">发邮件给我们</a>
                <br /><br />
            </div>
        </div>
        <!--LEFT SECTION END-->
    </div>
    <!--ROW END-->
</div>
<!--CONTATINER END-->
</body>
</html>

<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/bootstrap.min.js"></script>
<script src="/HituServer/resources/turn/js/turn.js"></script>
