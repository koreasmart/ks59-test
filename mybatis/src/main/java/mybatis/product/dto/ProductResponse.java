package mybatis.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mybatis.product.domain.Product;

@Data
@AllArgsConstructor
public class ProductResponse {
	private String productCode;
	private String vendorCode;
	private String productName;
	private Long productUnitPrice;
	
	public static ProductResponse from (Product product) {
		return new ProductResponse(  product.getProductCode()
								    , product.getVendorCode()
								    , product.getProductName()
								    , product.getProductUnitPrice());
	}
}
