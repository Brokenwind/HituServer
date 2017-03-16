<%--
  Created by IntelliJ IDEA.
  User: amei
  Date: 17-3-8
  Time: 下午7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/HituServer/resources/modal/css/component.css"  rel="stylesheet" type="text/css" />
</head>
<body>

<div class="md-modal md-effect-11" id="plan-pop-modal">
    <div class="md-content">
        <h3 class="pop-modal-title"></h3>
        <div>
            <p class="pop-modal-content" align="center"></p>
            <button class="md-close">关闭!</button>
        </div>
    </div>
</div>

<button hidden="hidden" id="btn-trigger-pop" class="md-trigger" data-modal="plan-pop-modal">Fade in &amp; Scale</button>

<script src="/HituServer/resources/modal/js/modernizr.custom.js"></script>
<script src="/HituServer/resources/modal/js/classie.js"></script>
<script src="/HituServer/resources/modal/js/modalEffects.js"></script>
<script src="/HituServer/resources/modal/js/cssParser.js"></script>

</body>
</html>
