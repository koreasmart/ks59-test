package mybatis.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mybatis.member.domain.Member;

/**
 * @Mapper : repository(DAO) + xml 파일과 매핑해주는 어노테이션
 */
@Mapper
public interface MemberMapper {
	// 회원탈퇴 - 프로시저 호출
	void callRemoveMember(@Param("memberId") String memberId, @Param("status") Map<String, Object> status);
	
	// 특정회원 수정
	int modifyMember(Member member);
	
	// 특정회원 조회
	Member findById(@Param("memberId") String memberId);
	
	// 회원등록
	int addMember(Member member);
	
	// 아이디중복체크
	boolean checkMemberById(@Param("memberId") String memberId);
	
	// 회원목록 조회
	List<Member> findAll();
}
