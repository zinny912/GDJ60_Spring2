package com.iu.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.member.MemberDAO.";
	
	
	public int setMemberAdd(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}

	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd",memberDTO);
	}
	
	//로그인
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
		
	//개인정보페이지
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMemberPage", memberDTO);
	}
	
	//정보수정
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
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

