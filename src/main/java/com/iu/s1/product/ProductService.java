package com.iu.s1.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

@Service
//Service객체 생성
public class ProductService {
	
	@Autowired
	//의존성 주입
	private ProductDAO productDAO;
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		return productDAO.getProductDetail(productDTO);
	}

	public List<ProductDTO> getProductList(Pager pager) throws Exception{
		//ProductService를 통해 DAO 통해 DB 도착 (중간과정 써줌)
		Long totalCount = productDAO.getProductCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return productDAO.getProductList(pager);
	}
	
	public int setProductAdd (ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option
		Long productNUM = productDAO.getProductNum();
		productDTO.setProductNum(productNUM);
		int result = productDAO.setProductAdd(productDTO);
		
		if (ar != null) {
			for (ProductOptionDTO productOptionDTO : ar) {
				productOptionDTO.setProductNum(productNUM);
				result = productDAO.setaddProductOption(productOptionDTO);
			}
		}
		return result;
	}

}
