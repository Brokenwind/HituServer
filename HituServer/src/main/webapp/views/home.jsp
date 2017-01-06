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
            <li>
                <div class="banner">
                    <div class="caption">
                        <h3>书藏古今，港通天下</h3>
                        <span class="head-line"> </span>
                        <div class="video-play-bwn">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span
                                    class="roundplay-bwn"> </span></a>
                        </div>

                    </div>
                </div>
            </li>
            <li>
                <div class="banner1">
                    <div class="caption">
                        <h3>书藏古今，港通天下</h3>
                        <span class="head-line"> </span>
                        <div class="video-play-bwn">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span
                                    class="roundplay-bwn"> </span></a>
                        </div>
                    </div>
                </div>
            </li>
            <li>
                <div class="banner2">
                    <div class="caption">
                        <h3>书藏古今，港通天下</h3>
                        <span class="head-line"> </span>
                        <div class="video-play-bwn">
                            <a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim"><span
                                    class="roundplay-bwn"> </span></a>
                        </div>
                    </div>
                </div>
            </li>
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
                <h6>宁波</h6>
                <p>
                    宁波，简称甬，副省级市、计划单列市，有制订地方性法规权限的较大的市，长三角五大区域中心之一，长三角南翼经济中心，浙江省经济中心，连续四次蝉联中国文明城市，中国著名的院士之乡，2016年被评为东亚文化之都。2016年4月25日，《第一财经周刊》发布了新的中国城市分级排名榜单，这份榜单里宁波首次被定义为新一线城市。
                    宁波地处东南沿海，位于中国大陆海岸线中段，长江三角洲南翼，东有舟山群岛为天然屏障，北濒杭州湾，西接绍兴市的嵊州、新昌、上虞，南临三门湾，并与台州的三门、天台相连。
                    宁波人文积淀丰厚，历史文化悠久，属于典型的江南水乡兼海港城市，是中国大运河南端出海口、“海上丝绸之路”东方始发港，其中最具宁波代表性的宁波港被国际港航界权威杂志——英国《集装箱国际》评为“世界五佳港口”。
                </p>
            </div>
            <c:forEach items="${sceneries}" var="scenery">
                <div class="col-md-3 pa-more">
                    <div class="work-column">
                        <img src=${scenery.symbolImage} alt="" class="img-cap img-responsive">
                        <div class="porthover">
                            <h3>${scenery.name}</h3>
                            <span class="hover-line"> </span>
                            <h3>${scenery.level}</h3>
                            <span class="hover-line"></span>
                            <h3>${scenery.quality}</h3>
                            <div class="porthover-grids">
                                <a href="/HituServer/scenery/getSceneryByName?name=宁波天一阁博物馆" target="_blank">
                                    <div class="porthover-left">
                                        <span class="port-detail"> </span>
                                        <p>详情</p>
                                    </div>
                                </a>
                                <div class="porthover-right">
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


<jsp:include page="/views/footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<!--pop-up-box-->
<script src="/HituServer/resources/common/js/modernizr.custom.53451.js"></script>
<script src="/HituServer/resources/common/js/jquery.magnific-popup.js"></script>
<script src="/HituServer/resources/common/js/responsiveslides.min.js"></script>
<script src="/HituServer/resources/home/js/sideslip.js"></script>
<script src="/HituServer/resources/home/js/popup.js"></script>

</body>
</html>