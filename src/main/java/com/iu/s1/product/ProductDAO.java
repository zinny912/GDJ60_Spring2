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
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";

		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, connection);
		
		return num;
		
	}
		
	
//-----------------------------------------------------------	
	public List<OptionDTO> getOptionList() throws Exception {
		ArrayList<OptionDTO> ar = new ArrayList<OptionDTO>();
		
		return ar;
		
	}
	
	
	public int setAddOption(OptionDTO optionDTO) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK)"
				+ " VALUES(PRODUCTOPTION_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setLong(1, optionDTO.getProductNum());
		st.setString(2, optionDTO.getOptionName());
		st.setLong(3, optionDTO.getOptionPrice());
		st.setLong(4, optionDTO.getOptionStock());
		
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
	public int setAddProduct(ProductDTO productDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setAddProduct", productDTO);
		
	}
	
}	