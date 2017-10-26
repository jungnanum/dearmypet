package net.dearmypet.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dearmypet.webapp.dao.LoginDao;
import net.dearmypet.webapp.vo.FacebookSigninVO;
import net.dearmypet.webapp.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Map getLoginAllList() {
		HashMap map = new HashMap();

		List<LoginVO> list = loginDao.selectAllLogin();
		map.put("list", list);
		
		return map;
	}

	@Override
	public int insertLoginMemberFromFBUser(FacebookSigninVO facebookSigninVO) {
		LoginVO loginVO = new LoginVO();
		loginVO.setLg_id("fb_" + facebookSigninVO.getLgfb_id());
		loginVO.setLg_profile(facebookSigninVO.getLgfb_picture());
		//페이스북 사용자의 비밀번호는 없음
		loginVO.setLg_password("");
		loginVO.setLg_email(facebookSigninVO.getLgfb_email());
		loginVO.setLg_nickname(facebookSigninVO.getLgfb_name());
		// 주의 facebook no가 빈값이 아이어야 함.
		loginVO.setLgfb_no(facebookSigninVO.getLgfb_no());
		loginVO.setLgka_no(0);
		loginVO.setM_no(0);
		loginVO.setLg_login_type(1); // facebook 사용자의 logintype은 1.
		int nRet = loginDao.insertLoginVO(loginVO);
		return nRet;
	}

}
