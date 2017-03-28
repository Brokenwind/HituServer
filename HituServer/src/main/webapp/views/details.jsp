<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>详情</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/detail/css/detail.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/detail/css/image-show.css" rel="stylesheet" type="text/css" media="all"/>
    <!--friend start here-->
    <link href="/HituServer/resources/common/css/swipebox.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="keywords" content="Trip Way web design"/>
    <style type="text/css">
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>

    <script type="text/javascript" src="http://api.map.baidu.com/api?key=sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy&v=1.1&services=true"></script>
</head>
<body>

<jsp:include page="/views/header.jsp"/>

<!-- simple message -->
<div class="welcome">
    <div class="welcome-left new-left">
        <h3>${scenery.name}</h3>
        <div class="new-grids">
            <div class="date">
                <p>等級</p>
            </div>
            <div class="new-grid-right">
                <p>${scenery.level}</p>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="new-grids">
            <div class="date">
                <p>类型</p>
            </div>
            <div class="new-grid-right">
                <p>${scenery.type}</p>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="welcome-right">
        <img  src="${pics[0].imageUrl}"/>
    </div>
    <div class="clearfix"> </div>
</div>
<!-- //new -->

<!-- position -->
<div class="welcome">
    <div class="welcome-left offer-left">
        <h3>地理位置</h3>
        <!--百度地图容器-->
        <div style="width:600px;height:400px;border:#ccc solid 1px;" id="dituContent"></div>
        <div class="clearfix"> </div>
    </div>
    <div class="welcome-right">
        <img  src="${pics[1].imageUrl}"/>
    </div>
    <div class="clearfix"> </div>
</div>
<!-- //offer -->

<!-- banner-bottom -->
<div class="welcome">
    <div class="welcome-left">
        <h3>简介</h3>
        <p id="scenery-desc">${scenery.description}</p>
    </div>
    <div class="welcome-right">
        <img src="${pics[2].imageUrl}"/>
    </div>
    <div class="clearfix"> </div>
</div>

<!-- end here-->

<!-- image show start-->
<!--top-nav-->
<div class="top-nav wow">
    <div class="container">
        <div class="navbar-header logo">
        </div>
        <h2>图片展示</h2>
    </div>
</div>
<!--//top-nav-->

<!--portfolio-->
<div id="projects" class="portfolio">
    <div class="container">
        <c:forEach items="${pics}" var="pic">
        <div class="col-md-4 portfolio-grids">
            <div class="grid">
                <a href="${pic.imageUrl}" class="swipebox" title="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis maximus tortor diam, ac lobortis justo rutrum quis. Praesent non purus fermentum, eleifend velit non">
                    <img src="${pic.imageUrl}"  alt="" style="width:400px;height:400px;display: block"/>
                    <div class="figcaption">
                        <h3>${scenery.city}</h3>
                        <p>${pic.imageName}</p>
                    </div>
                </a>
            </div>
        </div>
        </c:forEach>
        <div class="clearfix"> </div>
    </div>
</div>
<!--//portfolio-->
<!-- image show end-->

<jsp:include page="/views/footer.jsp"/>

<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.swipebox.min.js"></script>
<!--控制文字只显示多行,超出一部分显示省略号-->
<script src="/HituServer/resources/detail/js/clamp.js"></script>
<script src="/HituServer/resources/detail/js/map-detail.js"></script>
<script type="text/javascript">
    $(document).ready(
            function () {
                $(".swipebox").swipebox();
                // 隐藏多余的文字
                var node=document.getElementById("scenery-desc");
                $clamp(node,{clamp:15});
            }
    )
</script>

</body>
</html>