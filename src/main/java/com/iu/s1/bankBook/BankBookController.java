package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list", method=RequestMethod.GET)
	public ModelAndView getbankBookList(@ModelAttribute Pager pager) throws Exception {
		//매개변수에 들어간 Pager은 자동 객체 생성되면서 @ModelAttribute로 jsp에 자동으로 보내준다.(생략됨)
		ModelAndView mv = new ModelAndView();
		
		List<BankBookDTO> ar= bankBookService.getBankBookList(pager);
		
		mv.setViewName("bankBook/bankBookList");
		mv.addObject("list", ar);
		mv.addObject("paper", pager);
		return mv;
	}
	
	@RequestMapping(value="detail")
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("bankBook/bankBookDetail");
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView mv) throws Exception{
		mv.setViewName("bankBook/bankBookAdd");
		return mv;
	}
	
	//add form 이동
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Name:"+pic.getName());
		System.out.println("OriName:"+pic.getOriginalFilename());
		System.out.println("Size:"+pic.getSize());
		System.out.println(session.getServletContext());
		int result = bankBookService.setBankBookAdd(bankBookDTO,pic);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "delete")
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("bankBook/bankBookUpdate");
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO ,ModelAndView mv) throws Exception{
		int result = bankBookService.setBankBookUpdate(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
}
