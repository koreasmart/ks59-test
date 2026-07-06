package mybatis.member.dto;

import lombok.Data;

@Data
public class MemberRequest {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGrade;
	private String memberAddress;
	private String memberDetailAddress;
	private String memberZip;
	private String memberTelNo;
	private String memberEmail;
}
