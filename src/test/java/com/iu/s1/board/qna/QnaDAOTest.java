package com.iu.s1.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getTotalCount() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(2L);
		//long count = qnaDAO.getTotalCount(pager);
		BoardDTO boardDTO =qnaDAO.getBoardDetail(qnaDTO);
		assertNotNull(boardDTO);
	}

}
