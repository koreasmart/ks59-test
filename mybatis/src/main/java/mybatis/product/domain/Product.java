package mybatis.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private String productCode;
	private String vendorCode;
	private String productName;
	private Long productUnitPrice;
	private String productRegDate;
}
