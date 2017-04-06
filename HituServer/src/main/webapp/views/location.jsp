<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HituServer/resources/common/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="/HituServer/resources/location/css/location.css" rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy"></script>
</head>
<body>

<div class="content">
    <div class="container">
        <div class="text-center">
            <a href="#"><h1>出行无忧</h1></a>
            <h2>我们为你规划旅游出行</h2>
        </div>
        <div role="form">
            <div class="row">
                <button id="location-button" disabled="disabled" class="btn btn-lg btn-primary col-lg-2 col-lg-offset-1">
                    城市
                </button>
                <div class="col-lg-6">
                    <div class="input-group input-group-lg">
                        <input id="input-city" name="input-city" type="text" class="form-control">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown">历史查询
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu pull-right" role="menu">
                                <li>
                                    <a href="#">宁波</a>
                                </li>
                                <li>
                                    <a href="#">杭州</a>
                                </li>
                                <li>
                                    <a href="#">北京</a>
                                </li>
                            </ul>
                        </div><!-- /btn-group -->
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <button id="location-submit" type="submit" class="btn btn-lg btn-warning col-lg-2">
                    查询
                </button>
            </div>
        </div>
    </div>
</div>
<!-- header-ends -->

<div id="allmap" hidden="hidden"></div>

<jsp:include page="/views/footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/bootstrap.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
<script src="/HituServer/resources/location/js/location.js"></script>

</body>
</html>