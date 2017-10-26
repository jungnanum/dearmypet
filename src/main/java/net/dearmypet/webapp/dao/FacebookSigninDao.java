package net.dearmypet.webapp.dao;

import net.dearmypet.webapp.vo.FacebookSigninVO;

public interface FacebookSigninDao {
	/**
	 * 페이스북 사용자 중복체크용 사용자 정보 가져오기
	 * @param String - 페이스북 사용자 정보조회를 위한 ID
	 * @return facebookSigninVO : FacebookSigninVO - 페이스북 사용자 VO
	 */
	public FacebookSigninVO selectFBId(String facebookUserId);
	
	/**
	 * 신규 페이스북 사용자 정보를 페이스북 회원 테이블에 추가
	 * @param facebookSigninVO : FacebookSigninVO - 페이스북 사용자 정보조회를 위한 VO
	 * @return int - insert 성공여부
	 */
	public int insertNewFacebookUser(FacebookSigninVO facebookSigninVO);
	
	/**
	 * facebook 사용자ID를 기준으로 FacebookSigninVO를 가져온다.
	 * @param lgFbId:String - facebook 사용자ID
	 * @return FacebookSigninVO
	 */
	public FacebookSigninVO selectLgFbVoById(String lgFbId);
}
