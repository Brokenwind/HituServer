<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HituServer/resources/common/css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="/HituServer/resources/location/css/location.css" rel='stylesheet' type='text/css'/>
</head>
<body>

<div class="content">
    <div class="container">
        <div class="text-center">
            <a href="home.jsp"><h1>出行无忧</h1></a>
            <h2>我们为你规划旅游出行</h2>
        </div>
        <form role="form" action="home.jsp" method="post">
            <div class="row">
                <button id="location-button" disabled="disabled" class="btn btn-lg btn-primary col-lg-2 col-lg-offset-1">
                    宁波
                </button>
                <div class="col-lg-6">
                    <div class="input-group input-group-lg">
                        <input type="text" class="form-control">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default  dropdown-toggle" data-toggle="dropdown">历史查询
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu pull-right">
                                <li>
                                    <a href="#">浙江大学软件学院（宁波分校）</a>
                                </li>
                                <li>
                                    <a href="#">宁波天一阁</a>
                                </li>
                                <li>
                                    <a href="#">宁波老外滩</a>
                                </li>
                            </ul>
                        </div><!-- /btn-group -->
                    </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
                <button id="location-submit" type="submit" class="btn btn-lg btn-warning col-lg-2">
                    查询
                </button>
            </div>
        </form>
    </div>
</div>
<!-- header-ends -->

<jsp:include page="/views/footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
<script src="/HituServer/resources/location/js/background.js"></script>

</body>
</html>