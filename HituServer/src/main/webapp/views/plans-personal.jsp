<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的计划</title>
    <link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/time-selector/css/timepicki.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/plans/css/plans.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/common/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/HituServer/resources/common/css/popup-box.css" rel="stylesheet" type="text/css" media="all">
    <link href="/HituServer/resources/common/css/steps.css"  rel="stylesheet" type="text/css" />
</head>
<body>

<jsp:include page="/views/header.jsp"/>

<div class="checkout">
    <div class="container">
        <div class="col-md-9 product-price1">
            <!-- 步骤流程图 -->
            <ol class="ui-step ui-step-4">
                <li class="step-start step-active">
                    <div class="ui-step-line"></div>
                    <div class="ui-step-cont">
                        <span class="ui-step-cont-number">1</span>
                        <span class="ui-step-cont-text">创建计划</span>
                    </div>
                </li>
                <li>
                    <div class="ui-step-line"></div>
                    <div class="ui-step-cont">
                        <span class="ui-step-cont-number">2</span>
                        <span class="ui-step-cont-text">选择起点</span>
                    </div>
                </li>
                <li>
                    <div class="ui-step-line"></div>
                    <div class="ui-step-cont">
                        <span class="ui-step-cont-number">3</span>
                        <span class="ui-step-cont-text">选择景点</span>
                    </div>
                </li>
                <li class="step-end">
                    <div class="ui-step-line"></div>
                    <div class="ui-step-cont">
                        <span class="ui-step-cont-number">4</span>
                        <span class="ui-step-cont-text">选择终点</span>
                    </div>
                </li>
            </ol>

            <a id="btn_add_plan"  class="order thickbox play-icon popup-with-zoom-anim"  style="display: none">创建计划</a>
            <a id="btn_select_start" href="#frame-get-start" class="order thickbox play-icon popup-with-zoom-anim" style="display: none">选择起点</a>
            <a id="btn_select_medium"  class="order thickbox play-icon popup-with-zoom-anim" style="display: none">选择景点</a>
            <a id="btn_select_end" href="#frame-get-end" class="order thickbox play-icon popup-with-zoom-anim" style="display: none">选择终点</a>

            <div id="show_items" class="check-out">
                <div class="cart-items">
                    <h3>我的计划选项</h3>
                    <div class="in-check" >
                        <ul class="unit">
                            <li><span>景点概图</span></li>
                            <li><span>景点名</span></li>
                            <li><span>景区级别</span></li>
                            <li><span>景区价格</span></li>
                            <li><span>游玩时间</span></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <c:forEach items="${sceneries}" var="scenery">
                        <ul class="cart-header" id="point-row-1">
                            <div class="close1"> </div>
                            <li class="point-img"><a href="/HituServer/details?name=${scenery.name}" target="_blank"><img src="${scenery.symbolImage}" class="img-responsive" style="width:100px;height:100px;" alt=""></a>
                            </li>
                            <li class="point-name"><span>${scenery.name}</span></li>
                            <li class="point-level"><span>${scenery.level}</span></li>
                            <li class="point-price"><span>${scenery.price}</span></li>
                            <li class="point-time"> <a href="" class="add-cart cart-check" data-toggle="modal" data-target="#modal-hour-selector-modal">02:00</a></li>
                            <li class="point-lng" style="display: none">${scenery.longitude}</li>
                            <li class="point-lat" style="display: none">${scenery.latitude}</li>
                            <div class="clearfix"> </div>
                        </ul>
                        </c:forEach>
                        <a id="btn_delete_plan" class="order" target="_blank">删除计划</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 cart-total">
            <a id="btn_go_select" class="continue">继续选择</a>
            <div class="price-details">
                <h3>计划概况</h3>
                <span>景点个数</span>
                <span class="total">${fn:length(sceneries)}个</span>
                <span>门票总计</span>
                <c:if test="${fn:length(sceneries) != 0}">
                    <span class="total">143.00</span>
                </c:if>
                <c:if test="${fn:length(sceneries) == 0}">
                    <span class="total">0.0</span>
                </c:if>
                <span>打折</span>
                <span class="total">0.00</span>
                <div class="clearfix"></div>
            </div>
            <h4 class="last-price">总计</h4>
            <c:if test="${fn:length(sceneries) != 0}">
                <span class="total final">143.00</span>
            </c:if>
            <c:if test="${fn:length(sceneries) == 0}">
                <span class="total final">0.0</span>
            </c:if>

            <div class="clearfix"></div>
            <a id="btn_begin_plan" class="order">开始规划</a>
        </div>
    </div>
</div>
<!---->

<!-- 模态框（Modal） -->
<div class="modal fade" id="modal-hour-selector-modal" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <!-- &times;表示x号 -->
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">请选择游玩时长</h4>
            </div>
            <div class="modal-body">
                <div class="panel panel-red">
                    <div class="panel-heading dark-overlay">
                    </div>
                    <div class="panel-body ">
                        <!-- 这里为了居中时间选择器-->
                        <div class=" col-md-3"></div>
                        <div class="col-md-6 ">
                            <input type="text" hidden="hidden" name="row-id" id="modal-row-id"/>
                            <input type="text" name="time" id="modal-hour-selector"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" id="modal-hour-selector-commit-button" data-dismiss="modal">提交选择</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 弹出框显示的位置 -->
<div id="frame-get-start" class="mfp-div mfp-hide">
    <iframe id="start-frame" src="/HituServer/views/get-start.jsp" width="500" height="213" frameborder="0" webkitallowfullscreen
            mozallowfullscreen allowfullscreen></iframe>
</div>

<div id="frame-get-end" class="mfp-div mfp-hide">
    <iframe id="start-end" src="/HituServer/views/get-end.jsp" width="500" height="213" frameborder="0" webkitallowfullscreen
            mozallowfullscreen allowfullscreen></iframe>
</div>


<jsp:include page="/views/popwindow.jsp"/>
<jsp:include page="/views/footer.jsp"/>

<script src="/HituServer/resources/common/js/jquery.magnific-popup.js"></script>
<script src="/HituServer/resources/common/js/popup.js"></script>
<script src="/HituServer/resources/time-selector/js/timepicki.js"></script>
<script src="/HituServer/resources/plans/js/plan.js"></script>
<script>
    window.onload = function () {
        $("#plan_li").addClass('active');
    }
</script>
</body>
</html>

