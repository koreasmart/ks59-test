package mybatis.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Slf4j
public class ProductRestController {
	
	private final ProductService productService;

	@DeleteMapping("/{code}")
	public boolean removeProduct(@PathVariable(name="code") String productCode) {
		log.info("삭제할 상품코드: {}", productCode);
		boolean isDelete = productService.removeProduct(productCode);
		return isDelete;
	}
}


















