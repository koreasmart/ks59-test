package mybatis.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.product.dto.ProductRequest;
import mybatis.product.service.ProductService;
import mybatis.vendor.service.VendorService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
	
	private final ProductService productService;
	private final VendorService vendorService; 
		
	@PostMapping("/modifyProduct")
	public String modifyProduct(@RequestParam(value="productCode") String productCode
			                    ,ProductRequest request) {
		log.info("변경할 상품코드: {}", productCode);
		log.info("변경할 상품정보: {}", request);
		
		productService.modifyProduct(request, productCode);
		
		return "redirect:/product/productList";
	}
	
	@GetMapping("/modifyProduct")
	public String modifyProductView( Model model
									,@RequestParam(value="productCode") String productCode) {
		var productInfo = productService.getProductInfo(productCode);
		var vendorList = vendorService.getVendorList();
		
		model.addAttribute("title", "상품수정");
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("vendorList", vendorList);
		
		return "product/modifyProductView";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(ProductRequest request) {
		log.info("입력한 상품정보: {}", request);
		productService.addProduct(request);
		return "redirect:/product/productList";
	}
	
	@GetMapping("/addProduct")
	public String addProductView(Model model) {
		
		var vendorList = vendorService.getVendorList();
		
		model.addAttribute("title", "상품등록");
		model.addAttribute("vendorList", vendorList);
		
		return "product/addProductView";
	}

	@GetMapping("/productList")
	public String productListView(Model model) {
		
		var productList = productService.getProductList();
		
		model.addAttribute("title", "상품목록조회");
		model.addAttribute("productList", productList);
		
		return "product/productListView";
	}
}












