/**
 * Created by amei on 16-11-20.
 */
function setCookie(c_name,value)
{
    var expiredays = 30 * 24 * 3600;
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    // the paht=/ is very important
    document.cookie=c_name+ "=" +escape(value)+ ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())+";path=/"
}

$(document).ready(
    function () {
        $(".content").backstretch("/HituServer/resources/location/images/location_background.jpg");
    }
);

// 定位功能，并记录经纬度到Cookie
$(document).ready(function () {
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus() == BMAP_STATUS_SUCCESS){
            city = r.address.city.toString();
            city = city.substring(0,city.length-1)
            setCookie("current_city",city)
            setCookie("current_lng",r.point.lng)
            setCookie("current_lat",r.point.lat)
            alert('您的位置：'+city);
            $("#input-city").val(city)
        }
        else {
            alert('定位失败'+this.getStatus());
        }
    },{enableHighAccuracy: true})
    //关于状态码
    //BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
    //BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
    //BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
    //BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
    //BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
    //BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
    //BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
    //BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
    //BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
})

$(function(){
    $("li").click(function(){
        city = $(this).text()
        $('input[name=input-city]').val(city)
    })
});

$("#location-submit").click(function (e) {
    city = $.trim($('input[name=input-city]').val())
    window.location.href="/HituServer/home?city="+city
})