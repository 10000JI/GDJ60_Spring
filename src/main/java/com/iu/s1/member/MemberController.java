package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@RequestMapping("join")
	public String getMemberJoin() {
		return "member/memberJoin";
	}
	
	@RequestMapping("memberLogin")
	public void getMemberLogin() {
		
	}
	
	@RequestMapping("page")
	public ModelAndView getMemberPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberPage");
		return mav;
	}
}
