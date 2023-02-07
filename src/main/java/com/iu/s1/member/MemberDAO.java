package com.iu.s1.member;

import com.iu.s1.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO.";
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setMemberJoin",memberDTO);
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}

}
