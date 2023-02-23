package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

//부모형생성
public interface BbsDAO {
	
	//totalCount
	public Long getTotalCount(Pager pager)throws Exception;
	
	//list
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	//insert(add)
	public int setBoardAdd(BbsDTO bbsDTO)throws Exception;
	
	//update
	public int setBoardUpdate(BbsDTO bbsDTO)throws Exception;
		
	//delete
	public int setBoardDelete(BbsDTO bbsDTO)throws Exception;

}
