package mybatis.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.common.service.CommonService;
import mybatis.member.domain.Member;
import mybatis.member.dto.MemberRequest;
import mybatis.member.dto.SignupRequest;
import mybatis.member.service.MemberService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;
	private final CommonService commonService;
	
	@PostMapping("/modifyMember")
	public String modifyMember(MemberRequest request) {
		
		log.info("회원 수정 데이터: {}", request);
		memberService.modifyMember(request);
		
		return "redirect:/member/memberList";
	}
	
	@GetMapping("/modifyMember")
	public String modifyMemberView( Model model
								   ,@RequestParam(value="memberId") String memberId) {
		var memberInfo = memberService.getMemberInfo(memberId);
		var gradeList = commonService.getCommonCodeListByGroupCode("comm_group_1");
		
		model.addAttribute("title", "회원수정");
		model.addAttribute("memberInfo", memberInfo);
		model.addAttribute("gradeList", gradeList);
		return "member/modifyMemberView";
	}
	
	@PostMapping("/addMember")
	public String signup(SignupRequest signupRequest) {
		
		log.info("회원등록정보: {}", signupRequest);
		memberService.addMeber(signupRequest);
		
		return "redirect:/member/memberList";
	}
	
	@GetMapping("/addMember")
	public String addMemberView(Model model) {
		var gradeList = commonService.getCommonCodeListByGroupCode("comm_group_1");
		
		model.addAttribute("title", "회원등록");
		model.addAttribute("gradeList", gradeList);
		
		return "member/addMemberView";
	}
	
	@GetMapping("/memberList")
	public String memberListView(Model model) {
		
		List<Member> memberList = memberService.getMemberList();
		
		model.addAttribute("title", "회원목록조회");
		model.addAttribute("memberList", memberList);
		
		return "member/memberListView";
	}
}









