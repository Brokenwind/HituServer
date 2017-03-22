/**
 * Created by amei on 17-3-21.
 */
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

function updateInfo(data) {
    add_start_url="/HituServer/user/updateUser"
    $.ajax({
        "url":add_start_url,
        "data":data,
        "datatype":"json",
        "type":"GET",
        "contentType":"application/json",
        "success":function (ret) {
            if (ret.status == 0){
                showModal("更新信息","更新信息成功")
                window.location="/HituServer/personal?userID="+getCookie("userID")
            }
            else{
                showModal("更新信息","更新信息失败"+ret.message)
            }
        },
        "error":function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error happend")
        }
    })
}

$("#user-submit").click(function () {
    var form_data = $('#form_data').serialize();
    updateInfo(form_data)
})


