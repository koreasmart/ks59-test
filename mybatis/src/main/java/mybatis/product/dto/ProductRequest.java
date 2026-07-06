package mybatis.product.dto;

import lombok.Data;

@Data
public class ProductRequest {

	private String productName;
	private Long productUnitPrice;
	private String vendorCode;
	
}
