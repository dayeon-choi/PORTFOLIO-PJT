package user;
public class UserDTO {//ȸ�������� �ڹٺ���
	
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	private String pwQues1, pwQues1_aw, pwQues2, pwQues2_aw;
	
	//������(�ʱ�ȭ��)
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
	
	//���̵� ��ȯ
	public String getUserID() {
		System.out.println("getUserID()");
		return userID;
	}
	
	//���̵� set
	public void setUserID(String userID) {
		System.out.println("setUserID()");
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
		System.out.println("getUserName()");
		return userName;
	}
	
	//�̸� set
	public void setUserName(String userName) {
		System.out.println("setUserName()");
		this.userName = userName;
	}
	
	//���� ��ȯ
	public String getUserGender() {
		System.out.println("getUserGender()");
		return userGender;
	}
	
	//���� set
	public void setUserGender(String userGender) {
		System.out.println("setUserGender()");
		this.userGender = userGender;
	}
	
	//�����ּ� ��ȯ
	public String getUserEmail() {
		System.out.println("getUserEmail()");
		return userEmail;
	}
	
	//�����ּ� set
	public void setUserEmail(String userEmail) {
		System.out.println("setUserEmail()");
		this.userEmail = userEmail;
	}

	//����1 ��ȯ
	public String getPwQues1() {
		return pwQues1;
	} //����1 �� ��ȯ
	public String getPwQues1_aw() {
		return pwQues1_aw;
	}
	
	//����1 ����
	public void setPwQues1(String pwQues1, String pwQues1_aw) {
		this.pwQues1 = pwQues1;
		this.pwQues1_aw = pwQues1_aw;
	}

	//����2 ��ȯ
	public String getPwQues2() {
		return pwQues2;
	}//����2 �� ��ȯ
	public String getPwQues2_aw() {
		return pwQues2_aw;
	}
	
	//����2 ����
	public void setPwQues2(String pwQues2, String pwQues2_aw) {
		this.pwQues2 = pwQues2;
		this.pwQues2_aw = pwQues2_aw;
	}

	@Override
	public String toString() {
		return "�� ���� [userID=" + userID + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userGender=" + userGender + ", userEmail=" + userEmail + ", pwQues1=" + pwQues1 + ", pwQues1_aw="
				+ pwQues1_aw + ", pwQues2=" + pwQues2 + ", pwQues2_aw=" + pwQues2_aw + "]";
	}


	
	
	
}
