<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/home/css/home.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/common/css/popup-box.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

<jsp:include page="/views/header.jsp"/>

<!--图片切换显示-->
<div class="slider">
    <div class="callbacks_container">
        <ul class="rslides" id="slider">
            <c:forEach items="${images}" var="image" varStatus="status">
            <li>
                <div class="banner" style="background: url('${image.imageUrl}')no-repeat center">
                    <div class="caption">
                        <span class="head-line"> </span>
                    </div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>

<!-- 弹出框显示的位置 -->
<div id="small-dialog5" class="mfp-hide">
    <iframe src="/HituServer/views/details.jsp" width="500" height="213" frameborder="0" webkitallowfullscreen
            mozallowfullscreen allowfullscreen></iframe>
</div>

<div class="portfolio">
    <div class="portfolio-main">
        <div class="portfolio-bottom">
            <div class="port-nav-left">
                <h6>${city.name}</h6>
                <p>
                    ${city.description}
                </p>
            </div>
            <c:forEach items="${sceneries}" var="scenery">
                <div class="col-md-3 pa-more" id="${scenery.sceneryID}">
                    <div class="work-column">
                        <img src="${scenery.symbolImage}" style="width:600px;height:400px;">
                        <div class="porthover">
                            <h3 class="scenery-lng" hidden="hidden">${scenery.longitude}</h3>
                            <h3 class="scenery-lat" hidden="hidden">${scenery.latitude}</h3>
                            <h3 class="scenery-price" hidden="hidden">${scenery.price}</h3>
                            <h3 class="scenery-opentime" hidden="hidden">${scenery.openTime}</h3>
                            <h3 class="scenery-closetime" hidden="hidden">${scenery.closeTime}</h3>
                            <h3 class="scenery-name">${scenery.name}</h3>
                            <span class="hover-line"> </span>
                            <h3 class="scenery-level">${scenery.level}</h3>
                            <span class="hover-line"></span>
                            <h3>${scenery.quality}</h3>
                            <div class="porthover-grids">
                                <a href="/HituServer/details?name=${scenery.name}" target="_blank">
                                    <div class="porthover-left">
                                        <span class="port-detail"> </span>
                                        <p>详情</p>
                                    </div>
                                </a>
                                <div class="porthover-right" name="${scenery.sceneryID}" style="cursor: pointer;">
                                    <span class="heart"></span>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<!--portfolio end here-->

<jsp:include page="/views/popwindow.jsp"/>
<jsp:include page="/views/footer.jsp"/>

<!--pop-up-box-->
<script src="/HituServer/resources/common/js/modernizr.custom.53451.js"></script>
<script src="/HituServer/resources/common/js/jquery.magnific-popup.js"></script>
<script src="/HituServer/resources/common/js/responsiveslides.min.js"></script>
<script src="/HituServer/resources/common/js/popup.js"></script>
<script src="/HituServer/resources/home/js/sideslip.js"></script>
<script src="/HituServer/resources/home/js/planrel.js"></script>
<script>
    window.onload = function () {
        $("#home_li").addClass('active');
    }
</script>
</body>
</html>