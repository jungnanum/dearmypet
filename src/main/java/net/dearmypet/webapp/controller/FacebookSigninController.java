package net.dearmypet.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.dearmypet.webapp.vo.*;

@Controller
public class FacebookSigninController {

	@RequestMapping("/facebookAccessToken")
	public String getFacebookAccessToken(HttpSession session) {
		session.setAttribute("test", "returned!!");
		return "redirect:/main.dmp";
	}
	
	@RequestMapping(value="/facebookSignin", method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> facebookSignin(@ModelAttribute FacebookSigninVO facebookSigninVO) {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		
		//1번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("lgfb_id", facebookSigninVO.getLgfb_id());
		jsonSubObject.put("lgfb_picture", facebookSigninVO.getLgfb_picture());
		jsonSubObject.put("lgfb_name", facebookSigninVO.getLgfb_name());
		jsonSubObject.put("lgfb_age_range", facebookSigninVO.getLgfb_age_range());
		jsonSubObject.put("lgfb_gender", facebookSigninVO.getLgfb_gender());
		jsonSubObject.put("lgfb_email", facebookSigninVO.getLgfb_email());
		jsonSubObject.put("lgfb_birthday", facebookSigninVO.getLgfb_birthday());
		jsonSubObject.put("lgfb_verified", facebookSigninVO.getLgfb_verified());
		jsonList.add(jsonSubObject);
		
		return jsonObject;
	}
}
