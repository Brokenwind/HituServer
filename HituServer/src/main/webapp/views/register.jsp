<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hitu Loing</title>
<!-- CSS -->
<link rel="stylesheet" href="/HituServer/resources/common/css/bootstrap.css">
<link rel="stylesheet" href="/HituServer/resources/css/form-elements.css">
<link rel="stylesheet" href="/HituServer/resources/register/css/register.css">
<link rel="stylesheet" href="/HituServer/resources/common/css/datepicker3.css">
</head>
<body>
<!-- Top content -->
<div class="top-content">
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<h1><strong>Hitu</strong>行程伊始</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3 form-box">
					<form role="form" action="/HituServer/user/register" method="post" class="registration-form">
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 1 / 3</h3>
									<p>你是谁:</p>
								</div>
								<div class="form-top-right"> <i class="fa fa-user"></i> </div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="sr-only" for="form-name">name</label>
									<input type="text" name="nickname" placeholder="姓名..." class="form-name form-control" id="form-name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-sex">sex</label>
									<select class="combobox  form-control" name="sex" id="form-sex">
										<option value="male">男</option>
										<option value="female">女</option>
										<option value="else">其它</option>
									</select>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-about-yourself">About yourself</label>
									<textarea name="description" placeholder="关于自己..."
											  class="form-about-yourself form-control" id="form-about-yourself"></textarea>
								</div>
								<button type="button" class="btn btn-next">下一步</button>
							</div>
						</fieldset>
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 2 / 3</h3>
									<p>你的账户:</p>
								</div>
								<div class="form-top-right"> <i class="fa fa-key"></i> </div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="sr-only" for="form-phone">phone</label>
									<input type="text" name="phone" placeholder="电话号码..." class="form-phone form-control" id="form-phone">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label>
									<input type="password" name="password" placeholder="密码..." class="form-password form-control" id="form-password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-repeat-password">Repeat password</label>
									<input type="password"  placeholder="确认密码..."
										   class="form-repeat-password form-control" id="form-repeat-password">
								</div>
								<button type="button" class="btn btn-previous">前一步</button>
								<button type="button" class="btn btn-next">下一步</button>
							</div>
						</fieldset>
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>Step 3 / 3</h3>
									<p>其它信息:</p>
								</div>
								<div class="form-top-right"> <i class="fa fa-twitter"></i> </div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="sr-only" for="form-facebook">Email</label>
									<input type="text" name="email" placeholder="邮箱..." class="form-email form-control" id="form-facebook">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-address">address</label>
									<input type="text" name="address" placeholder="住址..." class="form-address form-control" id="form-address">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-birthday">birthday</label>
									<input type="text" name="birthday-drop" placeholder="出生日期..." class="form-birthday form-control" id="form-birthday">
								</div>
								<button type="button" class="btn btn-previous">前一步</button>
								<button type="submit" class="btn">提交</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Javascript -->
<script src="/HituServer/resources/common/js/jquery.min.js"></script>
<script src="/HituServer/resources/common/js/bootstrap.js"></script>
<script src="/HituServer/resources/common/js/jquery.backstretch.js"></script>
<script src="/HituServer/resources/common/js/bootstrap-datepicker.js"></script>
<script src="/HituServer/resources/register/js/register.js"></script>

</body>
</html>
