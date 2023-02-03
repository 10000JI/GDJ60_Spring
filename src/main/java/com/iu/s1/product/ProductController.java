package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	//의존성 주입
	private ProductService productService;
	
	@RequestMapping(value="list")
	public String getProductList() throws Exception  {
		List<ProductDTO> ar  = productService.getProductList();
		System.out.println(ar.size()>0);
		return "product/productList";
	}
	
	//getProductDetail
	@RequestMapping(value="productDetail")
	public String getProductDetail() {
		return "product/productDetail";
	}
	
	//getProductAdd
	@RequestMapping(value="productAdd")
	public void getProductAdd() {
		
	}
	
	@RequestMapping(value="update")
	public ModelAndView getProductUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;
	}
	
}
