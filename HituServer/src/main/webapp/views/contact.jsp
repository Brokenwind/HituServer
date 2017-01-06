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
                        <h3>Information of contact</h3>
                        <p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain
                            was born and I will give you a complete account of the system, and expound the actual
                            teachings of the great explorer of the truth, the master-builder of human happiness.</p>
                    </div>
                    <div class="con-addr">
                        <h4>Address</h4>
                        <p>Address: Richard McClintock</p>
                        <p>New Street: Letraset sheets </p>
                        <p>mail : <a href="mailto:infoexample@email.com">info@travel.com </a></p>
                        <p>ph : +5289 568 407</p>
                    </div>
                </div>
                <div class="col-md-6 message-right">
                    <form>
                        <input type="text" value="Name" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'Name';}"/>
                        <input type="text" class="mar-last" value="Email" onfocus="this.value = '';"
                               onblur="if (this.value == '') {this.value = 'Email';}"/>
                        <textarea onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}"/>Message</textarea>
                        <input type="submit" value="Send"/>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d243647.25176871577!2d78.40804555!3d17.4123487!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb99daeaebd2c7%3A0xae93b78392bafbc2!2sHyderabad%2C+Telangana!5e0!3m2!1sen!2sin!4v1431417526242"></iframe>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--message end here-->

<jsp:include page="/views/footer.jsp"/>

<script>
    $.backstretch("images/banner.jpg");
</script>
</body>
</html>