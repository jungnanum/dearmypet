package net.dearmypet.webapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacebookSigninController {

	@RequestMapping("/facebookAccessToken")
	public String getFacebookAccessToken(HttpSession session) {
		session.setAttribute("test", "returned!!");
		return "redirect:/main.dmp";
	}
}
