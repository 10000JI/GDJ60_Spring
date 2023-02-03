package com.iu.s1.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	//의존성 주입
	private ProductService productService;
	
	@RequestMapping(value="list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception  {
		//모델에 담는 방법 (request 대신)
		//1. 매개변수를 모델에 담음
		//2. 모델과 뷰가 합쳐서 보냄
		
		//DispactureServlet이 mv = new ModelAndView 자동으로 해줌
		//ModelAndView mv = new ModelAndView(); //매개변수로 선언되어 받음
		
		//같은 참조변수의 값이 다른게 여러개가 파라미터를 받아야된다면 매개변수에 배열로 받는다
		//Spring에서 대신 해준다.
		
		List<ProductDTO> ar  = productService.getProductList();
		System.out.println(ar.size()>0);
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		System.out.println(ar.get(0).getProductName());
		return mv;
	}
	
	//getProductDetail
	@RequestMapping(value="detail")
	public String getProductDetail(ProductDTO productDTO, Model model) throws Exception {
		//Model: 서버에서 만든데이터를 model에 담아 jsp까지 보냄 
		
		//productDTO의 동일한 변수가 있는지 찾아보고 알아서 대입해줌(URL로 요청한 매개변수 이름이 ProductDTO의 매개변수이름과 동일 = productNum)
		//= 파라미터 이름과 setter의 매개변수 이름과 같아야 함
		
		//int에 null이 들어올 수 있으므로 Integer 선언 (null을 int로 변환 가능해서)
		//Dynamic Web project에서 했던 request 값 받는 것을 spring은 대신 해줌
		//getParameter(받는 파라미터 값)을 동일한 변수와 동일한 타입으로 매개변수에 넣어준다
	     
		//1. 내장객체(HttpRequestServlet) 받아서 getParameter
		//2. (url의) 파라미터에서 primitive , String, Integer 등을 받음
		//3. (url의) 파라미터에서 DTO를 받음(자동) 
		System.out.println("Product Detail");
		//String num = request.getParameter("num");
		
		//ProductDTO productDTO = new ProductDTO();
		//productDTO.setProductNum(num);
		productDTO = productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("dto",productDTO);
		
		return "product/productDetail";
		//return은 view
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
