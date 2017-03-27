<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forms</title>
	<link href="/HituServer/resources/common/css/bootstrap.css" rel="stylesheet">
	<link href="/HituServer/resources/login/css/forget.css" rel="stylesheet">
</head>

<body>

<jsp:include page="/views/popwindow.jsp"/>
	<div class="row" style="margin-top: 10%">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<div role="form">
						<fieldset>
							<div hidden="hidden">
							<input class="form-control" placeholder="type" name="type" value="0" type="text">
							</div>
							<div class="form-group">
								<input class="form-control" id="form-account" placeholder="用户名" name="account" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="密码" name="password" type="password">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">记住密码
								</label>
								<label>
									<button id="btn-forget" class="btn btn-primary" data-toggle="modal" data-target="#myModal">忘记密码
									</button>
								</label>
							</div>
							<button id="btn-login" class="btn btn-primary">登陆</button>
						</fieldset>
					</div>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="login">
						<h2>找回密码</h2>
						<div class="login-top">
							<h1>请输入用户名</h1>
							<form>
								<input type="text" name="nickname" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
							</form>
							<div class="forgot">
								<input id="btn-send-mail" type="submit" value="确定" data-dismiss="modal">
							</div>
						</div>
						<div class="login-bottom">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/HituServer/resources/common/js/jquery.min.js"></script>
	<script src="/HituServer/resources/common/js/bootstrap.min.js"></script>
	<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
	<script src="/HituServer/resources/login/js/login.js"></script>
</body>

</html>
