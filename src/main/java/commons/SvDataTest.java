package commons;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SvDataTest {
	public static SvDataTest getSvDataTest() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(
					new File(GlobalConstants.PROJECT_PATH + "\\src\\main\\java\\commons\\SocialDataTest.json"),
					SvDataTest.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@JsonProperty("passwordCommon")
	private String passwordCommon;

	public String getPassword() {
		return passwordCommon;
	}

	@JsonProperty("allAccount")
	private String allAccount;

	public String getAllAcc() {
		return allAccount;
	}

	@JsonProperty("managerAccount")
	private String managerAccount;

	public String getManagerAcc() {
		return managerAccount;
	}

	@JsonProperty("managerInfo")
	private String managerInfo;

	public String getManagerInfo() {
		return managerInfo;
	}

	@JsonProperty("memberAccount")
	private String memberAccount;

	public String getMemberAcc() {
		return memberAccount;
	}

	@JsonProperty("memberInfo")
	private String memberInfo;

	public String getMemberInfo() {
		return memberInfo;
	}

	@JsonProperty("memberInTeamAccount")
	private String memberInTeamAccount;

	public String getMemberInTeam() {
		return memberInTeamAccount;
	}

	@JsonProperty("MemberInTeamInfo")
	private String MemberInTeamInfo;

	public String getMemberInTeamInfo() {
		return MemberInTeamInfo;
	}

	@JsonProperty("memberOtherAccount")
	private String memberOtherAccount;

	public String getMemberOtherAcc() {
		return memberOtherAccount;
	}

	@JsonProperty("memberOtherInfo")
	private String memberOtherInfo;

	public String getMemberOtherInfo() {
		return memberOtherInfo;
	}

	@JsonProperty("memberOtherToView")
	private String memberOtherToView;

	public String getMemberOtherToView() {
		return memberOtherToView;
	}

	@JsonProperty("memberOtherViewInfo")
	private String memberOtherViewInfo;

	public String getMemberOtherViewInfo() {
		return memberOtherViewInfo;
	}

	@JsonProperty("memberOtherUser")
	private String memberOtherUser;

	public String getMemberOtherUser() {
		return memberOtherUser;
	}

	@JsonProperty("memberOtherUserInfo")
	private String memberOtherUserInfo;

	public String getMemberOtherUserInfo() {
		return memberOtherUserInfo;
	}

	@JsonProperty("managerTeam")
	private String managerTeam;

	public String getManagerTeam() {
		return managerTeam;
	}

	@JsonProperty("userTeam")
	private String userTeam;

	public String getUserTeam() {
		return userTeam;
	}

}
