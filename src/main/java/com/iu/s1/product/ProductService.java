package com.iu.s1.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	// Service는 DAO에 의존적이라 멤버변수 선언
	private ProductDAO productDAO = new ProductDAO ( );
	
	{
		this.productDAO=new ProductDAO();
		
	}
	
	public void ProductService( ) {
		this.productDAO = new ProductDAO();
		
	}

	// 결합도가 낮다(약하다)
	public void setProductDAO(ProductDAO productDAO) {
				this.productDAO=productDAO;
	}
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	
	
	public List<ProductDTO> getProductList() throws Exception {
		return productDAO.getProductList();
	
	}

	//결합도가 높다(강하다)
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception{
			//product, option
			Long productNum = productDAO.getProductNum( );
			productDTO.setProductNum(productNum);
			int result = productDAO.setProductAdd(productDTO);

		if(ar != null) {	
			for(ProductOptionDTO productOptionDTO : ar ) {
			productOptionDTO.setProductOptionNum(productNum);
			result = productDAO.setProductOptionAdd(productOptionDTO);
			}
		}
			return result;
	}

	

}
