package mybatis.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.member.domain.Member;
import mybatis.member.dto.MemberRequest;
import mybatis.member.dto.MemberResponse;
import mybatis.member.dto.SignupRequest;
import mybatis.member.mapper.MemberMapper;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	/**
	 * 회원 탈퇴
	 * @param memberId
	 * @param memberPw
	 */
	public boolean removeMember(String memberId, String memberPw) {
		Boolean isDel = false;
		Map<String, Object> status = new HashMap<String, Object>();
		status.put("isDel", false);
		var memberInfo = memberMapper.findById(memberId);
		if(memberInfo != null && memberPw.equals(memberInfo.getMemberPw())) {
			memberMapper.callRemoveMember(memberId, status);
			isDel = (boolean) status.get("isDel");
		}
		log.info("삭제여부: {}", isDel);
		return isDel;
	}

	/**
	 * 회원 수정
	 * @param request 회원수정정보
	 */
	public void modifyMember(MemberRequest request) {
		Member member = Member.builder()
							  .memberId(request.getMemberId())
							  .memberPw(request.getMemberPw())
							  .memberGrade(request.getMemberGrade())
							  .memberName(request.getMemberName())
							  .memberAddress(request.getMemberAddress())
							  .memberDetailAddress(request.getMemberDetailAddress())
							  .memberZip(request.getMemberZip())
							  .memberTelNo(request.getMemberTelNo())
							  .memberEmail(request.getMemberEmail())
							  .build();
		int result = memberMapper.modifyMember(member);
		log.info("수정된 행의 갯수: {}", result);
	}
	
	/**
	 * 아이디 중복체크
	 * @param memberId
	 * @return
	 */
	public boolean isMemberById(String memberId) {
		boolean isMember = memberMapper.checkMemberById(memberId);
		return isMember;
	}
	
	/**
	 * 회원 정보 조회
	 * @param memberId
	 * @return MemberResponse 회원정보
	 */
	public MemberResponse getMemberInfo(String memberId) {
		var memberInfo = memberMapper.findById(memberId);
		return MemberResponse.from(memberInfo);
	}
	
	/**
	 * 회원 등록
	 * @param request (사용자 입력한 회원정보)
	 */
	public void addMeber(SignupRequest request) {
		Member registry = Member.builder()
								.memberId(request.getMemberId())
								.memberPw(request.getMemberPw())
								.memberName(request.getMemberName())
								.memberGrade(request.getMemberGrade())
								.memberAddress(request.getMemberAddress())
								.memberDetailAddress(request.getMemberDetailAddress())
								.memberZip(request.getMemberZip())
								.memberTelNo(request.getMemberTelNo())
								.memberEmail(request.getMemberEmail())
								.build();
		
		int result = memberMapper.addMember(registry);
		
		log.info("회원등록 수: {}", result);
			
	}
	
	/**
	 * 회원목록 조회
	 * @return List<Member> 회원
	 */
	public List<Member> getMemberList(){
		List<Member> memberList = memberMapper.findAll();
		//log.info("회원목록: {}", memberList);
		return memberList;
	}
}









