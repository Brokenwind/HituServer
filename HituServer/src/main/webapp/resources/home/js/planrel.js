/**
 * Created by amei on 17-1-11.
 */

function setCookie(c_name,value)
{
    var expiredays = 30 * 24 * 3600;
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    // the paht=/ is very important
    document.cookie=c_name+ "=" +escape(value)+ ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())+";path=/"
}

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

function deleteCookie(c_name)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()-10)
    var cval = getCookie(c_name);
    if (cval!=null){
        document.cookie=c_name+ "=" +escape(cval)+";expires="+exdate.toGMTString()+";path=/"
    }
}

$(document).ready(function () {
    $('.porthover-right').click(function (ele) {
        name = $(ele.target).parent().attr('name')
        scenery=$("#"+name)
        lng = scenery.find(".scenery-lng").text()
        lat = scenery.find(".scenery-lat").text()
        price = scenery.find(".scenery-price").text()
        opentime = scenery.find(".scenery-opentime").text()
        closetime = scenery.find(".scenery-closetime").text()
        level = scenery.find(".scenery-level").text()
        scename = scenery.find(".scenery-name").text()
        userid = getCookie("userID")
        planid = getCookie("planID");
        if (userid != null && userid != ""){
            // there is no plan
            if (planid != null && planid != ""){
                datas={"planID":planid,"lng":lng,"lat":lat,"name":scename,"openTime":opentime,"closeTime":closetime,"level":level,"price":0}
                addPoint(datas)
            }
            else{
                showModal("提示","您还没有创建计划，请先创建计划")
            }
        }
        // did not login
        else{
            showModal("登陆提示","您还没有登陆，请登陆")
            window.location.href="/HituServer/views/login.jsp"
        }
    })
})


function addPoint(data) {
    add_point_url="/HituServer/point/addMediumPoint"
    $.ajax({
        "url":add_point_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                setCookie("current_step","4")
                showModal("添加景点","您已经成功添加此景点")
            }
            else{
                showModal("添加景点","添加景点失败,详情:"+ret.message)
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

