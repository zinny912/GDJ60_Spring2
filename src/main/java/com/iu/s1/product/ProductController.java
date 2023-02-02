package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// /product/list -- /product/add -- /product/update -- /product/delete -- /product/detail

	@RequestMapping(value = "list")
	public String getProductList() throws Exception {
		
		List<ProductDTO> ar =productService.getProductList();
		
		System.out.println(ar.size()>0);
		
		return "product/productList";
	}
	
	@RequestMapping(value = "detail")
	public String getProductDetail() {
		System.out.println("Product Detail");
		return  "product/productDetail";
	}
	
	//URL경로랑 JSP이름이 같으면 void로 해도 연결이 됨
	@RequestMapping(value = "productAdd")
	public void getProductAdd() {
	}
	
	//JSP경로명을 담아서 리턴
	@RequestMapping(value = "update")
	public ModelAndView getProductUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
}
