package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;
import com.iu.s1.util.Pagination;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum)throws Exception{	
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
			
	//getMax
	public Long getProductNum()throws Exception{
	//SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL
		return sqlSession.selectOne(NAMESPACE+"getProductNum");
		
	}
	
	//--------------------------------------
	public List<ProductOptionDTO> getProductOptionList()throws Exception{
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptinDTO = new ProductOptionDTO();
			productOptinDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptinDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptinDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptinDTO.setOptionPrice(rs.getLong("OPTIONPRICE"));
			productOptinDTO.setOptionAmount(rs.getLong("OPTIONAMOUNT"));
			ar.add(productOptinDTO);
		}
		
		DBConnection.disConnection(rs,  st, con);
		
		return ar;
		}
	
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql="INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONAMOUNT) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setLong(3, productOptionDTO.getOptionPrice());
		st.setLong(4, productOptionDTO.getOptionAmount());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
		
	//--------------------------------------
	
	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}
	
	
	public Long getProductCount(Pagination pagination) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductCount", pagination);
	}
	
	
	public List<ProductDTO> getProductList(Pagination pagination)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductList", pagination);
	}
	
	public int setProductAdd(ProductDTO productDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
	}
	
}