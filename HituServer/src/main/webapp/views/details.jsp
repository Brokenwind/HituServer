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
    <!--friend start here-->
    <link href="/HituServer/resources/common/css/swipebox.css" rel="stylesheet" type="text/css" media="all"/>

    <meta name="keywords" content="Trip Way web design"/>

</head>
<body>

<jsp:include page="/views/header.jsp"/>

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
                        <a href="/HituServer/resources/detail/images/b-f11.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1483608451194&di=482a49a431e584bcac5408b8d965f547&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F3b87e950352ac65c1b6a0042f9f2b21193138a97.jpg" style="width:100px;height:100px;"/>
                            <div class="b-wrapper">
                                <h2 class="b-animate b-from-left b-delay03 ">
                                <img src="/HituServer/resources/detail/images/plus.png" alt="">
                                </h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="/HituServer/resources/detail/images/b-f12.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="/HituServer/resources/detail/images/f12.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left b-delay03 "><img
                                    src="/HituServer/resources/detail/images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="/HituServer/resources/detail/images/b-f15.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="/HituServer/resources/detail/images/f15.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left b-delay03 "><img
                                    src="/HituServer/resources/detail/images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="friend-bott-grids">
                    <div class="col-md-4 friend-wrapper">
                        <a href="/HituServer/resources/detail/images/b-f16.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="/HituServer/resources/detail/images/f16.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left b-delay03 "><img
                                    src="/HituServer/resources/detail/images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="/HituServer/resources/detail/images/b-f17.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="/HituServer/resources/detail/images/f17.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left b-delay03 "><img
                                    src="/HituServer/resources/detail/images/plus.png" alt=""></h2>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 friend-wrapper">
                        <a href="/HituServer/resources/detail/images/b-f6.jpg"
                           class="b-link-stripe b-animate-go swipebox" title="天一阁">
                            <img src="/HituServer/resources/detail/images/f6.jpg"/>
                            <div class="b-wrapper"><h2 class="b-animate b-from-left b-delay03 "><img
                                    src="/HituServer/resources/detail/images/plus.png" alt=""></h2>
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
<!-- end here-->

<jsp:include page="/views/footer.jsp"/>

<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.swipebox.min.js"></script>
<script type="text/javascript">
    $(document).ready(
            function () {
                $(".swipebox").swipebox();
            }
    )
</script>

</body>
</html>