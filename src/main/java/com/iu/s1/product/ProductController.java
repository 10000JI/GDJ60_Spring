package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		productDTO = productService.getProductDetail(productDTO);
		System.out.println(productDTO != null);
		model.addAttribute("detail",productDTO);
		return "product/productDetail";
	}
	
	
	@RequestMapping(value="productAdd", method=RequestMethod.GET)
	public void getProductadd(){

	}
	
	@RequestMapping(value="productAdd", method=RequestMethod.POST)
	public String getProductAdd(ProductDTO productDTO) throws Exception{
		int result = productService.setAddProduct(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";
	}
	
//	@RequestMapping
//	public String getProductUpdate() {
//		productService.
//	}
	
}
