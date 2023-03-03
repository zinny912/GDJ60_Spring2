package com.iu.s1.board;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsService;

@Service
public interface BoardService extends BbsService {

	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	// 여기서 진행하면 2번 받아야해서 BbsService에서 진행
	// public int setBoardAdd(BoardDTO boardDTO,MultipartFile[] multipartFiles) throws Exception;
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO)throws Exception;
}
