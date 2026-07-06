package mybatis.vendor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.vendor.domain.Vendor;
import mybatis.vendor.dto.VendorResponse;
import mybatis.vendor.mapper.VendorMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorService {

	private final VendorMapper vendorMapper;
	
	/**
	 * 거래처 상세목록 조회
	 */
	public List<Vendor> getVendorDetailList() {
		var vendorList = vendorMapper.findAllDetail();
		log.info("거래처 상세 목록 사이즈: {}", vendorList.size());
		log.info("거래처 상세 목록 조회: {}", vendorList);
		return vendorList;
	}
	
	/**
	 * 거래처 목록 조회
	 * @return VendorResponse 거래처
	 */
	@Transactional
	public List<VendorResponse> getVendorList(){
		var vendorList = vendorMapper.findAll();
		
		return vendorList.stream()
						 .map(VendorResponse :: from)
						 .collect(Collectors.toList());
		
	}
}
























