<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--header start-->
	<div class="wrapper main-header">
		<div class="container">
			<!-- 로그인을 위한 부분 -->
			<div class="row login-header">
				<div class="col-md-9">
					<div class="row">
						<div class="col-md-2">
							<a href="/main.dmp">
								<div class="logo_image">
									<!-- 글써지는 애니메이션 -->
									<div class="drawsvg">
										<svg version="1.1" viewBox="0 -40 580 150">
											<symbol id="fade-text">
												<text x="45%" y="40%" text-anchor="middle">Dear My Pet</text>
												<!--<text x="55%" y="70%" text-anchor="middle"></text> -->
											</symbol>
											<g>
												<use class="stroke" xlink:href="#fade-text"/>
												<use class="fill" xlink:href="#fade-text"/>
											</g>
										</svg>
									</div>
								</div>
							</a>
						</div>
						<div class="col-md-10">
						&nbsp;
						</div>
					</div>
				</div>
				<div class="col-md-3 nav-hidden">
					<div id="gnbBtnMemberControll">
						<button class="btn-u login_btn" id="nav-logout-button">로그아웃</button>
						<button class="btn-u login_btn" data-toggle="modal" data-target="#login_modal" id="nav-login-button">로그인</button><!-- 모달 부르는 버튼 -->
						<button class="btn-u login_btn" data-toggle="modal" data-target="#sign_up_modal" id="nav-memberJoin-button">회원가입</button>
					</div>
				</div>
			</div>
			<!-- 로그인헤더 종료 -->
		</div>
	</div>
	<div class="wrapper main-body-nav">
		<div class="header">
			<div class="container">
				<!-- Toggle get grouped for better mobile display -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="fa fa-bars"></span>
				</button>
				<!-- End Toggle -->
			</div><!--/end container-->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
				<div class="container">
					<ul class="nav navbar-nav">
						<!-- Home -->
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								Home
							</a>
							<ul class="dropdown-menu">
								<li><a href="/main_Sign_Up.dmp">회원가입</a></li>
	
								<!-- One Page -->
								<li class="dropdown-submenu">
									<a href="javascript:void(0);">내용2(드랍다운)</a>
									<ul class="dropdown-menu">
										<li><a target="_blank" href="main.dmp">내용2-1</a></li>
										<li><a target="_blank" href="One-Page/dark-page-example.html">내용2-2</a></li>
									</ul>
								</li>
								<!-- End One Page -->
							</ul>
						</li>
						<!-- End Home -->
	
						<!-- About us -->
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								정보페이지
							</a>
							<ul class="dropdown-menu">
							<li><a href="/main_know.dmp">동물정보</a></li>
	
							<!-- One Page -->
							<li class="dropdown-submenu">
								<a href="javascript:void(0);">내용2(드랍다운)</a>
									<ul class="dropdown-menu">
										<li><a target="_blank" href="One-Page/index.html">내용2-1</a></li>
										<li><a target="_blank" href="One-Page/dark-page-example.html">내용2-2</a></li>
									</ul>
								</li>
							<!-- End One Page -->
							</ul>
						</li>
						<!-- End About us -->
	
						<!-- About us -->
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								공지사항
							</a>
							<ul class="dropdown-menu">
								<li><a href="/main_notice.dmp">공지사항</a></li>
	
								<!-- One Page -->
								<li class="dropdown-submenu">
									<a href="javascript:void(0);">내용2(드랍다운)</a>
									<ul class="dropdown-menu">
										<li><a target="_blank" href="One-Page/index.html">내용2-1</a></li>
										<li><a target="_blank" href="One-Page/dark-page-example.html">내용2-2</a></li>
									</ul>
								</li>
								<!-- End One Page -->
							</ul>
						</li>
						<!-- End About us -->
	
						<!-- About us -->
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								회사소개
							</a>
							<ul class="dropdown-menu">
								<li><a href="/main_about.dmp">회사소개</a></li>
	
								<!-- One Page -->
								<li class="dropdown-submenu">
									<a href="javascript:void(0);">내용2(드랍다운)</a>
									<ul class="dropdown-menu">
										<li><a target="_blank" href="One-Page/index.html">내용2-1</a></li>
										<li><a target="_blank" href="One-Page/dark-page-example.html">내용2-2</a></li>
									</ul>
								</li>
								<!-- End One Page -->
							</ul>
						</li>
						<!-- End About us -->
	
						<!-- About us -->
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								게시판들
							</a>
							<ul class="dropdown-menu">
								<li><a href="/board/board.dmp">기본게시판</a></li>
								<li><a href="/board/protect.dmp">임시보호게시판</a></li>
								<li><a href="/board/protect_form.dmp">임시보호 폼</a></li>
								<li><a href="/board/missing.dmp">실종게시판</a></li>

								<!-- One Page -->
								<li class="dropdown-submenu">
									<a href="javascript:void(0);">내용2(드랍다운)</a>
									<ul class="dropdown-menu">
										<li><a target="_blank" href="One-Page/index.html">내용2-1</a></li>
										<li><a target="_blank" href="One-Page/dark-page-example.html">내용2-2</a></li>
									</ul>
								</li>
								<!-- End One Page -->
							</ul>
						</li>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								진환씨
							</a>
							<ul class="dropdown-menu">
								<li><a href="/dmp_board.dmp">관리자 게시판</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								금호씨<!-- 금호씨 자료들 -->
							</a>
							<ul class="dropdown-menu">
								<li><a href="/main_survey.dmp">설문지작성</a></li>
								<li><a href="/main_addNotice.dmp">상세가입</a></li>
								<li><a href="/main_report.dmp">리포트</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
								팀장님
							</a>
							<ul class="dropdown-menu">
								<li><a href="/board/board.dmp">관리자 게시판</a></li>
							</ul>
						</li>
						<!-- End About us -->
	
						<!-- Search Block -->
						<li>
							<i class="search fa fa-search search-btn"></i>
							<div class="search-open">
								<div class="input-group animated fadeInDown">
									<input type="text" class="form-control" placeholder="Search">
									<span class="input-group-btn">
										<button class="btn-u" type="button">Go</button>
									</span>
								</div>
							</div>
						</li>
						<!-- End Search Block -->
					</ul>
				</div><!--/end container-->
			</div><!--/navbar-collapse-->
		</div>
   <!--=== End Header ===--> 
	</div>
<!--header end-->
<!-- 로그인 모달내용 부분 -->
<div class="modal fade" id="login_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel4" align="center">로그인</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<!-- Login-Form -->
					<div class="col-md-12">
						<form action="#" id="sky-form1" class="sky-form">
							<fieldset>
								<section>
									<div class="row">
										<label class="label col col-4">E-mail</label>
										<div class="col col-8">
											<label class="input">
												<i class="icon-append fa fa-user"></i>
												<input type="email" name="email">
											</label>
										</div>
									</div>
								</section>
								
								<section>
									<div class="row">
										<label class="label col col-4">Password</label>
										<div class="col col-8">
											<label class="input">
												<i class="icon-append fa fa-lock"></i>
												<input type="password" name="password">
											</label>
											<div class="note"><a href="#sky-form2" class="modal-opener" data-toggle="modal" data-target="#sky-form2">Forgot password?</a></div>
										</div>
									</div>
								</section>

								<section>
									<div class="row">
										<div class="col col-4"></div>
										<div class="col col-8">
											<label class="checkbox"><input type="checkbox" name="remember" checked><i></i>Keep me logged in</label>
										</div>
									</div>
								</section>
							</fieldset>
							<footer>
								<div class="row">
									<div class="col-xs-4">
										<button type="submit" class="btn-u btn-block" id="modal-login-button">로그인</button>
										<a href="#" class="btn-u btn-u-default btn-block">회원가입</a>
									</div>
									<div class="col-xs-8">
										<button class="btn-u btn-u-dark-blue btn-block" id="btnFacebookSignin">페이스북</button>
										<button class="btn-u btn-u-yellow btn-block">카카오톡</button>
									</div>
								</div>
							</footer>
						</form>
					</div>
					<!-- End Login-Form -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn-u btn-u-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 로그인 모달종료 -->

<div id="access_token"></div>
			<div id="user_id"></div>
			<div id="name"></div>
			<div id="email"></div>
			<div id="gender"></div>
			<div id="birthday"></div>
			<div id="id"></div>
			
	
	
	