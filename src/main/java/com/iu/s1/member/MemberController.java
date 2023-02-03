package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin")
	public String getmemberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("230202");
		int a = memberService.setaddMember(memberDTO);
		if(a>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return "/member/memberJoin";
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
