package mybatis.vendor.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybatis.member.domain.Member;
import mybatis.product.domain.Product;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {

	private String vendorCode;
	private String vendorMemberId;
	private String vendorBrno;
	private String vendorName;
	private String vendorAddress;
	private String vendorDAddress;
	private String vendorZip;
	private String vendorTelNo;
	
	// 1:1 관계
	private Member memberInfo;
	// 1:N 관계
	private List<Product> productList;

}












