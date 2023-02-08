package com.iu.s1.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "list")
	public ModelAndView getbankBookList(ModelAndView mv) throws Exception {
		List<BankBookDTO> ar= bankBookService.getBankBookList();
		mv.setViewName("bankBook/bankBookList");
		mv.addObject("list", ar);
		return mv;
	}
	
	@RequestMapping(value="detail")
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		mv.setViewName("bankBook/bankBookDetail");
		mv.addObject("detail", bankBookDTO);
		return mv;
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public ModelAndView setBankBookAdd(ModelAndView mv) throws Exception{
		mv.setViewName("bankBook/bankBookAdd");
		return mv;
	}
	
	//add form 이동
	@RequestMapping(value="add", method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
	@RequestMapping(value = "delete")
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
//	@RequestMapping(value = "update", method = RequestMethod.GET)
//	public void setBankBookUpdate() throws Exception{
//		
//	}
//	
//	@RequestMapping(value = "update",method = RequestMethod.POST)
//	public String setBankBookUpdate(BankBookDTO bankBookDTO ,ModelAndView mv) throws Exception{
//		int result = bankBookService.setBankBookUpdate(bankBookDTO);
//		System.out.println(result==1);
//		return "redirect:./list";
//	}
}
