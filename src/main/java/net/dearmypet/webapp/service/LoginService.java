package net.dearmypet.webapp.service;

import java.util.Map;

import net.dearmypet.webapp.vo.FacebookSigninVO;
import net.dearmypet.webapp.vo.LoginVO;

/**
 * login 테이블 처리 클래스
 * @author "Timothy Lee"
 *
 */
public interface LoginService {
	
	/**
	 * 모든 Login 레코드
	 * @return Map - 모든 Login 레코드가 들어있는 List
	 */
	public Map getLoginAllList() ;
	
	/**
	 * 페이스북 사용자 정보를 바탕으로 login테이블에 데이터를 insert
	 * @param facebookSigninVO:FacebookSigninVO - 페이스북 사용자 정보가 들어있는 VO
	 * @return int - 레코드 insert 결과
	 */
	public int insertLoginMemberFromFBUser(FacebookSigninVO facebookSigninVO);
	

	/**
	 * 일반 회원 로그인 처리
	 * @param strEmail:String - 이메일주소
	 * @param strPassword:String - 비밀번호
	 * @return LoginVO - 로그인한 회원 정보VO
	 */
	LoginVO selectLoginByEmailAndPassword(String strEmail, String strPassword);
}
