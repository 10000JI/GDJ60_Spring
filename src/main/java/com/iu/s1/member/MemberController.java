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
			cookie.setMaxAge(60*60*24*7);//ch 단위
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
		//방법1)
		//jsp에서 input 태그 hidden으로 보내면 클라이언트가 조작가능하다
		//따라서 Session으로 id값을 보내준다
		//방법2)
		//지금까지 세션을 가지고 사용했다면, id값만 가져오는 select문을 사용하여 
		//다시 조회해서 뿌려준다 (로그인할때, 나의 페이지로 갈때 등 (업데이트는 제외))
		//복잡하긴 해도 메모리 영역에 select한 정보를 모두 가져오면 과부하 일으키므로 이 방법이 더 효과적이다 
		ModelAndView mv = new ModelAndView();
		MemberDTO sessionDto= (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionDto.getId());
		//위는 수정 전 dto이기 때문에 새롭게 dto 선언, Object타입을 형변환
		int result = memberService.setMemberUpdate(memberDTO);

		mv.setViewName("redirect:./memberPage");
		return mv;
	}
}