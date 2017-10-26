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
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;

import net.dearmypet.webapp.service.LoginService;
import net.dearmypet.webapp.vo.FacebookSigninVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * login 테이블 목록 반환
	 * @return ModelAndView("",map)
	 * @throws Exception
	 */
	@RequestMapping("/LoginAllList.dmp")
	public ModelAndView getLoginAllList() throws Exception{
		Map map = loginService.getLoginAllList();
		return new ModelAndView("Member/LoginList.tiles", map);
	}
	
	/**
	 * Map방식을 이용한 JSON API 컨트롤러
	 * @return
	 */
//	@RequestMapping(value="LoginAllList.dmp", produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	@RequestMapping(value="/getJsonByMap.jsn", method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> getJsonByMap() {
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		
		//1번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("idx", 1);
		jsonSubObject.put("title", "제목입니다");
		jsonSubObject.put("create_date", new Date());
		jsonList.add(jsonSubObject);
		//2번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("idx", 2);
		jsonSubObject.put("title", "두번째제목입니다");
		jsonSubObject.put("create_date", new Date());
		jsonList.add(jsonSubObject);
		
		jsonObject.put("success", true);
		jsonObject.put("total_count", 10);
		jsonObject.put("result_list", jsonList);
		
		return jsonObject;
	}
	

	@RequestMapping(value="/logout.jsn", method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> logout(HttpSession httpSession) {
		httpSession.setAttribute("isLogined", "");
		httpSession.setAttribute("lg_login_type", "");
		httpSession.setAttribute("lgfb_name", ""); // 사용자명
		httpSession.setAttribute("lgfb_id", ""); // facebook user id
		httpSession.setAttribute("lgfb_no", ""); // facebook table no
		
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
//		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		
		
		
		jsonObject.put("result", "success");
		
		return jsonObject;
	}
	/*
	@RequestMapping(value= "/ajax.seo", method=RequestMethod.GET)
	public @ResponseBody SocialPerson AjaxView(  
	        @RequestParam("id") String id)  {

	    SocialPerson person = dao.getPerson(id);
	    return person;
	}*/
}
