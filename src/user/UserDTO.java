package user;
public class UserDTO {//ȸ�������� �ڹٺ���
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	
	//���̵� ��ȯ
	public String getUserID() {
		System.out.println("getUserPassword()");
		return userID;
	}
	
	//���̵� set
	public void setUserID(String userID) {
		System.out.println("getUserPassword()");
		this.userID = userID;
	}
	
	//��й�ȣ ��ȯ
	public String getUserPassword() {
		System.out.println("getUserPassword()");
		return userPassword;
	}
	
	//��й�ȣ set
	public void setUserPassword(String userPassword) {
		System.out.println("setUserPassword()");
		this.userPassword = userPassword;
	}
	
	//�̸� ��ȯ
	public String getUserName() {
		System.out.println("getUserPassword()");
		return userName;
	}
	
	//�̸� set
	public void setUserName(String userName) {
		System.out.println("getUserPassword()");
		this.userName = userName;
	}
	
	//���� ��ȯ
	public String getUserGender() {
		System.out.println("getUserPassword()");
		return userGender;
	}
	
	//���� set
	public void setUserGender(String userGender) {
		System.out.println("getUserPassword()");
		this.userGender = userGender;
	}
	
	//�����ּ� ��ȯ
	public String getUserEmail() {
		System.out.println("getUserPassword()");
		return userEmail;
	}
	
	//�����ּ� set
	public void setUserEmail(String userEmail) {
		System.out.println("getUserPassword()");
		this.userEmail = userEmail;
	}
	
}
