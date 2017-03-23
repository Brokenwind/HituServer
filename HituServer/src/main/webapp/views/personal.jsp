<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Personal Center</title>
    <!--mobile apps-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link href="/HituServer/resources/common/css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
    <link href="/HituServer/resources/personal/css/personal.css" type="text/css" rel="stylesheet" media="all">
    <!--js-->
    <script src="/HituServer/resources/common/js/jquery.min.js"></script>
    <!--start-smooth-scrolling-->
    <script type="text/javascript" src="/HituServer/resources/personal/js/move-top.js"></script>
    <script type="text/javascript" src="/HituServer/resources/common/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>
    <!--//end-smooth-scrolling-->
</head>
<body>

<jsp:include page="/views/popwindow.jsp"/>
<jsp:include page="/views/header.jsp"/>

<!--banner-->
<div id="home" class="banner">
    <div class="banner-info">
        <div class="container">
            <div class="col-md-4 header-left">
                <img src="/HituServer/resources/personal/images/img1.jpg" alt=""/>
            </div>
            <div class="col-md-8 header-right">
                <h1>${user.nickname}
                    <button class="btn btn-primary" data-toggle="modal" data-target="#change-info"
                            class="btn btn-primary btn-large">更改信息
                    </button>
                </h1>
                <h6>${user.description}</h6>
                <ul class="address">
                    <li>
                        <ul class="address-text">
                            <li><b>性别</b></li>
                            <li>${user.sex}</li>
                        </ul>
                    </li>
                    <li>
                        <ul class="address-text">
                            <li><b>电话 </b></li>
                            <li>${user.phone}</li>
                        </ul>
                    </li>
                    <li>
                        <ul class="address-text">
                            <li><b>地址 </b></li>
                            <li>${user.address}</li>
                        </ul>
                    </li>
                    <li>
                        <ul class="address-text">
                            <li><b>邮箱 </b></li>
                            <li><a href="mailto:example@mail.com">${user.email}</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//banner-->

<!--top-nav-->
<div class="top-nav wow">
    <div class="container">
        <div class="navbar-header logo">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                Menu
            </button>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="menu">
                <ul class="nav navbar">
                    <li><a href="#work" class="scroll">我的计划</a></li>
                    <li><a href="#education" class="scroll">我的足迹</a></li>
                    <li><a href="#skills" class="scroll">Skills</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!--//top-nav-->

<!--work-experience-->
<div id="work" class="work">
    <div class="container">
        <h3 class="title">我的计划</h3>
        <c:forEach items="${planline}" var="line" varStatus="status">
            <c:if test="${status.index%2==0}">
                <div class="work-info">
                    <div class="col-md-6 work-left">
                        <h4>${line.time}</h4>
                    </div>
                    <div class="col-md-6 work-right">
                        <h5><span class="glyphicon glyphicon-briefcase"> </span>${line.city}</h5>
                        <p>${line.content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </c:if>

            <c:if test="${status.index%2!=0}">
                <div class="work-info">
                    <div class="col-md-6 work-right work-right2">
                        <h4>${line.time}</h4>
                    </div>
                    <div class="col-md-6 work-left work-left2">
                        <h5><span class="glyphicon glyphicon-briefcase"> </span>${line.city}</h5>
                        <p>${line.content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<!--//work-experience-->

<!--education-->
<div id="education" class="education">
    <div class="container">
        <h3 class="title">我的足迹</h3>
        <c:forEach items="${traces}" var="trace" varStatus="status">
            <c:if test="${status.index%2==0}">
                <div class="work-info">
                    <div class="col-md-6 work-left">
                        <h4>${trace.strdate}</h4>
                    </div>
                    <div class="col-md-6 work-right">
                        <h5><span class="glyphicon glyphicon-education"> </span>${trace.city}</h5>
                        <p>${trace.address}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </c:if>
            <c:if test="${status.index%2!=0}">
                <div class="work-info">
                    <div class="col-md-6 work-right work-right2">
                        <h4>${trace.strdate}</h4>
                    </div>
                    <div class="col-md-6 work-left work-left2">
                        <h5><span class="glyphicon glyphicon-education"></span>${trace.city}</h5>
                        <p>${trace.address}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<!--//education-->

<!-- modal start-->
<!-- 模态框示例（Modal） -->
<form class="form-horizontal"  role="form" id="form_data">
<div class="modal fade" id="change-info" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改信息
                </h4>
            </div>
            <div class="modal-body">
                    <input type="text" style="display: none" class="form-control" id="form-userid" name="userID"
                           value="${user.userID}">
                    <input type="text" style="display: none" class="form-control" id="form-province" name="province"
                           value="${user.province}">
                    <input type="text" style="display: none" class="form-control" id="form-city" name="city"
                           value="${user.city}">
                    <input type="text" style="display: none" class="form-control" id="form-profileImageUrl"
                           name="profileImageUrl" value="${user.profileImageUrl}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用戶名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="form-nickname" name="nickname"
                                   value="${user.nickname}"
                                   placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">性別</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="form-sex" name="sex" value="${user.sex}"
                                   placeholder="男">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">電話</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="form-phone" name="phone" value="${user.phone}"
                                   placeholder="男">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">郵箱</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="form-email" name="email" value="${user.email}"
                                   placeholder="男">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="form-address" name="address"
                                   value="${user.address}"
                                   placeholder="地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">描述</label>
                        <div class="col-sm-9">
                            <input class="form-control" id="form-description" name="description"
                                   value="${user.description}"
                                   placeholder="描述">
                            </input>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="user-submit" class="btn btn-primary" data-dismiss="modal">
                    提交
                </button>
                <span id="tip"> </span>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
<!-- modal end-->

<!--footer-->
<div class="footer">
    <div class="container">
        <p>© 2016 My Resume. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
    </div>
</div>
<!--//footer-->

<!--smooth-scrolling-of-move-up-->
<script type="text/javascript">
    $(document).ready(function () {

        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<script>
    window.onload = function () {
        $("#personal_li").addClass('active');
    }
</script>
<!--//smooth-scrolling-of-move-up-->
<!-- Bootstrap core JavaScript
================================================== -->

<script src="/HituServer/resources/personal/js/userinfo.js"></script>
</body>
</html>