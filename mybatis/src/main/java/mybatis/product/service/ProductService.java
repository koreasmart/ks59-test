package mybatis.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.order.mapper.OrderMapper;
import mybatis.product.domain.Product;
import mybatis.product.dto.ProductRequest;
import mybatis.product.dto.ProductResponse;
import mybatis.product.mapper.ProductMapper;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductMapper productMapper;
	private final OrderMapper orderMapper;
	
	@Transactional
	public boolean removeProduct(String productCode) {
		int deleteCount = 0;
		// 1. 주문 상세 삭제
		deleteCount += orderMapper.deleteOrderItemsByProductCode(productCode);
		// 2. 주문 삭제
		if(deleteCount > 0) deleteCount += orderMapper.deleteOrderIsNotExistsOrderItems();
		// 3. 상품 삭제
		deleteCount += productMapper.deleteProductByProductCode(productCode);
		
		return deleteCount > 0 ? true : false;
	}
	
	/**
	 * 상품 수정
	 * @param request  변경할 상품정보
	 * @param productCode 변경할 상품코드
	 */
	public void modifyProduct(ProductRequest request, String productCode) {
		Product product = Product.builder()
								 .vendorCode(request.getVendorCode())
								 .productName(request.getProductName())
								 .productUnitPrice(request.getProductUnitPrice())
								 .build();
		int result = productMapper.modifyProduct(product, productCode);
		log.info("수정된 행의 갯수: {}", result);
	}
	
	/**
	 * 상품정보조회
	 * @param productCode
	 * @return ProductResponse 상품정보
	 */
	public ProductResponse getProductInfo(String productCode) {
		var productInfo = productMapper.findByCode(productCode);
		return ProductResponse.from(productInfo);
	}
	
	/**
	 * 상품목록조회
	 * @return List<Product> 상품
	 */
	public List<Product> getProductList(){
		var productList = productMapper.findAll();
		return productList;
	}
	/**
	 * 상품등록
	 * @param request
	 */
	public void addProduct(ProductRequest request) {
		Product registry =  Product.builder()
								   .productName(request.getProductName())
								   .productUnitPrice(request.getProductUnitPrice())
								   .vendorCode(request.getVendorCode())
								   .build();
		int result = productMapper.addProduct(registry);
		
		log.info("등록된 상품 수: {}", result);
		log.info("변경된 Product: {}", registry);
		
	}
	
}












