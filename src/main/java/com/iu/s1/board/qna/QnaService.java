package com.iu.s1.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.board.BbsDAO;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.BoardService;
import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
			pager.makeRow();
		
			pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		//file HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile: multipartFiles) {
			
			//파일이 비어있으면 다시 위로 올라가세요 (보조문 써주기)
			if(multipartFile.isEmpty()) {
				continue;
			}
			//저장하면서 이름
			String fileName= fileManager.fileSave(multipartFile, realPath);
			
			//DB Insert
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
		result =qnaDAO.setBoardFileAdd(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		int result = qnaDAO.setBoardDelete(bbsDTO);
		//파일명이 없기 때문에 DB에서 조회해서 와야함 -> mapper에 SQL문 추가
		
		if(result>0) {
			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna");
			
			for(BoardFileDTO boardFileDTO:ar) {		
				boolean check=fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			
		}
		return result;
	}

	//detail 
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	//reply Insert
	//BoardDTO에는 ref, step, depth 없어서 QnaDTO 사용
	public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
		//QnaDTO
		//num : 부모의 글번호
		//writer, title, contents : 답글로 입력한 값
		//regdata, hit : sysdate, 0
		//ref : null
		//step : null
		//deptrh : null
		
		//1. 부모의 정보 조회 - detail 사용 
		//detail에는 boardDTO로 되어있어서 형변환하여 사용
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO); //글번호
		
		//ref : 부모의 ref사용
		//step : 부모의 step +1
		//depth : 부모의 depth +1
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. Step Update -> 답글 insert전에 실행되어야함 QnaDAO에 메서드 생성
		int result = qnaDAO.setStepUpdate(parent);
	
		//3. 답글 insert 
		result = qnaDAO.setReplyAdd(qnaDTO);
	
		return result;
	
	}
	
}
