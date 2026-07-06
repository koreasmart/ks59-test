package mybatis.vendor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.vendor.service.VendorService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vendor")
@Slf4j
public class VendorController {
	
	private final VendorService vendorService;

	@GetMapping("/vendorList")
	public String vendorListView(Model model) {
		
		model.addAttribute("title", "거래처 상세 목록조회"); 
		model.addAttribute("vendorList", vendorService.getVendorDetailList()); 		
		
		return "vendor/vendorListView";
	}
}













