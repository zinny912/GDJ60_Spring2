package com.iu.s1.bankBook;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s1.util.FileManager;
import com.iu.s1.util.Pager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//testcase 테스트시 mull이 들어옴
	//API추가
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public List<BankBookDTO> getBankBookList(Pager pager) throws Exception {
		
		
		Long totalCount = bankBookDAO.getBankBookCount(pager);
		
		pager.makeNum(totalCount);//startNum,lastNum 호출
		pager.makeRow();
		
		return bankBookDAO.getBankBookList(pager);
	}
	
	public BankBookDTO getBankBookDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getBankBookDetail(bankBookDTO);
	}
	
	public int setBankBookAdd(BankBookDTO bankBookDTO, MultipartFile pic) throws Exception{
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
//-------------------------------------------↓파일이 있는경우에 저장하기이이이이---------------------------------------------------	
		if(!pic.isEmpty()/*pic이 비어있지 않다면*/)/*(pic.getSize()!=0)*/ {
			//1.File을 HDD에 저장
			// project 경로가 아닌 OS가 사용하는 경로로 - method 사용
			//C부터 시작하는 경로 realpath
			String realPath = servletContext.getRealPath("resources/upload/bankBook");
			System.out.println(realPath);
			String fileName = fileManager.fileSave(pic, realPath);
			
			//2. DB에 저장
			BankBookImgDTO bankBookImgDTO = new BankBookImgDTO();
			bankBookImgDTO.setFileName(fileName);
			bankBookImgDTO.setOriName(pic.getOriginalFilename());
			bankBookImgDTO.setBookNumber(bankBookDTO.getBookNumber());
			
			result = bankBookDAO.setBankBookImgAdd(bankBookImgDTO);
		}
//-------------------------------------------↑파일이 있는경우에 저장하기이이이이---------------------------------------------------
		
		return result;//bankBookDAO.setBankBookAdd(bankBookDTO);
	}
	
	public int setBankBookUpdate(BankBookDTO banBookDTO) throws Exception{
		return bankBookDAO.setBankBookUpdate(banBookDTO);
	}
	
	public int setBankBookDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBookDelete(bankBookDTO);
	}

}
