package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BbsService;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	//공통적으로 보낼 데이터 타입을 리턴타입으로 -> notice,qna라는 문자열 보낼 것이다
	//속성과 값을 보내주기 때문에 model attribute, 값은 return으로 보내주기 때문에 속성명을 어노테이션에 적어준다
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile[] addFiles,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO,addFiles,session);
		
		String message="등록 실패";
		if(result>0) {
			message="글이 등록 되었습니다";
		}
		
		mv.addObject("result",message);
		mv.addObject("url","./list");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		
		mv.addObject("dto",boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String message="등록 실패";
		if(result>0) {
			message="글이 등록 되었습니다";
		}
		
		mv.setViewName("common/result");
		mv.addObject("result", message);
		mv.addObject("url", "./detail?num="+qnaDTO.getNum());
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardDelete(bbsDTO,session);
		String message="삭제 실패";
		if(result>0) {
			message="글이 삭제 되었습니다";
		}
		mv.setViewName("common/result");
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		mv.addObject("dto", boardDTO);
		
		mv.setViewName("board/update");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO, MultipartFile[] addFiles, HttpSession session, Long[] fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(fileNum);
		int result = qnaService.setBoardUpdate(boardDTO, addFiles, session, fileNum);
		mv.setViewName("common/result");
		mv.addObject("result", "수정성공");
		mv.addObject("url", "./list");
		
		return mv;
	}
	
	//-----------------------------------------------------------------------------------
	
	@PostMapping("boardFileDelete")
	public ModelAndView setboardFileDelete(Long fileNum) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setboardFileDelete(fileNum);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

}
