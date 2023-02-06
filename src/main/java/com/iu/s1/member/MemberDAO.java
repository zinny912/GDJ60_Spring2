package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

	

@Repository
	public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.member.MemberDAO.";	
		
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {

		return sqlSession.insert(NAMESPACE+"memeberJoin", memberDTO);
	}
	
//	public void memberList() throws Exception{
//		
//		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
//		
//		return 
		
		
	}
	
	
	
	
