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
	
	<button type="button" onclick="facebooklogin();">facebook 로그인</button>
	<button type="button" onclick="FB.logout(function(response) {});">facebook 로그아웃</button>
 
<script>
window.fbAsyncInit = function() {  
 FB.init({appId: '143878959678270', status: true, 
		autoLogAppEvents : true,
		version          : 'v2.10', cookie: true,xfbml: true});
// 페이스북 logout시 새로고침
 FB.Event.subscribe('auth.logout', function(response) {
	    document.location.reload();
	}); 
};
 
(function(d){  
 var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];  
 if (d.getElementById(id)) {return;}  
 js = d.createElement('script'); js.id = id; js.async = true;  
 js.src = "//connect.facebook.net/ko_KR/sdk.js";  
 ref.parentNode.insertBefore(js, ref);  
}(document)); 
 
function facebooklogin() {  
 FB.login(function(response) {
   if (response.status === 'connected') {
  getMyProfile();
   } else if (response.status === 'not_authorized') {
		alert('페이스북에 로그인을 하셨지요? 그렇다면 저희 앱을 인증해주셔야 이용이 가능합니다.');
   } else {
		alert('페이스북에 로그인을 안하셨습니다.');
   }
// } , {scope: "user_about_me,email,user_birthday,public_profile"} );
 } , {scope: "email,public_profile"} );
 
} 
 
function getMyProfile(){
 FB.api('/me',{fields: 'email,public_profile'}, function(user){
 
 var myName= user.name ;
 var myEmail = user.email;
 var myId = user.id;
 
 console.dir(user);
 console.log("user.name", user.name);
 console.log("user.email", user.email);
 console.log("user.id", user.id);
 console.log("user.cover", user.cover);
 console.log("user.age_range", user.age_range);
 console.log("user.link", user.link);
 console.log("user.gender", user.gender);
 console.log("user.locale", user.locale);
 console.log("user.picture", user.picture);
 console.log("user.timezone", user.timezone);
 console.log("user.updated_time", user.updated_time);
 console.log("user.verified", user.verified);
 
 if(myEmail != ""){
   //정보를 post로 보내고 submit처리
 }
 
  });
 FB.api('/me/picture?type=large',function(data){
 var myImg = data.data.url;
 });
}
</script>

</body>
</html>