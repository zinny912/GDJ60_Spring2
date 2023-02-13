package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.bankBook.BankBookDTO;
import com.iu.s1.util.DBConnection;


@Repository
public class MemberDAO {
		
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.iu.s1.member.MemberDAO.";
	
	//insert
	public int setMemberJoin(MemberDTO memberDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberJoin", memberDTO);
		}
	
	
//	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
//		
//		Connection connection = DBConnection.getConnection(); 
//		
//		String sql = "INSERT INTO MEMBER2 (ID, PW, NAME, ADDRESS, PHONE, EMAIL)"
//				+ " VALUES(?, ?, ?, ?, ?, ?)";
//			
//		PreparedStatement st = connection.prepareStatement(sql);
//		
//		st.setString(1, memberDTO.getId());
//		st.setString(2, memberDTO.getPw());
//		st.setString(3, memberDTO.getName());
//		st.setString(4, memberDTO.getAddress());
//		st.setString(5, memberDTO.getPhone());
//		st.setString(6, memberDTO.getEmail());
//		
//		int result = st.executeUpdate();
//		
//		DBConnection.disConnection(st, connection);
//		
//		return result;
//	
	

}
