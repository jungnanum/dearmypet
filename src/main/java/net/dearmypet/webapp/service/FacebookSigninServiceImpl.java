package net.dearmypet.webapp.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dearmypet.webapp.dao.FacebookSigninDao;
import net.dearmypet.webapp.vo.FacebookSigninVO;

@Service
public class FacebookSigninServiceImpl implements FacebookSigninService {
	
	@Autowired
	FacebookSigninDao facebookSigninDao;
/*	
	@Inject
	FacebookSigninVO facebookSigninVO;
*/
	@Override
	public String signinFBUser(FacebookSigninVO facebookSigninVO) {
		
		// 기존 회원인지 여부로 insert처리함
		
		FacebookSigninVO fbUserVo = facebookSigninDao.selectFBId(facebookSigninVO.getLgfb_id());
		System.out.println("기존 Facebook회원 정보 : " + fbUserVo);
		
		String strResult = "";
		int nRet = -2;
		if(fbUserVo == null) { // 신규 회원 -> 회원 가입처리
			nRet = facebookSigninDao.insertNewFacebookUser(facebookSigninVO);
			// Ajax 응답할 메시지를 위한 준비
			if(nRet != 1) { // insert 실패
				strResult = "insertFailed";
			} else {
				strResult = "insertSuccess";
			}
		} else { // 기존 회원 존재함
			strResult = "Success";
		}
		
		
		return strResult;
	}

	@Override
	public int getLgFbNo(String lgFbId) {
		FacebookSigninVO facebookSigninVO = facebookSigninDao.selectLgFbVoById(lgFbId);
		int lgfb_no = facebookSigninVO.getLgfb_no();
		return lgfb_no;
	}
	
	

}
