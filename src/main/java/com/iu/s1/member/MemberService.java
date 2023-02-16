package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberJoin(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		return memberDAO.getMemberList();
	}
	
	public MemberDTO getMemberLoin(MemberDTO memberDTO) throws Exception {
		//memberDTO: Client에서 입력한 id, pw
		MemberDTO result = memberDAO.getMemberLoin(memberDTO);
		//result: id와 일치하는 모든 정보
		
		//pw check
		if(result != null && memberDTO.getPw().equals(result.getPw())) {
			//result가 0이면 result.getPw()에서 nullpointerException 발생 , null이 아닐 때 조건도 줘야 함
			//해당 조건은 앞에 순서 줘야 함 (False && ..이면 무조건  else로 가기 때문)
			memberDTO.setPw(null);
			return memberDTO;
			//리턴되는 것은 result가 아니라 memberDTO(id,pw에서 pw는 null이 됐으니 id만)
		}else {
			return null;
		}	
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception{
		return memberDAO.getMemberLoin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		int result = memberDAO.setMemberUpdate(memberDTO);
		return result;
	}
}