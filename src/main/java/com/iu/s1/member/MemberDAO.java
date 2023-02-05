package com.iu.s1.member;

import com.iu.s1.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO BANKMEMBERS (ID,PW,NAME,PHONE,EMAIL)"
				+ " VALUES (?,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
	}
	
	public List<MemberDTO> getMemberList() throws Exception{
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT ID,PW,NAME,PHONE,EMAIL FROM BANKMEMBERS";
		PreparedStatement st= connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setName(rs.getString("PW"));
			memberDTO.setPhone(rs.getString("PHONE"));
			memberDTO.setEmail(rs.getString("EMAIL"));
			ar.add(memberDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		return ar;
	}
	
//	public static void main(String[] args) throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		MemberDAO memberDAO = new MemberDAO();
//		memberDTO.setId("id1");
//		memberDTO.setPw("pw1");
//		memberDTO.setName("name1");
//		memberDTO.setPhone("phone1");
//		memberDTO.setEmail("Email1");
//		int a =memberDAO.setaddMember(memberDTO);
//		System.out.println(a == 1);
//	}
}
