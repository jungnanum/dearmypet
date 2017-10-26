<%@page import="java.nio.charset.CodingErrorAction"%>
<%@page import="org.apache.catalina.util.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- footer start -->
	<div class="wrapper main-footer">
		<footer>
			<address>주소</address>
			<p>copyright</p>
			<p id="BtnShareSocialNetwork">소셜공유 : <button class="btn-u btn-u-dark-blue btn-block" id="btnFbShare">Facebook</button> &nbsp; <button class="btn-u btn-u-blue btn-block" id="btnTwShare">Twitter</button> &nbsp; <button class="btn-u btn-u-red btn-block" id="btnGpShare">Google+</button></p>
		</footer>
	</div>
<!-- footer end-->

	<!-- 각 페이지별 js 통합내용 -->
	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="${initParam.rootPath}/assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${initParam.rootPath}/assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript" src="${initParam.rootPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="${initParam.rootPath}/assets/plugins/back-to-top.js"></script>
	<script type="text/javascript" src="${initParam.rootPath}/assets/plugins/smoothScroll.js"></script>
	
	<!-- JS Customization -->
	<script type="text/javascript" src="${initParam.rootPath}/assets/js/custom.js"></script>
	<!-- JS Page Level -->
	<script type="text/javascript" src="${initParam.rootPath}/assets/js/app.js"></script>

<%
String strUrl = (String)request.getAttribute("url");
if(strUrl == null) strUrl = "";
String strCurrentUrl = request.getScheme() + "://dev.dearmypet.net" + strUrl;
%>
	
	
	<script>
	// 소셜 네트워크 공유
	var orginUrl = "<%=strCurrentUrl%>";
	var encodeUrl = encodeURIComponent(orginUrl);
	
	var snsShare = {
			shareFb : function(){ //페이스북
				window.open("http://www.facebook.com/sharer/sharer.php?u="+encodeUrl, 'shareOn2', "width=600, height=500, scrollbars=no");
			},
			shareTw : function(){ // 트위터
				//https://twitter.com/intent/tweet?text=TEXT&url=PAGE_URL
				window.open("https://twitter.com/intent/tweet?text=dearmypet.net&url=<%=strCurrentUrl%>", "_blank","toolbar=0,status=0,width=626,height=436");
			},
			shareGp : function(){ // 구글 플러스
				window.open("https://plus.google.com/share?url=<%=strCurrentUrl%>", "sharer","toolbar=0,status=0,width=626,height=436");
			}				
		};
	
	jQuery("#BtnShareSocialNetwork").on("click", function(){
		
	}).on("click", "#btnFbShare", function(){
		snsShare.shareFb();
	}).on("click", "#btnTwShare", function(){
		snsShare.shareTw();
	}).on("click", "#btnGpShare", function(){
		snsShare.shareGp();
	});
	</script>
	
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '{your-app-id}',
			cookie : true,
			xfbml : true,
			version : '{latest-api-version}'
		});
		FB.AppEvents.logPageView();
	};
	(function(d, s, id){
		 var js, fjs = d.getElementsByTagName(s)[0];
		 if (d.getElementById(id)) {return;}
		 js = d.createElement(s); js.id = id;
		 js.src = "//connect.facebook.net/en_US/sdk.js";
		 fjs.parentNode.insertBefore(js, fjs);
	 }(document, 'script', 'facebook-jssdk'));
	
	// 로그인 상태를 확인
	function checkLoginState() {
		FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});
	}
</script>
<script>

jQuery(function(){
<% // 로그인 여부에 따라 버튼 show/hide 초기화
	if( ( (String)session.getAttribute("isLogined") ) == "true" ) { %>
	jQuery("#nav-login-button").hide();
	jQuery("#nav-memberJoin-button").hide();
	jQuery("#nav-logout-button").show();
<% } else { %>
	jQuery("#nav-logout-button").hide();
	jQuery("#nav-memberJoin-button").show();
	jQuery("#nav-login-button").show();
<% } %>

});
</script>