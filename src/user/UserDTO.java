package user;
public class UserDTO {//회원데이터 자바빈즈
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	
	//아이디 반환
	public String getUserID() {
		System.out.println("getUserPassword()");
		return userID;
	}
	
	//아이디 set
	public void setUserID(String userID) {
		System.out.println("getUserPassword()");
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
		System.out.println("getUserPassword()");
		return userName;
	}
	
	//이름 set
	public void setUserName(String userName) {
		System.out.println("getUserPassword()");
		this.userName = userName;
	}
	
	//성별 반환
	public String getUserGender() {
		System.out.println("getUserPassword()");
		return userGender;
	}
	
	//성별 set
	public void setUserGender(String userGender) {
		System.out.println("getUserPassword()");
		this.userGender = userGender;
	}
	
	//메일주소 반환
	public String getUserEmail() {
		System.out.println("getUserPassword()");
		return userEmail;
	}
	
	//메일주소 set
	public void setUserEmail(String userEmail) {
		System.out.println("getUserPassword()");
		this.userEmail = userEmail;
	}
	
}
