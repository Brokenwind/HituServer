/**
 * Created by amei on 17-3-16.
 */
/************************Map relative ************************/

//创建和初始化地图函数：
function initMap(){
    createMap();//创建地图
    setMapEvent();//设置地图事件
    addMapControl();//向地图添加控件
}

//创建地图函数：
function createMap(){
    var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
    var point = new BMap.Point(121.644576,29.896124);//定义一个中心点坐标
    map.centerAndZoom(point,17);//设定地图的中心点和坐标并将地图显示在地图容器中
    window.map = map;//将map变量存储在全局
}

//地图事件设置函数：
function setMapEvent(){
    map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
    map.enableScrollWheelZoom();//启用地图滚轮放大缩小
    map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
    map.enableKeyboard();//启用键盘上下左右键移动地图
}

//地图控件添加函数：
function addMapControl(){
    //向地图中添加缩放控件
    var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_SMALL});
    map.addControl(ctrl_nav);
    //向地图中添加比例尺控件
    var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
    map.addControl(ctrl_sca);
}

function route(startLng, startLat, endLng, endLat,panel) {
    map.centerAndZoom(new BMap.Point(startLng,startLat), 12);
    var p1 = new BMap.Point(startLng,startLat);
    var p2 = new BMap.Point(endLng,endLat);
    var transit = new BMap.TransitRoute(map, {
        renderOptions: {map: map,panel:panel}
    });
    map.clearOverlays();
    transit.search(p1, p2);
}

initMap();//创建和初始化地图

/*********************Event*****************************/
$(".panel-title").on("click",function (elem) {
    tag = $(elem.target).parent()
    if ( tag.attr("class") == "panel-title"){
        startLng = tag.find('.start-lng').text()
        startLat = tag.find('.start-lat').text()
        endLng = tag.find('.end-lng').text()
        endLat = tag.find('.end-lat').text()
        panelID = "route"+tag.find('.route-index').text()
        route(startLng,startLat,endLng,endLat,panelID)
    }
})

