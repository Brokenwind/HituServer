<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>详情</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
    <!-- Custom Theme files -->
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="/HituServer/resources/detail/css/detail.css" rel="stylesheet" type="text/css" media="all"/>
    <!--friend start here-->
    <link href="/HituServer/resources/common/css/swipebox.css" rel="stylesheet" type="text/css" media="all"/>

    <meta name="keywords" content="Trip Way web design"/>

</head>
<body>

<jsp:include page="/views/header.jsp"/>

<div class="friend">
    <div class="container">
        <div class="friend-main">
            <div class="friend-top">
                <h3>${scenery.name}</h3>
                <p>${scenery.description}</p>
            </div>
            <div class="friend-bottom">
                <c:forEach items="${pics}" var="pic">
                    <div class="col-md-4">
                        <a href="${pic.imageUrl}" class="b-link-stripe b-animate-go swipebox" title="${pic.imageName}">
                            <img src="${pic.imageUrl}" style="width:600px;height:450px;"/>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- end here-->

<jsp:include page="/views/footer.jsp"/>

<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/jquery.swipebox.min.js"></script>

<script type="text/javascript">
    $(document).ready(
            function () {
                $(".swipebox").swipebox();
            }
    )
</script>

</body>
</html>