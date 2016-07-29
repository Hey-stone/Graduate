$(function(){
	
	//登录
	$("#login").click(function() {
		
		var name = $("#name").val();
		var password = $("#password").val();
		if(name.trim() == ""){
			alert("请输入用户名！");
			return ;
		}
		if(password.trim() == ""){
			alert("请输入密码！");
			return ;
		}
		var user = {
				userName:name,
				password:password
		};
		$.ajax({
			url: 'login/login',
			type: 'POST',
			async: true,
			data: user,
			dataType: "json",
			success: function(data, textStatus){
				if(data.code == "0000"){
					window.location = "index";
				}else{
					alert(data.message)
				}
			},
			error: function(){
			}
		});
		
	});
	
	
	
});