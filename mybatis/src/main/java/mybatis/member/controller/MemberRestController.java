package mybatis.member.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.member.dto.SignupRequest;
import mybatis.member.service.MemberService;
/**
 * @Controller 영역 안 handlerMethod는 반환 타입 값이 view 논리경로
 * @RestController : @Controller + @ResponseBody (handlerMethod 반환값)
 */
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {
	
	private final MemberService memberService;
	
	@DeleteMapping("/{id}")
	public boolean deleteMember(@PathVariable(value="id") String mId
								,@RequestBody Map<String, String> requestBody) {
		log.info("탈퇴 회원아이디: {}", mId);
		log.info("탈퇴 회원정보: {}", requestBody);
		return memberService.removeMember(requestBody.get("memberId"), requestBody.get("memberPw"));
	}

	@PostMapping("/{id}")
	public boolean checkId(@PathVariable(value="id") String mId
						   //,@RequestBody Map<String, String> requestBody
						   ,@RequestBody SignupRequest member) {
		boolean isMember = false;
		log.info("주소 전달된 데이터: {}", mId);
		//log.info("요청시 body로 전달된 데이터: {}", requestBody);
		log.info("요청시 body로 전달된 데이터: {}", member);
		
		isMember = memberService.isMemberById(mId);
		
		return isMember; 
	}
}













