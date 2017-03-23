<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forms</title>

<link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/views/popwindow.jsp"/>
	<div class="row" style="margin-top: 10%">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">密码重置</div>
				<div class="panel-body">
					<div role="form">
						<fieldset>
							<div hidden="hidden">
								<input class="form-control" placeholder="type" name="type" value="0" type="text">
								<input class="form-control" placeholder="type" name="nickname" value="${nickname}" type="text">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="密码" name="password" type="password" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="再次输入密码" name="repassword" type="password">
							</div>
							<button id="btn-commit" class="btn btn-primary">确定</button>
						</fieldset>
					</div>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->
	<script src="/HituServer/resources/common/js/jquery.min.js"></script>
	<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
	<script src="/HituServer/resources/reset/js/reset.js"></script>
</body>

</html>
