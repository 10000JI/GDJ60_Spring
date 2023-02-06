package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "list")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		System.out.println(ar!=null);
		mv.addObject("list", ar);
		mv.setViewName("/member/memberList");
		return mv;
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void setMemberJoin() {
		
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String getMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberJoin(memberDTO);
		System.out.println(result==1);
		return "redirect:./list";
	}
}