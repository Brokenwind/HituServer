<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>规划结果</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/plans/css/result.css" rel="stylesheet" type="text/css" media="all" />
    <!--引用百度地图API-->
    <style type="text/css">
        html,body{margin:0;padding:0;}
        .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
        .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy"></script>
</head>

<body>
<jsp:include page="/views/header.jsp"/>
<div class="mainContext">
    <!--左侧内容-->
    <div class="leftContext">
        <div class="panel-group" id="accordion">
            <%!long i = 1; %>
            <c:forEach items="${routes}" var="route" varStatus="status">
                <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <span class="start-lng"  style="display: none">${route.startLng}</span>
                        <span class="start-lat"  style="display: none">${route.startLat}</span>
                        <span class="end-lng"  style="display: none">${route.endLng}</span>
                        <span class="end-lat"  style="display: none">${route.endLat}</span>
                        <span class="route-index"  style="display: none">${status.index}</span>
                        <a data-toggle="collapse" data-parent="#accordion"
                           href="#collapse${status.index}">
                            ${route.startLng},${route.startLat}---${route.endLng},${route.endLat}
                        </a>
                    </h4>
                </div>
                <div id="collapse${status.index}" class="panel-collapse collapse in">
                    <div class="panel-body">
                        <div id="route${status.index}"></div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <!--右侧内容-->
    <div class="rightContext">
        <div style="width:697px;height:550px;border:#ccc solid 1px;" id="dituContent"></div>
    </div>
</div>

<script src="/HituServer/resources/plans/js/result.js"></script>
<script>
    window.onload = function () {
        $("#plan_li").addClass('active');
    }
</script>
</body>
</html>


