/**
 * Created by amei on 17-3-26.
 */
$(window).load(function() {
    var options =
    {
        thumbBox: '.thumbBox',
        spinner: '.spinner',
        imgSrc: 'images/avatar.png'
    }
    var cropper = $('.imageBox').cropbox(options);
    $('#get-file').on('change', function(){
        var reader = new FileReader();
        reader.onload = function(e) {
            options.imgSrc = e.target.result;
            cropper = $('.imageBox').cropbox(options);
        }
        reader.readAsDataURL(this.files[0]);
        this.files = [];
    })
    $('#btnCrop').on('click', function(){
        var img = cropper.getDataURL();
        $('.cropped').html('');
        $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
        $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
        $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
    })
    $('#btnZoomIn').on('click', function(){
        cropper.zoomIn();
    })
    $('#btnZoomOut').on('click', function(){
        cropper.zoomOut();
    })
});

/********************上传临时素材  Start*****************************/
function uploadHead() {
    //var image0 = $("input[name='file_temporaryImage']").val();
    //判断上传控件中是否选择了图片
    var image = $("#get-file").val();
    if ($.trim(image) == "") {
        alert("请选择图片！");
        return;
    }
    //提交请求处理的url
    var actionUrl = "/HituServer/user/updateHead";
    //开始ajax操作
    $("#form-head-image").ajaxSubmit({
        type: "POST",//提交类型
        dataType: "json",//返回结果格式
        url: actionUrl,//请求地址
        success: function (data) {
            if (data.status != 0 ) {//返回警告
                alert(data.message);
            } else{//返回成功
                showModal("更改头像","更改头像成功")
                window.location.reload();
            }
        },
        error: function (data) { alert(data.msg); },//请求失败的函数
        async: true
    });
}