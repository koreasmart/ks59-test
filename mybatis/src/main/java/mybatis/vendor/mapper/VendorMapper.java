package mybatis.vendor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import mybatis.vendor.domain.Vendor;

@Mapper
public interface VendorMapper {
	// 거래처 상세 목록 조회
	List<Vendor> findAllDetail();
	
	// 거래처 목록 조회
	List<Vendor> findAll();
}
