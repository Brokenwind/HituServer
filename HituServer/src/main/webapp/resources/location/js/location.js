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
    function myFun(result){

        var city = result.name
        // 创建地址解析器实例
        var myGeo = new BMap.Geocoder();

        // 将地址解析结果显示在地图上,并调整地图视野
        myGeo.getPoint(city, function(point){
            if (point) {
                setCookie("current_lng",point.lng)
                setCookie("current_lat",point.lat)
            }else{
                alert("您选择地址没有解析到结果!");
            }
        }, city);
        city = city.substring(0,city.length-1)
        setCookie("current_city",city)
        alert("当前定位城市:"+city);
        $("#input-city").val(city)
    }
    var myCity = new BMap.LocalCity();
    myCity.get(myFun);
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