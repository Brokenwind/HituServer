<%--
  Created by IntelliJ IDEA.
  User: amei
  Date: 17-3-8
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>location</title>
    <style type="text/css">
        body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sh0wDYRg1LnB5OYTefZcuHu3zwuoFeOy"></script>
</head>
<body>
<div id="allmap"></div>


// 地图展示
<script type="text/javascript">

    function getCookie(c_name)
    {
        if (document.cookie.length>0)
        {
            c_start=document.cookie.indexOf(c_name + "=")
            if (c_start!=-1)
            {
                c_start=c_start + c_name.length+1
                c_end=document.cookie.indexOf(";",c_start)
                if (c_end==-1) c_end=document.cookie.length
                return unescape(document.cookie.substring(c_start,c_end))
            }
        }
        return ""
    }

    function setCookie(c_name,value)
    {
        var expiredays = 30 * 24 * 3600;
        var exdate=new Date()
        exdate.setDate(exdate.getDate()+expiredays)
        // the paht=/ is very important
        document.cookie=c_name+ "=" +escape(value)+ ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())+";path=/"
    }

    lng = getCookie("current_lng")
    lat = getCookie("current_lat")
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
    map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
    var point = null;
    if ( lng == null || lat == null )
        point = new BMap.Point(116.331398,39.897445);
    else
        point = new BMap.Point(lng,lat);
    map.centerAndZoom(point,15);
    var mk = new BMap.Marker(point);
    map.addOverlay(mk);
    map.panTo(point);
    //单击获取点击的经纬度
    var geoc = new BMap.Geocoder();
    map.addEventListener("click",function(e){
        map.clearOverlays();
        point = e.point;
        mk = new BMap.Marker(point);
        map.addOverlay(mk);
        map.panTo(point);
        setCookie("start_lng",point.lng)
        setCookie("start_lat",point.lat)

        geoc.getLocation(point, function(rs){
            var addComp = rs.addressComponents;
            alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
            setCookie("start_name",addComp.district + ", " + addComp.street + ", " + addComp.streetNumber)
            window.parent.addStart()
        });
    });

    window.onbeforeunload = function()
    {
        setTimeout(function(){_t = setTimeout(onunloadcancel, 0)}, 0);
        return "真的离开?";
    }
</script>

</body>
</html>
