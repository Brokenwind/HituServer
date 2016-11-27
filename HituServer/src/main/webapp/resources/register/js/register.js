jQuery(document).ready(function() {
	$.backstretch("/HituServer/resources/register/images/background.jpg");

	$('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch("resize");
    });
    $('#top-navbar-1').on('hidden.bs.collapse', function(){
    	$.backstretch("resize");
    });
    
    /*
        Form
    */
    $('fieldset:first-child').fadeIn('slow');
    
    $('input[type="text"], .registration-form input[type="password"], .registration-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    // next step
    $('.btn-next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    // previous step
    $('.btn-previous').on('click', function() {
    	$(this).parents('fieldset').fadeOut(400, function() {
    		$(this).prev().fadeIn();
    	});
    });
    
    // submit
    $('.registration-form').on('submit', function(e) {
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });

	$('#form-birthday').datepicker({});

	$("#form-birthday").datepicker({
		format:"yyyy-mm-dd"
	});

	//调用ajax 异步查询是否有同名的注册者
	$("#form-name").blur(function(){
		var username = $("#form-name").val();
		//取Ajax返回结果
		//为了简单，这里简单地从文件中读取内容作为返回数据
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			url:"/HituServer/user/isExist",
			async:true,
			type:"post",
			data: {"name": username},
			dataType: "text",
			error: function(){ //失败
				alert(username);
			},
			success:function(msg){
				if ( msg == "true"){
					alert("the user exists!");
					$("#form-name").addClass('input-error');
				}
			}
		});
	});
});
