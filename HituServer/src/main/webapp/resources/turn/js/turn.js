/**
 * Created by amei on 17-3-27.
 */
$(document).ready(function () {
    showTime(10)
})

//显示倒数秒数
function showTime(t){
    t -= 1;
    document.getElementById('leave-sec').innerHTML= t
    if(t==0){
        var url = document.getElementById("span-url").innerText
        location.href=url
    }
    //每秒执行一次,showTime()
    setTimeout("showTime("+t+")",1000);
}

