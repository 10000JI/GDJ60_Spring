package com.iu.s1.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Service객체 생성
public class ProductService {
	
	@Autowired
	//의존성 주입
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getProductDetail(productDTO);
	}

	public List<ProductDTO> getProductList() throws Exception{
		//ProductService를 통해 DAO 통해 DB 도착 (중간과정 써줌)
		return productDAO.getProductList();
	}
	
	public int setAddProduct (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option
		Long productNUM = productDAO.getProductNum();
		productDTO.setProductNum(productNUM);
		int result = productDAO.setaddProduct(productDTO);
		for(ProductOptionDTO productOptionDTO: ar) {
			productOptionDTO.setProductNum(productNUM);
			result = productDAO.setaddProductOption(productOptionDTO);
		}
		return result;
	}

	
	public static void main(String[] args) {
		// product의 productnum 모를 때, product테이블과 productoption테이블에
		// insert 하는 과정 
		// ProductDAO의 getProductNum() 메소드 사용
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductName("product1");
		productDTO.setProductDetail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
		productOptionDTO.setOptionName("optionName1");
		productOptionDTO.setOptionPrice(100L);
		productOptionDTO.setOptionstock(10L);
		productOptionDTO.setProductNum(null);
		
		ProductOptionDTO productOptionDTO2 = new ProductOptionDTO();
		productOptionDTO2.setOptionName("optionName2");
		productOptionDTO2.setOptionPrice(200L);
		productOptionDTO2.setOptionstock(20L);
		productOptionDTO2.setProductNum(null);
	
		try {
			Long num = productDAO.getProductNum();
			productDTO.setProductNum(num);
			int result = productDAO.setaddProduct(productDTO);
			productOptionDTO.setProductNum(num);
			if(result>0){
				result = productDAO.setaddProductOption(productOptionDTO2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
