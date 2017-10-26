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
	$('#nav-login-button').hide();
	$('#nav-logout-button').show();
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
				jQuery('#nav-logout-button').hide();
				jQuery('#nav-login-button').show();
				jQuery('#nav-memberJoin-button').show();
				facebookLogout();
			}
			
		},
		error: function(res){
			console.log(res);
		},
		dataType: 'json'
	});
});