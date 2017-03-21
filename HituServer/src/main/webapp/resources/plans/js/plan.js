/**
 * Created by amei on 17-1-10.
 */

/****************************Cookie relatives*************/

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

/************************* 表格事件处理 *************************/

// 表格中当取消某个选择点的时候
$('.close1').on('click', function (ele) {
    data_row=$(ele.target).parent();
    planid = getCookie("planID")
    lng = data_row.find(".point-lng").text()
    lat = data_row.find(".point-lat").text()
    data = {"planID":planid,"lng":lng,"lat":lat}
    deletePoint(data,data_row)
});

// 游玩时间选择
$(document).ready(function () {
    // 时间选择
    $('#modal-hour-selector').timepicki();
    // 设置modal框中的值
    var data_row = null
    $('.point-time > a').click(function (e) {
        data_row = $(e.target).parent().parent();
        $('#modal-hour-selector').val(data_row.find('li.point-time > a').text());
    });
    // 当modal框的值选择之后，将值设置到表格中
    $('#modal-hour-selector-commit-button').click(function () {
        if ( data_row != null )
            data_row.find('li.point-time > a').text($('#modal-hour-selector').val());
    });
});

/********************进度相关的点击事件**********************/

$("#btn_add_plan").click(function () {
    addPlan()
})

$("#btn_select_medium").click(function () {
    city = getCookie("current_city")
    if ( city == null )
        city = "北京"
    setCookie("current_step","4")
    window.location.href='/HituServer/home?city='+city;
})

$("#btn_go_select").click(function () {
    city = getCookie("current_city")
    if ( city == null )
        city = "北京"
    setCookie("current_step","4")
    window.location.href='/HituServer/home?city='+city;
})

$("#btn_begin_plan").click(function () {
    //commitPlan()
    planid = getCookie("planID")
    userid = getCookie("userID")
    //alert('/HituServer/plan/result?userID='+userid+'&planID='+planid)
    window.location.href='/HituServer/plan/result?userID='+userid+'&planID='+planid;
})

$("#btn_delete_plan").click(function () {
    deleteCookie("planID");
    deleteCookie("current_step");
    showModal("删除计划","删除计划成功")
    setCookie("current_step","1")
    planID  = getCookie("planID")
    window.location="/HituServer/plan/current?planID="+planID
})


// 隐藏指定id的<a>标签
function displayHideUI(id)
{
    var ui =document.getElementById(id);
    ui.style.display="none";
}

// 显示指定id的<a>标签
function displayShowUI(id)
{
    var ui =document.getElementById(id);
    //display为空的话会好使，为block会使后边的空间换行
    ui.style.display="";
}

function hiddenAllSteps() {
    displayHideUI("btn_add_plan");
    displayHideUI("btn_select_start");
    displayHideUI("btn_select_medium");
    displayHideUI("btn_select_end");
}

$(document).ready(function () {
    initSteps();
})

// 根据当前step数来更新进度组件的进度
function updateStepState(step) {
    if (step == null)
        step = "1";
    for ( var i = 0; i < step; i ++ ){
        $(".ui-step").children().eq(i).addClass("step-active")
    }
}

function initSteps() {
    step = getCookie("current_step");
    hiddenAllSteps()
    if ( step == "2" ){
        displayShowUI("btn_select_start")
    }
    else if ( step == "3" ){
        displayShowUI("btn_select_medium")
    }
    else if ( step == "4" ){
        displayShowUI("btn_select_end")
    }
    else{
        displayShowUI("btn_add_plan")
    }
    updateStepState(step)
}

/******************************添加计划*******************************/

function addPlan() {
    create_plan_url = "/HituServer/plan/add"
    userid = getCookie("userID")
    data={"userID":userid,"planlng":getCookie("current_lng"),"planlat":getCookie("current_lat")}
    $.ajax({
        "url":create_plan_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                setCookie("planID",ret.result)
                showModal("添加计划","您已经成功添加了计划")
                // 进入下一步
                setCookie("current_step","2")
                initSteps()
            }
            else{
                showModal("添加计划","添加了计划失败,详细信息:"+ret.message)
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

/**
 * add start point
 * @param data
 */
function addStart() {
    add_start_url="/HituServer/point/addStartPoint"
    lng = getCookie("start_lng")
    lat = getCookie("start_lat")
    name = getCookie("start_name")
    planid = getCookie("planID")
    data={"planID":planid,"lng":lng,"lat":lat,"name":name}
    $.ajax({
        "url":add_start_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                setCookie("current_step","3")
                initSteps()
                showModal("添加起点","您已经成功添加起点，开始选择景点吧")
            }
            else{
                showModal("添加起点","添加终点失败")
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

/**
 * add end point
 * @param data
 */
function addEnd() {
    add_end_url="/HituServer/point/addEndPoint"
    lng = getCookie("end_lng")
    lat = getCookie("end_lat")
    name = getCookie("end_name")
    planid = getCookie("planID")
    data={"planID":planid,"lng":lng,"lat":lat,"name":name}
    $.ajax({
        "url":add_end_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                setCookie("current_step","4")
                initSteps()
                showModal("添加终点","您已经成功添加终点")
            }
            else{
                showModal("添加终点","添加终点失败")
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

/**
 * delete the scenery point you selected
 */
function deletePoint(data,data_row) {
    delete_point_url="/HituServer/point/deleteMediumPoint"
     $.ajax({
        "url":delete_point_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                showModal("删除景点","您已经成功删除景点")
                data_row.fadeOut('slow', function (c) {
                    data_row.remove();
                });
            }
            else{
                showModal("删除景点","删除景点失败"+ret.message)
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

function commitPlan() {
    commit_plan="/HituServer/plan/commit"
    data = {"userID":getCookie("userID"),"planID":getCookie("planID")}
    $.ajax({
        "url":commit_plan,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                //showModal("规划成功","已经为你成功规划")
                routes = ret.result
            }
            else{
                showModal("规划失败","失败原因"+ret.message)
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}


function calTime(data) {
    var minu = 0;
    if ( data != null ){

    }
}

