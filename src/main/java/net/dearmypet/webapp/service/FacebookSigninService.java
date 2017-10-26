package net.dearmypet.webapp.service;

import net.dearmypet.webapp.vo.FacebookSigninVO;

/**
 * 페이스북 사용자 처리 서비스 클래스
 * @author "Timothy Lee"
 *
 */
public interface FacebookSigninService {
	
	/**
	 * 페이스북 사용자 가입/로그인 처리를 위해 페북에서 전달받은 정보를 처리
	 * @param facebookSigninVO : FacebookSigninVO - 페이스북 사용자 정보조회를 위한 VO
	 * @return String - 최종 JSON 처리에 전달할 처리결과 메시지 문자열
	 */
	public String signinFBUser(FacebookSigninVO facebookSigninVO);
	
	
}
