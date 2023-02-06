package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberJoin(memberDTO);
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		return memberDAO.getMemberList();
	}
}