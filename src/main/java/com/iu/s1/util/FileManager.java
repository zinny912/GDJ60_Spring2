package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//File을 HDD에서 삭제 //boolean, int result 하고싶은걸로 하면됨 // 삭제 여부 상관없이 삭제하려면 void
	public boolean fileDelete(String path, String fileName)throws Exception{
		File file = new File(path, fileName);
		
		return file.delete();
		
	}
	
	
	
	
	//File을 HDD에 저장
	//service에서 할 역할 클래스 새로 생성하여 작성
	public String fileSave(MultipartFile multipartFile, String path) throws Exception{
		//1. 어디에 저장할 것인가?
		//        /resources/upload/bankBook/....
		//2. 저장관리는 운영체제가 담당 (windows는 C)
		File file = new File(path);
		
		//폴더생성 :  폴더가 존재하지 않으면 폴더를 만들어라!
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
		//3. 중복되지 않는 파일명 생성
		Calendar ca = Calendar.getInstance();
		//1)ca.getTimeInMillis(); //현재시간을 milliseconds로 바꿔서 longtype으로
		String name = UUID.randomUUID().toString();
		
		//4. 확장자추가 방법 2가지
		//1) originalName에서 subString이용해서 확장자명 추출
		//2) originalName을 붙여버리기
		
		//2)
		name = name+"_"+multipartFile.getOriginalFilename();
		System.out.println(name);
		
		//5. 파일을 저장하기
		file = new File(file, name);
		
		//1) multiPartFile 객체의 transferTo메서드 사용
		//multipartFile.transferTo(file);
		
		//2) Spring API FileCopyUtils 객체의 copy메서드 사용
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return name;
		
	}
}
