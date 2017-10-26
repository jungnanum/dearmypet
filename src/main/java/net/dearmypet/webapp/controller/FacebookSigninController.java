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
import net.dearmypet.webapp.vo.*;

@Controller
public class FacebookSigninController {
	@Autowired
	FacebookSigninService facebookSigninService;
	
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
				// TODO: login테이블에 insert
				if(strResult == "insertSuccess") {
					
					
				}
				
				// 세션처리
				httpSession.setAttribute("isLogined", true);
				httpSession.setAttribute("lg_login_type", "lgfb");
				

				strRet = "true";
			} else {
				strRet = "false";
			}
			
//			jsonSubObject = new HashMap<String, Object>();
//			jsonSubObject.put("result", strResult);
			/*
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
