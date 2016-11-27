<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的计划</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/plans/css/plans.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all" />

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/HituServer/resources/common/js/jquery.min.js"></script>

</head>
<body>

<jsp:include page="/views/header.jsp"/>

<!---->
<div class="checkout">
    <div class="container">
        <div class="col-md-9 product-price1">
            <div class="check-out">
                <div class="cart-items">
                    <h3>我的计划选项</h3>
                    <script>$(document).ready(function(c) {
                        $('.close1').on('click', function(c){
                            $('.cart-header').fadeOut('slow', function(c){
                                $('.cart-header').remove();
                            });
                        });
                    });
                    </script>
                    <script>$(document).ready(function(c) {
                        $('.close2').on('click', function(c){
                            $('.cart-header1').fadeOut('slow', function(c){
                                $('.cart-header1').remove();
                            });
                        });
                    });
                    </script>

                    <div class="in-check" >
                        <ul class="unit">
                            <li><span>景点概图</span></li>
                            <li><span>景点名</span></li>
                            <li><span>景区级别</span></li>
                            <li><span>景区价格</span></li>
                            <li><span>游玩时间</span></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <ul class="cart-header">
                            <div class="close1"> </div>
                            <li class="ring-in"><a href="/HituServer/views/details.jsp" target="_blank"><img src="images/1.jpg" class="img-responsive" alt=""></a>
                            </li>
                            <li><span>天一阁</span></li>
                            <li><span>AAAA</span></li>
                            <li><span>$20</span></li>
                            <li> <a href="#" class="add-cart cart-check">2小时</a></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <ul class=" cart-header1">
                            <div class="close2"> </div>
                            <li class="ring-in"><a href="/HituServer/views/details.jsp" target="_blank"><img src="images/2.jpg" class="img-responsive" alt=""></a>
                            </li>
                            <li><span>浙江大学软件学院</span></li>
                            <li><span>AAAAA</span></li>
                            <li><span>$0</span></li>
                            <li> <a href="#" class="add-cart cart-check">4小时</a></li>
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 cart-total">
            <a class="continue" href="home.jsp">继续选择</a>
            <div class="price-details">
                <h3>门票花销</h3>
                <span>景点个数</span>
                <span class="total">2个</span>
                <span>总计</span>
                <span class="total">350.00</span>
                <span>打折</span>
                <span class="total">100</span>
                <div class="clearfix"></div>
            </div>
            <h4 class="last-price">总计</h4>
            <span class="total final">250.00</span>
            <div class="clearfix"></div>
            <a class="order" href="plans-result.jsp" target="_blank">开始规划</a>
        </div>
    </div>
</div>
<!---->

<jsp:include page="/views/footer.jsp"/>


</body>
</html>

