package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int setaddMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.setaddMember(memberDTO);
	}
}
