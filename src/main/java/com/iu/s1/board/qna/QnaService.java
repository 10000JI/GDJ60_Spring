package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private FileManager fileManager;
	
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] multipartFiles, HttpSession session)  throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		//file을 HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile:multipartFiles) {
			if(multipartFile.isEmpty()) {
				//파일 업로드가 안된 게시물은 continue로 처음으로 올라감
				continue;
			}
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			//DB에 INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session, Long[] fileNums)
			throws Exception {
		//qna Update
		int result = qnaDAO.setBoardUpdate(bbsDTO);
		
		//qnaFiles Delete
		if(fileNums != null) {
			for(Long fi : fileNums) {
				qnaDAO.setBoardFileDelete(fi);
			}
		}
		
		//qnaFiles Insert
		//file을 HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile:multipartFiles) {
			if(multipartFile.isEmpty()) {
				//파일 업로드가 안된 게시물은 continue로 처음으로 올라감
				continue;
			}
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			//DB에 INSERT
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		
		return 0;
	}


	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardFileDetail(boardFileDTO);
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		//해당 게시판 글의 파일(이미지)가 존재하는지 한번 select (여러개 있을 수 있으니 list로)
		int result = qnaDAO.setBoardDelete(bbsDTO);
		//다음에 지우고싶은거 삭제
		if(result>0) {
			String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
			for(BoardFileDTO boardFileDTO:ar) {
				//filename은 다 다르게 설정되므로 FileManger 클래스에서
				//fileDelete 메소드가 path와 함께 해당 이름가진 것을 delete 해준다
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
		}
		return result;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}

	//reply Insert
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		//QnaDTO
		//num : 부모의 글번호
		//writer,title,contents :답글로 입력한 값
		//ref: null
		//step: null
		//depth: null
		
		//1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		//ref: 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		//step: 부모의 step+1
		qnaDTO.setStep(parent.getStep()+1);
		
		//depth: 부모의 depth+1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. Step을 update
		int result = qnaDAO.setStepUpdate(parent);
		
		//3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}
	

}
