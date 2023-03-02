package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDAO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String Namespace="com.iu.s1.board.notice.NoticeDAO.";
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+"getTotalCount",pager);
	}
	
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+"getBoardList",pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace+"setBoardAdd",bbsDTO);
	}
	@Override
	public int setBoardFileAdd(BoardFileDTO boardfileDTO) throws Exception{
		return sqlSession.insert(Namespace+"setBoardFileAdd", boardfileDTO);
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

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace+"getBoardDetail",boardDTO);
	}
	
	@Override
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace+"getBoardFileList",bbsDTO);
	}
}
