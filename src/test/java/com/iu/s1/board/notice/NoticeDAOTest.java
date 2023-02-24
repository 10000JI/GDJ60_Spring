package com.iu.s1.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void getNoticeListTest() throws Exception{
		Pager pager = new Pager();
		pager.setNum(35L);
		pager.setKind("writer");
		pager.setSearch("관리자");
		pager.makeRow();
		//long count = noticeDAO.getTotalCount(pager);
		List<BbsDTO> ar = noticeDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setNoticeAddTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title1");
		noticeDTO.setWriter("writer1");
		noticeDTO.setContents("Contents1");
		int result = noticeDAO.setBoardAdd(noticeDTO);
		assertEquals(1, result);
	}
}
