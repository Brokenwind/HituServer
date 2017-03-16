/**
 * Created by amei on 17-3-15.
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

$("#home_li").click(function () {
    city  = getCookie("current_city")
    window.location="/HituServer/home?city="+city
})

$("#plan_li").click(function () {
    planID  = getCookie("planID")
    window.location="/HituServer/plan/current?planID="+planID
})

$("#about_li").click(function () {
    city  = getCookie("current_city")
    window.location="/HituServer/views/about.jsp"
})

$("#contact_li").click(function () {
    city  = getCookie("current_city")
    window.location="/HituServer/views/contact.jsp"
})


/************************对话框************************/
function showModal(title, content) {
    modal = $('#plan-pop-modal');
    modal.find(".pop-modal-title").text(title)
    modal.find(".pop-modal-content").text(content)
    $('#btn-trigger-pop').click()
}
