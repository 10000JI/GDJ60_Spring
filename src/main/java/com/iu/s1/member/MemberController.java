package com.iu.s1.member;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@PostMapping("memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean check = memberService.getMemberIdCheck(memberDTO);
		mv.addObject("result", check);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@RequestMapping(value="memberAgree", method=RequestMethod.GET)
	public void setMemberAgree() throws Exception{
		
	}
	
	@RequestMapping(value = "list")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		System.out.println(ar!=null);
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		return mv;
	}

	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String getMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.setMemberJoin(memberDTO);
		System.out.println(result==1);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public ModelAndView getMemberLogin(HttpServletRequest request ) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberLogin");
	      
		Cookie [] cookies = request.getCookies();
	      
//		for(Cookie cookie: cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("------------------------------");
//	         if(cookie.getName().equals("rememberId")) {
//	            mv.addObject("rememberId",cookie.getValue());
//	            break;
//	         }
//	      }
	      return mv;
	   }

	@RequestMapping(value = "memberLogin", method=RequestMethod.POST)
	public ModelAndView getMemberLogin(MemberDTO memberDTO, HttpServletRequest request, String remember, HttpServletResponse response) throws Exception {
		ModelAndView mv =new ModelAndView();
		
		if(remember!=null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7);//ch ??????
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			response.addCookie(cookie);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
//		memberDTO = memberService.getMemberLoin(memberDTO);
//		if(memberDTO != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);			
//		}
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value ="memberLogout",method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		mv.addObject("dto",memberDTO);
		mv.setViewName("member/memberPage");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		
		mv.addObject("dto",memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO,HttpSession session) throws Exception{
		//??????1)
		//jsp?????? input ?????? hidden?????? ????????? ?????????????????? ??????????????????
		//????????? Session?????? id?????? ????????????
		//??????2)
		//???????????? ????????? ????????? ???????????????, id?????? ???????????? select?????? ???????????? 
		//?????? ???????????? ???????????? (???????????????, ?????? ???????????? ?????? ??? (??????????????? ??????))
		//???????????? ?????? ????????? ????????? select??? ????????? ?????? ???????????? ????????? ??????????????? ??? ????????? ??? ??????????????? 
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionDto= (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionDto.getId());
		//?????? ?????? ??? dto?????? ????????? ????????? dto ??????, Object????????? ?????????
		int result = memberService.setMemberUpdate(memberDTO);

		mv.setViewName("redirect:./memberPage");
		return mv;
	}
}