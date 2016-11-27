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
	<div class="row" style="margin-top: 10%">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form role="form" action="/HituServer/user/signin" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="用户名" name="name" type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="密码" name="password" type="password">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							</div>
							<button type="submit" class="btn btn-primary">登陆</button>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->
	<script src="/HituServer/resources/common/js/jquery.min.js"></script>
	<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
	<script src="/HituServer/resources/login/js/login.js"></script>
</body>

</html>
