/**
 * Created by amei on 16-11-21.
 */
jQuery(document).ready(function() {
    $.backstretch("/HituServer/resources/register/images/background.jpg");
    // remember account and password
    account = getCookie("hitu-account")
    password = getCookie("hitu-password")
    if (account != "" && password != ""){
        $("input[name=account]").val(account)
        $("input[name=password]").val(password)
    }
});

$('#btn-login').click(function (e) {
    login()
})

function login(){
    login_url = "/HituServer/user/weblogin"
    type = $("input[name=type]").val()
    account = $("input[name=account]").val()
    password = $("input[name=password]").val()
    datas={"type":type,"account":account,"password":password}
    $.ajax({
        "url":login_url,
        "data":datas,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":process,
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

function process(data) {
    if (data.status == '0'){
        setCookie("userID",data.result)
        account = $("input[name=account]").val()
        password = $("input[name=password]").val()
        setCookie("hitu-account",account)
        setCookie("hitu-password",password)
        window.location.href="/HituServer/views/location.jsp"
    }
    else
        alert("login failed")
}

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
    exdate.setDate(exdate.getDate()-1)
    var cval = getCookie(c_name);
    if (cval!=null){
        document.cookie=c_name+ "=" +escape(cval)+";expires="+exdate.toGMTString()+";path=/"
    }
}
