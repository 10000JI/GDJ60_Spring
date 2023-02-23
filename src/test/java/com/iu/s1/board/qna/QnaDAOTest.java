package com.iu.s1.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getQnaListTest() throws Exception {
		Pager pager = new Pager();
		pager.setNum(7L);
		pager.setKind("writer");
		pager.setSearch("사용자-1");
		pager.makeRow();
		//long count = qnaDAO.getTotalCount(pager);
		List<BbsDTO> ar =qnaDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}

}
