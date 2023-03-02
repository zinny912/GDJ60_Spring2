package com.iu.s1.board.qna;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	private final String Namespace="com.iu.s1.board.qna.QnaDAO.";
	
	//count
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+"getTotalCount",pager);
	}
	//list
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+"getBoardList",pager);
	}
	//add
	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+"setBoardAdd", bbsDTO);
	}
	
	@Override
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+"setBoardFileAdd",boardFileDTO);
	}
	

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(Namespace+"setBoardDelete",bbsDTO);
	}

	//detail 
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+"getBoardDetail", boardDTO);
	}
	
	//답글을 insert하기 전에 먼저 실행
	public int setStepUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(Namespace+"setStepUpdate", qnaDTO);
		
	}
	//답글 insert mapper만들고 와서 DAO생성 후 service 가서 생성
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(Namespace+"setReplyAdd", qnaDTO);
	}
	
	@Override
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+"getBoardFileList", bbsDTO);
	}
}
