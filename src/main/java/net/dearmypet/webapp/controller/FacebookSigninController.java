package net.dearmypet.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dearmypet.webapp.dao.FacebookSigninDao;
import net.dearmypet.webapp.service.FacebookSigninService;
import net.dearmypet.webapp.service.LoginService;
import net.dearmypet.webapp.vo.*;

@Controller
public class FacebookSigninController {
	@Autowired
	FacebookSigninService facebookSigninService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/facebookSignin.jsn", method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> facebookSignin(@ModelAttribute FacebookSigninVO facebookSigninVO, HttpSession httpSession) {
		
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
//		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		// 데이터 체크 후 redirect여부 결정
		
		String strRet = "false";
		// insert
		String strFbId = facebookSigninVO.getLgfb_id().trim();
		if(strFbId == null || strFbId.equals("")) {
			strRet = "false";
			
		} else {
			
			String strResult = facebookSigninService.signinFBUser(facebookSigninVO);
			
			if(strResult == "Success" || strResult == "insertSuccess") { // 기존회원 or 신규회원 insert 성공
				strRet = "true";
				
				// facebook에 신규회원이 insert된 다음, login테이블에 insert
				if(strResult == "insertSuccess") {
					// insert한 facebook 사용자 정보를 바탕으로 no값 조회
					int lgfb_no = facebookSigninService.getLgFbNo(facebookSigninVO.getLgfb_id());
					// 기존facebookSigninVO + 부족한 no값 보태기
					facebookSigninVO.setLgfb_no(lgfb_no);
					int nAddMemberRet = loginService.insertLoginMemberFromFBUser(facebookSigninVO);
					if(nAddMemberRet != 1) {
						strRet = "false";
					}
				}
				
				// 세션처리
				httpSession.setAttribute("isLogined", "true");
				httpSession.setAttribute("lg_login_type", "lgfb");
				httpSession.setAttribute("lgfb_name", facebookSigninVO.getLgfb_name()); // 사용자명
				

			} else {
				strRet = "false";
			}
			
			
			/*
			// client 측에서 넘어온 페이스북 데이터를 확인할 때 아래의 소스를 이용해주세요.
//			jsonSubObject = new HashMap<String, Object>();

//			jsonSubObject.put("result", strResult);
			jsonSubObject.put("lgfb_id", facebookSigninVO.getLgfb_id());
			jsonSubObject.put("lgfb_picture", facebookSigninVO.getLgfb_picture());
			jsonSubObject.put("lgfb_name", facebookSigninVO.getLgfb_name());
			jsonSubObject.put("lgfb_age_range", facebookSigninVO.getLgfb_age_range());
			jsonSubObject.put("lgfb_gender", facebookSigninVO.getLgfb_gender());
			jsonSubObject.put("lgfb_email", facebookSigninVO.getLgfb_email());
			jsonSubObject.put("lgfb_birthday", facebookSigninVO.getLgfb_birthday());
			jsonSubObject.put("lgfb_verified", facebookSigninVO.getLgfb_verified());
			*/
			
			
			
			//jsonList.add(jsonSubObject);
			
			
			
		}

//		jsonObject.put("isSuccess", true);
		

		jsonObject.put("result", strRet);
		
		return jsonObject;
	}
}
