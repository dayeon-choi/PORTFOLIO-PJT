package user;
public class UserDTO {//회원데이터 자바빈즈
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	private String pwQues1, pwQues1_aw, pwQues2, pwQues2_aw;
	
	//생성자(초기화용)
	public UserDTO(String Id, String Pw, String name, String gender, 
			String email, String pwQues1, String pwQues1_aw, 
			String pwQues2, String pwQues2_aw) {
		this.userID = Id;
		this.userPassword = Pw;
		this.userName = name;
		this.userGender = gender;
		this.userEmail = email;
		this.pwQues1 = pwQues1;
		this.pwQues1_aw = pwQues1_aw;
		this.pwQues2 = pwQues2;
		this.pwQues2_aw = pwQues2_aw;
	}
	
	//아이디 반환
	public String getUserID() {
		System.out.println("getUserID()");
		return userID;
	}
	
	//아이디 set
	public void setUserID(String userID) {
		System.out.println("setUserID()");
		this.userID = userID;
	}
	
	//비밀번호 반환
	public String getUserPassword() {
		System.out.println("getUserPassword()");
		return userPassword;
	}
	
	//비밀번호 set
	public void setUserPassword(String userPassword) {
		System.out.println("setUserPassword()");
		this.userPassword = userPassword;
	}
	
	//이름 반환
	public String getUserName() {
		System.out.println("getUserName()");
		return userName;
	}
	
	//이름 set
	public void setUserName(String userName) {
		System.out.println("setUserName()");
		this.userName = userName;
	}
	
	//성별 반환
	public String getUserGender() {
		System.out.println("getUserGender()");
		return userGender;
	}
	
	//성별 set
	public void setUserGender(String userGender) {
		System.out.println("setUserGender()");
		this.userGender = userGender;
	}
	
	//메일주소 반환
	public String getUserEmail() {
		System.out.println("getUserEmail()");
		return userEmail;
	}
	
	//메일주소 set
	public void setUserEmail(String userEmail) {
		System.out.println("setUserEmail()");
		this.userEmail = userEmail;
	}

	//질문1 반환
	public String getPwQues1() {
		return pwQues1;
	} //질문1 답 반환
	public String getPwQues1_aw() {
		return pwQues1_aw;
	}
	
	//질문1 수정
	public void setPwQues1(String pwQues1, String pwQues1_aw) {
		this.pwQues1 = pwQues1;
		this.pwQues1_aw = pwQues1_aw;
	}

	//질문2 반환
	public String getPwQues2() {
		return pwQues2;
	}//질문2 답 반환
	public String getPwQues2_aw() {
		return pwQues2_aw;
	}
	
	//질문2 수정
	public void setPwQues2(String pwQues2, String pwQues2_aw) {
		this.pwQues2 = pwQues2;
		this.pwQues2_aw = pwQues2_aw;
	}

	@Override
	public String toString() {
		return "새 유저 [userID=" + userID + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userGender=" + userGender + ", userEmail=" + userEmail + ", pwQues1=" + pwQues1 + ", pwQues1_aw="
				+ pwQues1_aw + ", pwQues2=" + pwQues2 + ", pwQues2_aw=" + pwQues2_aw + "]";
	}


	
	
	
}
