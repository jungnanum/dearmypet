package net.dearmypet.webapp.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.dearmypet.webapp.service.LoginService;
import net.dearmypet.webapp.vo.*;

// 테스트 URL :  http://localhost/dearpet/sendLoginVO.jsn
@RestController
//@RequestMapping("/basic/*")
public class LoginRestfulController {
//	@Autowired
//	LoginVO  loginVO;

	@Autowired
	private LoginService loginService;
	
	// json객체 리턴
//    @RequestMapping("/sendLoginVO")
	@PostMapping(value="/login.jsn", headers="Accept=application/json")
//	@RequestMapping(value="/login.jsn", headers="Accept=application/json")
//	public HashMap<String, Object> resLogin(@ModelAttribute LoginVO loginVO, HttpSession httpSession, HttpServletRequest request){
	public HashMap<String, Object> resLogin(@RequestParam(value="lg_email", defaultValue="njs@naver.com") String lg_email,
			@RequestParam(value="lg_password", defaultValue="a1") String lg_password,
			HttpSession httpSession, @ModelAttribute LoginVO loginVO){
		
		// FIXME: parameter가 넘어오지 않는 현상 수정예정
		System.out.println("lg_email : " + lg_email);
		System.out.println("lg_password : " + lg_password);


		httpSession.setAttribute("isLogined", "true");
		httpSession.setAttribute("lg_login_type", "ordinary"); // 일반 사용자가 로그인
		httpSession.setAttribute("lg_nickname", "njs"); // 사용자명
		httpSession.setAttribute("lg_id", "njs"); // user id
		httpSession.setAttribute("lg_no", 411); // table no
		httpSession.setAttribute("m_no", 2); // m_no
		
/*		// 일단 시연을 위해 default value 적용
		if(loginVO.getLg_email().equals("")) {
			loginVO.setLg_email(lg_email);
		}
		if(loginVO.getLg_password().equals("")) {
			loginVO.setLg_password(lg_password);
		}*/
		
//		String strRet = "requiredFields";
		
/*		System.out.println(loginVO);

		System.out.println("loginVO.getLg_email() : " + loginVO.getLg_email());
		System.out.println("loginVO.getLg_password() : " + loginVO.getLg_password());
*/		
		
		String strRet = "success";
/*		if( (loginVO.getLg_email() == null || loginVO.getLg_email().equals("")) 
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
		*/
    	/*loginVO.setLg_email("lg_email");
    	loginVO.setLg_id("lg_id");
    	loginVO.setLg_login_type(1);
    	loginVO.setLg_nickname("lg_nickname");
    	loginVO.setLg_no(1);
    	loginVO.setLg_profile("lg_profile");
    	loginVO.setLgfb_no(1);
    	loginVO.setLgka_no(1);
    	loginVO.setM_no(1);
    	
    	return loginVO;*/
		HashMap<String, Object> map = new HashMap();
		
		map.put("result", strRet);
		
		return map;
    }
}
