package net.dearmypet.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;

import net.dearmypet.webapp.service.LoginService;
import net.dearmypet.webapp.vo.FacebookSigninVO;
import net.dearmypet.webapp.vo.LoginDataVO;
import net.dearmypet.webapp.vo.LoginVO;

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
	
	/*
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public  @ResponseBody Map<String , Object> loginUser1( @RequestBody Resource<LoginDataVO> loginVO, HttpServletRequest request) { //test
//		public  @ResponseBody Map<String , Object> loginUser1(@RequestBody LoginDataVO loginVO, HttpServletRequest request) { //test
//	public  @ResponseBody Map<String , Object> loginUser1(@ModelAttribute LoginDataVO loginVO, HttpServletRequest request) { //test

		System.out.println("loginVO.getLg_email() : " + loginVO.getLg_email());
		System.out.println("loginVO.getLg_password() : " + loginVO.getLg_password());
		System.out.println("request.getLg_email() : " + request.getParameter("lg_email"));
		System.out.println("request.getLg_password() : " + request.getParameter("ld_password"));
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		String strRet = "requiredFields";

		jsonObject.put("result", strRet);
		
		return jsonObject;
	}
	*//*
	// 로그인
	@RequestMapping(value="/login.jsn", method=RequestMethod.POST)
	public @ResponseBody Map<String , Object> loginUser(@ModelAttribute LoginVO loginVO, HttpSession httpSession) {
			
		
		System.out.println("loginVO.getLg_email() : " + loginVO.getLg_email());
		System.out.println("loginVO.getLg_password() : " + loginVO.getLg_password());
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		String strRet = "success";
		if( (loginVO.getLg_email() == null || loginVO.getLg_email().equals("")) 
				|| (loginVO.getLg_password() == null || loginVO.getLg_password().equals("")) ) {
			strRet = "requiredFields"; // 로그인에 필요한 정보가 없음.
		} else {
			LoginVO loginDbVO = loginService.selectLoginByEmailAndPassword(loginVO.getLg_email(), loginVO.getLg_password());
			if(loginDbVO == null) { // 일반 사용자 정보가 테이블에 없음
				strRet = "failed";
			} else if(loginDbVO.getLg_login_type() != 3) { // 일반 회원가입이 아닌 소셜로그인 계정
				strRet = "socialUser";
			} else { // 로그인 사용자 정보 조회 성공 : 사용자 정보를 세션에 등록

				httpSession.setAttribute("isLogined", "true");
				httpSession.setAttribute("lg_login_type", "ordinary"); // 일반 사용자가 로그인
				httpSession.setAttribute("lg_nickname", loginDbVO.getLg_nickname()); // 사용자명
				httpSession.setAttribute("lg_id", loginDbVO.getLg_id()); // user id
				httpSession.setAttribute("lg_no", loginDbVO.getLg_no()); // table no
				httpSession.setAttribute("m_no", loginDbVO.getM_no()); // m_no
				
				strRet = "success";
			}
			
		}
		
		jsonObject.put("result", strRet);
		
		return jsonObject;
	}
*/
	// 로그아웃
	@RequestMapping(value="/logout.jsn", method=RequestMethod.GET)
	public @ResponseBody Map<String , Object> logout(HttpSession httpSession) {
		httpSession.setAttribute("isLogined", "");
		httpSession.setAttribute("lg_login_type", "");
		// facebook user
		httpSession.setAttribute("lgfb_name", ""); // 사용자명
		httpSession.setAttribute("lgfb_id", ""); // facebook user id
		httpSession.setAttribute("lgfb_no", ""); // facebook table no

		// 일반사용자
		httpSession.setAttribute("lg_nickname", ""); // 사용자명
		httpSession.setAttribute("lg_id", ""); // user id
		httpSession.setAttribute("lg_no", ""); // table no
		httpSession.setAttribute("m_no", ""); // m_no
		
		
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
