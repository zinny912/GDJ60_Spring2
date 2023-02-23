package com.iu.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private BbsDAO noticeDAO;
	
	public List<BbsDTO> getBoardList(Pager pager) throws Exception{
		
		pager.makeRow();
		Long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeBlock(totalCount);
			
		return noticeDAO.getBoardList(pager);
	}
	

}
