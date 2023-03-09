package com.iu.s1.board;

import java.util.List;

// 부모형 생성
//인터페이스도 다른 인터페이스를 상속받을 수 있다
public interface BoardDAO extends BbsDAO{
	
	//list
	
	//detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	
	//add
	
	//fileAdd
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
		
	//update
	
	//delete

	//BoardFileList
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	//BoardFileDetail
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO)throws Exception;
	
	//BoardFileDelete
	public int setBoardFileDelete(Long fileNum)throws Exception;
	
	
}
