package net.dearmypet.webapp.dao;

import java.util.List;

import net.dearmypet.webapp.vo.LoginVO;

public interface LoginDao {
	// insert / update / delete의 return 타입은 int로 지정해주세요
	
	/**
	 * 전체 회원 조회
	 * @return List<LoginVO> - 전체 회원 VO가 들어가 있는 List반환
	 */
	List<LoginVO> selectAllLogin(); 
	
	/**
	 * 회원 가입 - login테이블에 데이터 추가
	 * @param loginVO : LoginVO - 회원가입에 사용할 VO
	 * @return int - 회원가입 insert결과
	 */
	int insertLoginVO(LoginVO loginVO);
}
