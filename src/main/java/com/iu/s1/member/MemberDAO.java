package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO.";
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
		
	}
	
	
	
	//setAddMember
//	
//	public int setAddMember (MemberDTO memberDTO) throws Exception {
//		
//		Connection con = DBConnection.getConnection();
//		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE, EMAIL, ADDRESS) "
//				+ "VALUES (?, ?, ?, ?, ?, ? )";
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, memberDTO.getId());
//		st.setString(2, memberDTO.getPw());
//		st.setString(3, memberDTO.getName());
//		st.setString(4, memberDTO.getPhone());
//		st.setString(5, memberDTO.getEmail());
//		st.setString(6, memberDTO.getAddress());
//		
//		int result = st.executeUpdate();
//		
//		DBConnection.disConnect(st, con);
//		
//		return result;
//		
//	}
//	

}
