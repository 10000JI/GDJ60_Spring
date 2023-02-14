package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ffff");
		memberDTO.setPw("111");
		memberDTO.setName("ffff");
		memberDTO.setPhone("11111111");
		memberDTO.setEmail("ffff@naver.com");
		int a = memberDAO.setMemberJoin(memberDTO);
		assertEquals(1, a);
	}
	
	@Test
	public void setMemberUpdateTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("MINJI");
		memberDTO.setPw("1235");
		memberDTO.setName("MINJI");
		memberDTO.setPhone("010-1111-9898");
		memberDTO.setEmail("MINJI@gmail.com");
		int a = memberDAO.setMemberUpdate(memberDTO);
		assertEquals(1, a);
	}
}
