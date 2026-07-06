package mybatis.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import mybatis.member.domain.Member;

@Data
@AllArgsConstructor
public class MemberResponse {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGrade;
	private String memberAddress;
	private String memberDetailAddress;
	private String memberZip;
	private String memberTelNo;
	private String memberTelNo1;
	private String memberTelNo2;
	private String memberTelNo3;
	private String memberEmail;
	
	public static MemberResponse from(Member member) {
		MemberResponse response = null;
		if( member != null && !"".equals(member.getMemberTelNo())) {
			
			String[] telNo = member.getMemberTelNo().split("-");
			
			response = new MemberResponse(    member.getMemberId()
											, member.getMemberPw()
											, member.getMemberName()
											, member.getMemberGrade()
											, member.getMemberAddress()
											, member.getMemberDetailAddress()
											, member.getMemberZip()
											, member.getMemberTelNo()
											, telNo[0]
											, telNo[1]
											, telNo[2]
											, member.getMemberEmail()  );
		}
		
		return response;	
	}
}








