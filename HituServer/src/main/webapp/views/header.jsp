<%--
  Created by IntelliJ IDEA.
  User: amei
  Date: 16-11-20
  Time: 下午1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="/HituServer/resources/header/css/header.css" rel="stylesheet" type="text/css" media="all">
<link href="/HituServer/resources/modal/css/component.css"  rel="stylesheet" type="text/css" />

<!--start-header-->
<div class="header" id="home">
    <div class="container">
        <div class="head">
            <div class="logo">
                <a href="/HituServer/views/location.jsp"><img src="/HituServer/resources/common/images/logo.png" alt=""/></a>
            </div>
            <div class="navigation">
                <span class="menu"></span>
                <ul class="navig">
                    <li><a id = "home_li" href="#" class="hvr-bounce-to-bottom">景点</a></li>
                    <li><a id = "plan_li" href="#"  class="hvr-bounce-to-bottom">计划</a></li>
                    <li><a id = "personal_li" href="#" class="hvr-bounce-to-bottom">个人中心</a></li>
                    <li><a id = "contact_li" href="#" class="hvr-bounce-to-bottom">联系我们</a></li>
                    <!--
                    <li class="hvr-bounce-to-bottom">
                        <a id = "#" href="#" class="glyphicon glyphicon-user"></a>
                        <div id="loginBox">
                            <form id="loginForm">
                                <fieldset id="body">
                                    <fieldset>
                                        <label for="email">Email Address</label>
                                        <input type="text" name="email" id="email">
                                    </fieldset>
                                    <fieldset>
                                        <label for="password">Password</label>
                                        <input type="password" name="password" id="password">
                                    </fieldset>
                                    <input type="submit" id="login" value="Sign in">
                                    <label for="checkbox"><input type="checkbox" id="checkbox"> <i>Remember me</i></label>
                                </fieldset>
                                <p>New User ? <a class="sign" href="account.html">Sign Up</a> <span><a href="#">Forgot your password?</a></span></p>
                            </form>
                        </div>
                    </li>
                    <li class="hvr-bounce-to-bottom">
                        <a id = "#" href="#" class="glyphicon glyphicon-shopping-cart"></a>
                        <div class="cart-box">
                            <h4><a href="checkout.html">
                                <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>)
                            </a></h4>
                            <p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
                            <div class="clearfix"> </div>
                        </div>
                    </li>
                    -->
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/bootstrap.min.js"></script>
<script src="/HituServer/resources/header/js/header.js"></script>


