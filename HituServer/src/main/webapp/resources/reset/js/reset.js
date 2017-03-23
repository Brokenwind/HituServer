/**
 * Created by amei on 16-11-21.
 */
jQuery(document).ready(function() {
    $.backstretch("/HituServer/resources/reset/images/background.jpg");
});

function showModal(title, content) {
    modal = $('#plan-pop-modal');
    modal.find(".pop-modal-title").text(title)
    modal.find(".pop-modal-content").text(content)
    $('#btn-trigger-pop').click()
}

$("#btn-commit").click(function () {
    commit();
})

function commit(){
    commit_url = "/HituServer/user/commit_password"
    nickname = $("input[name=nickname]").val()
    password = $("input[name=password]").val()
    data={"nickname":nickname,"password":password}
    $.ajax({
        "url":commit_url,
        "data":data,
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
        showModal("更改密码","成功更改密码")
        setTimeout("window.opener=null;window.close()",1000);
        //window.location.href="/HituServer/views/location.jsp"
    }
    else{
        showModal("更改密码","更改密码失败: "+data.message)
    }

}
