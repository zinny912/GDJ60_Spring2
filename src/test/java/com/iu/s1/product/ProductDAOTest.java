package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.util.Pagination;

public class ProductDAOTest extends MyTestCase {
	
	@Autowired //주입
	private ProductDAO productDAO; //변수 선언

	@Test // 이거 테스트해주세용
	public void getProductListTest(Pagination pagination) throws Exception {
		List<ProductDTO> ar = productDAO.getProductList(pagination);
		System.out.println(ar.size()>0);
		
		//단정문 
		assertNotEquals(0, ar.size()); //: ar의 사이즈가 0이 아니길 희망합니다.
//		assertEquals(0, ar.size()); //: ar의 사이즈가 0이길 희망합니다.
	}
	
	@Test
	public void getProductDetailTest() throws Exception{
		ProductDTO productDTO = new ProductDTO(); //어떤 데이터가 필요한가? Mapper확인
		productDTO.setProductNum(193L);
		productDTO=productDAO.getProductDetail(productDTO); //매개변수로 productDTO를 사용해야하는데, 해당클래스에는 DTO가 없으므로 가상의 객체를 생성해서 테스트해줘야함
		
		assertNotNull(productDTO); //NotNull이길 희망합니다.
		//assertNull(productDTO);//Null이길 희망합니다.
	}
	
	//insert
	@Test
	public void setProductAddTest() throws Exception{
		
		
		for(int i=0; i<30 ; i++) {
			Random r = new Random();
			double d = r.nextDouble();//0.1234
			int num =(int)d*100;//123
			d=num/10.0;
		
		r.nextDouble();
		ProductDTO productDTO = new ProductDTO();	
		productDTO.setProductName("프로틴"+i);
		productDTO.setProductDetail("득근득근");
		
		
		int result = productDAO.setProductAdd(productDTO);
		}		
		//assertEquals(1, result);
		
	}
	
	
}
