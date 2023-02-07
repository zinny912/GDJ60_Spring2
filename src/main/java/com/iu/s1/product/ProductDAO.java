package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	
	
	//delete					원래는 매개변수 DTO로 받는게 훨씬 낫다
	public int setProductDelete(Long productNum) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	
	
	
	//getMax
	public Long getProductNum() throws Exception {
		//SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL
		return sqlSession.selectOne(NAMESPACE+"getProductNum");
		
	}
		
	
//-----------------------------------------------------------	
	public List<ProductOptionDTO> getOptionList() throws Exception {
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		return ar;
		
	}
	
	
	public int setProductOptionAdd(ProductOptionDTO productOptionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK)"
				+ " VALUES(PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getProductOptionName());
		st.setLong(3, productOptionDTO.getProductOptionPrice());
		st.setLong(4, productOptionDTO.getProductOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
//------------------------------------------------------------------	
	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
	
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		
	}
	
		
	public List<ProductDTO> getProductList ()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	
	//setAddProduct
	public int setProductAdd(ProductDTO productDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
		
	}
	
}	