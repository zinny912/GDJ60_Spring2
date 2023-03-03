package com.iu.s1.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.util.Pager;



@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	//원래타입 원래 이름으로 해도 됨
	@Autowired
	private QnaService qnaService;
	
	//List에 이름설정해주기
	//모델 속성에 담으세요
	@ModelAttribute("boardName") 
	public String getBoardName() {
		return "QNA";
	}
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		//kind search page번호 받기위해 Pager 매개변수로
		ModelAndView mv = new ModelAndView();
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		
		mv.addObject("list",ar);
		//mv.addObject("pager",pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	//jsp로 보냄
	@GetMapping("add")
	public ModelAndView setBoardAdd()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/add");
		return mv;
	}
	
	
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile[] files, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setBoardAdd(qnaDTO, files, session);
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		
		mv.addObject("result",message);
		mv.addObject("url","./list");
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO= qnaService.getBoardDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
		
	}
	
	
	//어느글에 대한 답글인지를 알아야하기 때문에 DTO필요 NUM들어있는 DTO
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/reply");
				
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		
		mv.setViewName("common/result");
		mv.addObject("result", message);
		mv.addObject("url", "./detail?num="+qnaDTO.getNum());
		return mv;
	}
	
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		
		int result=qnaService.setBoardDelete(bbsDTO, session);
			
		String message ="삭제 실패";	
		
		if(result>0) {
			message="삭제 성공";
		}
		mv.addObject("result", message);
		mv.addObject("url", "./list");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		mv.addObject("boardFile", boardFileDTO);
		mv.setViewName("fileDownView");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView setBoardUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getBoardDetail(boardDTO);
		
		mv.addObject("dto",boardDTO);
		
		mv.setViewName("board/update");
		return mv;
	}
	

}
