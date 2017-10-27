/* Write here your custom javascript codes */
$( ".navbar-toggle" ).click(function() {
	  if ( $( ".nav-hidden" ).is( ":hidden" ) ) {
	    $( ".nav-hidden" ).slideDown();
	  } else {
	    $( ".nav-hidden" ).slideUp();
	  }
});
/* 로그인 버튼 로그아웃 버튼 처리 */
$( "#modal-login-button" ).click(function() {
	
	var formData = $("#sky-form1").serialize();
	
	$.ajax({
		type: "POST",
		url: "/login.jsn",
		/*contentType : 'application/json; charset=utf-8',*/
		/*
		data: {
//			lg_password : jQuery("#sky-form1").find("input[name='lg_password']").val(),
//			lg_email : jQuery("#sky-form1").find("input[name='lg_email']").val()
//			lg_password : "asdf@asdf",
//			lg_email : "0000"
		},
		*/
		data : JSON.stringify(formData),
//		data : formData,
		contentType: "application/json",
		success: function(res){
			console.log(res);
			if(res.result == "success"){// 로그인 성공
				$("#nav-login-button").hide();
				$("#nav-logout-button").show();
				jQuery("#nav-memberJoin-button").hide();
				location.reload();
				jQuery("#login_modal").hide();
			} else if(res.result = "requiredFields"){// 로그인에 필요한 데이터를 전달받지 못함
				alert("이메일, 비밀번호를 확인해주세요!");
				return false;
			} else if(res.result = "socialUser"){// 소셜 네트워크 회원 가입자
				alert("SNS가입회원입니다.\n해당 소셜 네트워크 서비스를 이용해서 로그인해주세요!");
				return false;
			} else {
				alert("이메일, 비밀번호를 다시한번 더 확인해주세요!");
				return false;
			}
			
		},
		error: function(res){
			console.log(res);
		},
		dataType: 'json'
	});
});
$( "#nav-logout-button" ).click(function() {
	
	$.ajax({
		type: "GET",
		url: "/logout.jsn",
		data: {
		},
		success: function(res){
			console.log(res);
			if(res.result == "success"){ // 세션삭제됨
				jQuery("#nav-logout-button").hide();
				jQuery("#nav-login-button").show();
				jQuery("#nav-memberJoin-button").show();
				facebookLogout();
			}
			
		},
		error: function(res){
			console.log(res);
		},
		dataType: 'json'
	});
});