package com.iu.s1.board;

import org.springframework.stereotype.Service;
import com.iu.s1.board.BbsService;

@Service
public interface BoardService extends BbsService {

	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;

}
