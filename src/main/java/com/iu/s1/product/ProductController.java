package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list")
	public ModelAndView getProuctList(ModelAndView mv) throws Exception {
		List<ProductDTO> ar = productService.getProductList();
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		return mv;
	}
}
