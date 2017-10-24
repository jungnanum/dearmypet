<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<script type="text/javascript" src = "${initParam.rootPath}/js/jquery.js"></script>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Dear My Pet - for lost animal">
	<meta name="author" content="Dear My Pet Team">
	<meta name="keywords" content="dear my pet, lost animal, lost, animal, cat, dog, kitten, kitty, doggy">
	
	<meta property="og:type" content="website" />
	<meta property="og:site_name" content="Dear My Pet" />
	<meta property="og:url" content="https://${initParam.devOrRelease}.dearmypet.net/?${url}" />
	
	<link rel="apple-touch-icon" sizes="57x57" href="${initParam.rootPath}/images/favicons/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="${initParam.rootPath}/images/favicons/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="${initParam.rootPath}/images/favicons/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="${initParam.rootPath}/images/favicons/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="${initParam.rootPath}/images/favicons/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="${initParam.rootPath}/images/favicons/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="${initParam.rootPath}/images/favicons/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="${initParam.rootPath}/images/favicons/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="${initParam.rootPath}/images/favicons/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="${initParam.rootPath}/images/favicons/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="${initParam.rootPath}/images/favicons/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${initParam.rootPath}/images/favicons/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${initParam.rootPath}/images/favicons/favicon-16x16.png">
	<link rel="shortcut icon" type="image/x-icon" href="${initParam.rootPath}/favicon.ico" />
	<link rel="manifest" href="${initParam.rootPath}/images/favicons/manifest.json">
	<meta name="msapplication-TileColor" content="#fff">
	<meta name="msapplication-TileImage" content="${initParam.rootPath}/images/favicons/ms-icon-144x144.png">
	<meta name="theme-color" content="#fff">
	
	<title>Home | Dear My Pet</title>


	
<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
<script src="${initParam.rootPath}/js/html5shiv.js"></script>
<script src="${initParam.rootPath}/js/respond.min.js"></script>
<![endif]-->
<!-- Web Fonts -->
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin">
<!-- CSS Global Compulsory -->
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/css/style.css">
<!-- CSS Header and Footer -->
<link rel="stylesheet" href="${initParam.rootPath}/assets/css/headers/header-default.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/css/footers/footer-v1.css">
<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/animate.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
<link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">

<%-- <link rel="stylesheet" href="${initParam.rootPath}/assets/css/form.css"> --%>

<!-- 페이지별 불러오는 CSS들 -->
<%
	if(!request.getAttribute("javax.servlet.forward.request_uri").equals("/LoginAllList.dmp")){
%>
	<tiles:insertAttribute name = "css"/>
<%
	}
%>

<!-- 종료 -->
	
<!--[if lt IE 9]><link rel="stylesheet" href="${initParam.rootPath}/assets/plugins/sky-forms-pro/skyforms/css/sky-forms-ie8.css"><![endif]-->
<!-- CSS Customization -->
<link rel="stylesheet" href="${initParam.rootPath}/assets/css/custom.css">

</head>
<body>

<script>
window.fbAsyncInit = function() {
	FB.init({
		appId            : '136947376934480',
		autoLogAppEvents : true,
		xfbml            : true,
		version          : 'v2.10'
	});
	FB.AppEvents.logPageView();
};

(function(d, s, id){
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement(s); js.id = id;
	js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.10&appId=136947376934480";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

/* FB.getLoginStatus(function(response) {
	statusChangeCallback(response);
});
 */
function fbLogin() {
	// 로그인 여부 체크
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			FB.api('/me', { locale: 'en_US', fields: 'name, age_range, email,birthday,gender' }, function(res) {
				console.log("로그인 결과 - all : " + response);
				console.log("로그인 결과 - response.status : " + response.status);
				console.log("로그인 결과 - response.email : " + response.email);
				console.log("로그인 결과 - response.name : " + response.name);
				console.log("로그인 결과 - response.age_range : " + response.age_range);
				console.log("로그인 결과 - response.birthday : " + response.birthday);
				console.log("로그인 결과 - response.gender : " + response.gender);
				console.log("로그인 결과 - response.authResponse : " + response.authResponse);
				console.log("로그인 결과 - response.authResponse.accessToken : " + response.authResponse.accessToken);
				console.log("로그인 결과 - response.authResponse.expiresIn : " + response.authResponse.expiresIn);
				console.log("로그인 결과 - response.authResponse.signedRequest : " + response.authResponse.signedRequest);
				console.log("로그인 결과 - response.authResponse.userID : " + response.authResponse.userID);
			 });
			/* FB.api('/me', function(res) {
				console.log("로그인 결과 - all : " + response);
				console.log("로그인 결과 - response.status : " + response.status);
//				console.log("로그인 결과 - response.email : " + response.email);
//				console.log("로그인 결과 - response.name : " + response.name);
				console.log("로그인 결과 - response.authResponse : " + response.authResponse);
				console.log("로그인 결과 - response.authResponse.accessToken : " + response.authResponse.accessToken);
				console.log("로그인 결과 - response.authResponse.expiresIn : " + response.authResponse.expiresIn);
				console.log("로그인 결과 - response.authResponse.signedRequest : " + response.authResponse.signedRequest);
				console.log("로그인 결과 - response.authResponse.userID : " + response.authResponse.userID);
			}); */
		} else if (response.status === 'not_authorized') {
			alert('페이스북에 로그인을 하셨지요? 그렇다면 저희 앱을 인증해주셔야 이용이 가능합니다.');
		} else {
			alert('페이스북에 로그인을 안하셨습니다.');
		}
	}, true);
}

</script>
<!-- <div id="fb-root"></div> -->
<div class="fb-login-button" scope="public_profile,email" data-max-rows="1" data-size="large" data-button-type="continue_with" data-show-faces="true" data-auto-logout-link="true" data-use-continue-as="true" onlogin="fbLogin();" ></div>
<!-- <div class="fb-login-button" data-width="327.328" data-max-rows="1" data-size="medium" data-button-type="continue_with" data-show-faces="false" data-auto-logout-link="false" data-use-continue-as="false" onlogin="fbLogin();"></div> -->

	<tiles:insertAttribute name ="header"/>

	<!-- container -->
	<div class="wrapper main-body-content">
		<tiles:insertAttribute name = "body"/>
	</div>
	<!--// container -->
	
	<!-- footer -->
	<tiles:insertAttribute name = "footer"/>
	<!--// footer -->
	
	<!-- js -->
	<%
	if(!request.getAttribute("javax.servlet.forward.request_uri").equals("/LoginAllList.dmp")){
	%>
		<tiles:insertAttribute name = "js"/>
	<%
		}
	%>
	<!--// js -->
	
	
</body>
</html>