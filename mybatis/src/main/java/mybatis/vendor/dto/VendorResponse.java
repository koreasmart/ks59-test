package mybatis.vendor.dto;

import lombok.Data;
import mybatis.vendor.domain.Vendor;

@Data
public class VendorResponse {

	private String vendorCode;
	private String vendorName;
	
	public VendorResponse() {}
	
	public VendorResponse(String vendorCode, String vendorName) {
		this.vendorCode = vendorCode;
		this.vendorName = vendorName;
	}
	
	// 정적 팩토리 메소드 - 변환로직
	public static VendorResponse from(Vendor vendor) {
		return new VendorResponse (
			 vendor.getVendorCode()
			,vendor.getVendorName()
		);
	}
	
}
