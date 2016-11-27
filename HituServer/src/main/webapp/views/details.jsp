<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>详情</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/HituServer/resources/common/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    }
    >
    </script>
    <meta name="keywords"
          content="Trip Way Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndriodCompatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>

    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>
    <!-- //end-smoth-scrolling -->
</head>
<body>

<jsp:include page="/views/header.jsp"/>

<!--friend start here-->
<link rel="stylesheet" href="css/swipebox.css">
<script src="js/jquery.swipebox.min.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        $(".swipebox").swipebox();
    });
</script>


<div class="friend">
    <div class="container">
        <div class="friend-main">
            <div class="friend-top">
                <h3>天一阁</h3>
                <p>天一阁位于浙江宁波市区，是中国现存最早的私家藏书楼，也是亚洲现有最古老的图书馆和世界最早的三大家族图书馆之一。
                    天一阁占地面积2.6万平方米，建于明朝中期，由当时退隐的兵部右侍郎范钦主持建造，1982年被国务院公布为全国重点文物保护单位。现藏各类古籍近30万卷，其中珍椠善本8万卷，尤以明代地方志和科举录最为珍贵。
                    我馆事业发展迅速，先后新增中国地方志珍藏馆、银台第官宅博物馆、麻将起源地陈列馆等处。 书阁为木构的二层硬山顶建筑，通高8.5米。
                    底层面阔、进深各六间，前后有廊。二层除楼梯间外为一大通间，以书橱间隔。
                    此外，还在楼前凿“天一池”通月湖，既可美化环境，又可蓄水以防火。天一阁的建筑布局后来为其他藏书楼所效仿。</p>
            </div>
            <div class="friend-bottom">
                <div class="friend-bott-grids">
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f11.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f11.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f12.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f12.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f15.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f15.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="friend-bott-grids">
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f16.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f16.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f17.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f17.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="images/b-f6.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                            <img src="images/f6.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left    b-delay03 "><img
                                    src="images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--friend end here-->

<jsp:include page="/views/footer.jsp"/>

</body>
</html>