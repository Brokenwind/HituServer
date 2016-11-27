<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>detail-maps</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body, html {
            width: 100%;
            height: 100%;
            margin: 0;
            font-family: "微软雅黑";
        }

        #allmap {
            width: 400px;
            height: 400px;
        }

        p {
            margin-left: 5px;
            font-size: 14px;
        }
    </style>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy"></script>
</head>
<body>


<div id="allmap"></div>

<jsp:include page="/views/footer.jsp"/>
</body>
</html>

<script type="text/javascript">
    // 百度地图API功能
    var sContent =
            "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>天一阁</h4>" +
            "<img style='float:right;margin:4px' id='imgDemo' src='images/tianyige.jpg' width='139' height='104' title='天安门'/>" +
            "<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>天一阁位于浙江宁波市区，是中国现存最早的私家藏书楼，也是亚洲现有最古老的图书馆和世界最早的三大家族图书馆之一。天一阁占地面积2.6万平方米，建于明朝中期...</p>" +
            "</div>";
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(121.54611, 29.877579);
    var marker = new BMap.Marker(point);
    var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
    map.centerAndZoom(point, 15);
    map.addOverlay(marker);
    marker.addEventListener("click", function () {
        this.openInfoWindow(infoWindow);
        //图片加载完毕重绘infowindow
        document.getElementById('imgDemo').onload = function () {
            infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
        }
    });
</script>
