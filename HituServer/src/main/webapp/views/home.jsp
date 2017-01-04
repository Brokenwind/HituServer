<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/common/css/popup-box.css" rel="stylesheet" type="text/css" media="all">


    <!-- 图片列表展示的样式-->
    <style>
        /* start grids_of_3 */
        .grids_of_3 {
            display: block;
            padding: 0% 0% 1%;
        }

        .grid1_of_3 {
            float: left;
            width: 30.333333%;
            margin-left: 4.33333%;

        }

        .grid1_of_3:first-child, .grid1_of_3:nth-child(4) {
            margin-left: 0;
        }

        .grid1_of_3 h4 a {
            margin: 4% 0;
            display: block;
            font-size: 1.5em;
            text-decoration: none;
            color: #8A8A8A;
            text-transform: capitalize;
            font-weight: 400;
            -webkit-transition: all 0.3s ease-in-out;
            -moz-transition: all 0.3s ease-in-out;
            -o-transition: all 0.3s ease-in-out;
            transition: all 0.3s ease-in-out;
        }

        .grid1_of_3 h4 span {
            font-weight: 600;
            padding-left: 10px;
            color: #202020;
        }

        .grid1_of_3 h4 a:hover {
            color: #202020;
        }

        .grid1_of_3 p {
            font-size: 1em;
            color: #444444;
            line-height: 1.8em;
            margin-bottom: 3em;
        }

        .grid1_of_3_img {
            position: relative;
        }
        .grid1_of_3 p {
            font-size: 0.8em;
        }

        .grid1_of_3_img img {
            width: 100%;
        }
    </style>
</head>

<body>

<jsp:include page="/views/header.jsp"/>


<script>
</script>
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
    <iframe src="/HituServer/views/specified-map.jsp" width="500" height="213" frameborder="0" webkitallowfullscreen
            mozallowfullscreen allowfullscreen></iframe>
</div>


<div class="container">
    <div class="port-nav-left">
        <h6>宁波风貌</h6>
        <p>
            宁波，简称甬，副省级市、计划单列市，有制订地方性法规权限的较大的市，长三角五大区域中心之一，长三角南翼经济中心，浙江省经济中心，连续四次蝉联中国文明城市，中国著名的院士之乡，2016年被评为东亚文化之都。2016年4月25日，《第一财经周刊》发布了新的中国城市分级排名榜单，这份榜单里宁波首次被定义为新一线城市。
            宁波地处东南沿海，位于中国大陆海岸线中段，长江三角洲南翼，东有舟山群岛为天然屏障，北濒杭州湾，西接绍兴市的嵊州、新昌、上虞，南临三门湾，并与台州的三门、天台相连。
        </p>
    </div>

    <!--portfolio end here-->

    <!--start grids_of_3 -->
    <div class="grids_of_3">
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic2.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>
                天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic1.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，
                所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic3.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，
                所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic2.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，
                所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic1.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，
                所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="grid1_of_3">
            <div class="grid1_of_3_img">
                <a href="/HituServer/views/details.jsp" target="_blank">
                    <img src="/HituServer/resources/home/images/b-pic3.jpg" alt=""/>
                    <span class="next"> </span>
                </a>
            </div>
            <h4><a href="#small-dialog5" class="thickbox play-icon popup-with-zoom-anim">等级<span>AAAA</span></a></h4>
            <p>天一阁之名，取义于汉郑玄《易经注》中天一生水之说，因为火是藏书楼最大的祸患，而“天一生水”，可以以水克火，
                所以取名“天一阁”。书阁是硬山顶重楼式，面阔、进深各有六间，前后有长廊相互沟通。楼前有“天一池”，引水入池，蓄水以防火。康熙四年（公元1665年），范钦的曾孙范光文又绕池叠砌假山、修亭建桥、种花植草，使整个的楼阁及其周围初具江南私家园林的风貌。</p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>


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