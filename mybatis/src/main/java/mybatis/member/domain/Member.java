package mybatis.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGrade;
	private String memberAddress;
	private String memberDetailAddress;
	private String memberZip;
	private String memberTelNo;
	private String memberEmail;
	private String memberRegDate;
}
