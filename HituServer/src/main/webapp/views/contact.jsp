<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Message</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/HituServer/resources/common/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/contact/css/contact.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/about/css/about.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="/HituServer/resources/common/css/swipebox.css">
    <meta name="keywords"
          content="Trip Way Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndriodCompatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
</head>
<body>

<jsp:include page="/views/header.jsp"/>

<!--message start here-->
<div class="message">
    <div class="container">
        <div class="message-main">
            <div class="message-bottom">
                <div class="col-md-6 message-left">
                    <div class="con-info">
                        <h3>联系我们</h3>
                        <p> 想对我们提出功能建议？<br/>
                            发现了网页中的问题想告诉我们？<br/>
                            还是其他网友未经你的允许擅自上传了你的图片或文字？<br/>
                            请通过邮箱：wangkun6536@163.com 把你想说的一切告诉我们吧！<br/>
                            期望与我们在内容、品牌或是其他层面上开展合作？<br/>
                            无论你是旅游局、商家还是机构，<br/>
                            请将你的合作设想及详细联系方式发送至邮箱：wangkun6536@163.com<br/>
                        </p>
                    </div>
                    <div class="con-addr">
                        <h4>联系方式</h4>
                        <p>地址: 宁波浙江大学软件学院</p>
                        <p>电话: (852) 2388 8022；(852) 2388 0006；（852）2388 2033</p>
                        <p>邮箱: <a href="mailto:wangkun6536@163.com">wangkun6536@163.com </a></p>
                        <p>电话: +5289 568 407</p>
                    </div>
                </div>
                <div class="col-md-6 message-right">
                    <form>
                        <input type="text" value="名称" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '名称';}"/>
                        <input type="text" class="mar-last" value="邮件" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = '邮件';}"/>
                        <textarea onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '邮件内容';}"/>邮件内容</textarea>
                        <a href="mailto:wangkun6536@163.com"><input type="button" value="发送"/></a>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="map">

            </div>
            <div class="clearfix"></div>
        </div>


        <div class="our-team">
            <h3>我们的团队</h3>
            <div class="col-md-3 team-grid">
                <a href="/HituServer/resources/about/images/b-t1.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                    <img src="/HituServer/resources/about/images/t1.jpg"/>
                    <div class="b-wrapper">
                    </div>
                </a>
                <div class="team-details">
                    <h4>McClintock</h4>
                    <p>Co-founder& CEO</p>
                </div>
            </div>
            <div class="col-md-3 team-grid ma-more">
                <a href="/HituServer/resources/about/images/b-t2.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                    <img src="/HituServer/resources/about/images/t2.jpg"/>
                    <div class="b-wrapper">
                    </div>
                </a>
                <div class="team-details">
                    <h4>Malorum</h4>
                    <p>Co-founder</p>
                </div>
            </div>
            <div class="col-md-3 team-grid">
                <a href="/HituServer/resources/about/images/b-t3.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                    <img src="/HituServer/resources/about/images/t3.jpg"/>
                    <div class="b-wrapper">
                    </div>
                </a>
                <div class="team-details">
                    <h4>Richard</h4>
                    <p>Head Of Sale</p>
                </div>
            </div>
            <div class="col-md-3 team-grid mar-more">
                <a href="/HituServer/resources/about/images/b-t4.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                    <img src="/HituServer/resources/about/images/t4.jpg"/>
                    <div class="b-wrapper">
                    </div>
                </a>
                <div class="team-details">
                    <h4>Bonorum</h4>
                    <p>Operator</p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

    </div>
</div>
<!--message end here-->

<jsp:include page="/views/footer.jsp"/>
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.swipebox.min.js"></script>

<script>
    window.onload = function () {
        $("#contact_li").addClass('active');
    }
    $.backstretch("images/banner.jpg");
    jQuery(function ($) {
        $(".swipebox").swipebox();
    });

</script>
</body>
</html>