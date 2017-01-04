<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Explore</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/HituServer/resources/common/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/swipebox.css">
    <!-- Custom Theme files -->
    <meta name="keywords"
          content="Trip Way Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndriodCompatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>

</head>
<body>
<jsp:include page="/views/header.jsp"/>

<script type="text/javascript">
    jQuery(function ($) {
        $(".swipebox").swipebox();
    });
</script>
<div class="about">
    <div class="container">
        <div class="about-main">
            <div class="about-top">
                <h3>About</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
                    et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                    aliquip ex ea commodo consequat.Duis aute irure dolor.</p>
            </div>
            <div class="about-bottom">
                <div class="col-md-4 about-left">
                    <img src="images/ab.jpg" alt="" title="">
                </div>
                <div class="col-md-8 about-right">
                    <h4>On the other hand, we denounce with righteous indignation</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                        voluptate velit esse cillum dolore eu fugiat nulla pariatur There are many variations of
                        passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by
                        injected humour, or randomised words which don't look even slightly believable.sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Duis aute irure dolorNemo
                        enim ipsam voluptatem quia voluptas sit aspernatur aut odit.</p>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="our-team">
                <h3>Our Team</h3>
                <div class="col-md-3 team-grid">
                    <a href="images/b-t1.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                        <img src="images/t1.jpg"/>
                        <div class="b-wrapper">
                        </div>
                    </a>
                    <div class="team-details">
                        <h4>McClintock</h4>
                        <p>Co-founder& CEO</p>
                    </div>
                </div>
                <div class="col-md-3 team-grid ma-more">
                    <a href="images/b-t2.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                        <img src="images/t2.jpg"/>
                        <div class="b-wrapper">
                        </div>
                    </a>
                    <div class="team-details">
                        <h4>Malorum</h4>
                        <p>Co-founder</p>
                    </div>
                </div>
                <div class="col-md-3 team-grid">
                    <a href="images/b-t3.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                        <img src="images/t3.jpg"/>
                        <div class="b-wrapper">
                        </div>
                    </a>
                    <div class="team-details">
                        <h4>Richard</h4>
                        <p>Head Of Sale</p>
                    </div>
                </div>
                <div class="col-md-3 team-grid mar-more">
                    <a href="images/b-t4.jpg" class="b-link-stripe b-animate-go  swipebox" title="天一阁">
                        <img src="images/t4.jpg"/>
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
</div>
<!--friend end here-->

<jsp:include page="/views/footer.jsp"/>
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="js/jquery.swipebox.min.js"></script>
</body>
</html>
