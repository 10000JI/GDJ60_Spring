package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iu.s1.util.DBConnection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	//어느 Mapper를 쓸 것인지 명시
	//변수명은 Mapper의 namespace와 동일하게 + . 
	private final String NAMESPACE = "com.iu.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum) throws Exception {
		return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
	}
	
	//getMax
	public Long getProductNum() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getProductNum");
	}
	
//---------------------------------------------------------------------------
//productoption
	public List<ProductOptionDTO> getProductOptionList() throws Exception{
		Connection connection = DBConnection.getConnection();
		ArrayList<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		String sql = "SELECT * FROM PRODUCTOPTION";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getLong("OPTIONPRICE"));
			productOptionDTO.setOptionstock(rs.getLong("OPTIONSTOCK"));
			ar.add(productOptionDTO);
		}
		DBConnection.disConnection(rs, st, connection);
		return ar;
	} 
	
	public int setaddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTOPTION(OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONSTOCK)"
				+ " VALUES (PTOPTION_SEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setLong(3, productOptionDTO.getOptionPrice());
		st.setLong(4, productOptionDTO.getOptionstock());
		int result = st.executeUpdate();
		DBConnection.disConnection(st, connection);
		return result;
	}
//-------------------------------------------------------------------------------------
//product
	public List<ProductDTO> getProductList() throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception {
		
		//결과값이 1개 또는 0개 나오므로 selectOne 메소드
		//proudctNum을 보내줘야 하므로 productDTO 전체 보내주자(mybatis가 알아서 처리)
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
	}

//setAddProduct
	public int setProductAdd(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setProductAdd", productDTO);
	}
}
