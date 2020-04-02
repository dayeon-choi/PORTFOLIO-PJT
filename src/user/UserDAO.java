package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : �����ͺ��̽� ���� ��ü
	String url = "jdbc:mysql://localhost:3306/jspproject?serverTimezone=UTC&user=root&password=2399";
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;

	public UserDAO() { // ������ ����ɶ����� �ڵ����� db������ �̷�� �� �� �ֵ�����
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����̹� ���� ����!");
			conn = DriverManager.getConnection(url);
			System.out.println("������ ���̽� ���� ����!");
			stmt = conn.createStatement();
			String usejspproject = "use jspproject;";
			stmt.executeUpdate(usejspproject);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// �α����� �õ��ϴ� �޼��� : ȸ�� ���̵�, ��� üũ
	public int login(String userID, String userPassword) {
		int x=-1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			//����ǥ�ش��ϴ� ������ �������̵�� 1)�����ϴ��� 2)��й�ȣ��������						
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					x=1; return x;//��������
				} else
					x=0; return x;//��й�ȣ ����ġ
			}
			x=-1; //�ش� ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}//end of login()
	
	//ȸ������ �õ��ϴ� �޼���
	public int join(User user) {
		String SQL = "INSERT INTO userlist VALUES(?,?,?,?,?)";
		int x = -1;
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			x=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	//ID�� ã�⸦ �õ��ϴ� �޼���
	public String findId(String userName, String userGender, String userEmail) {
		String s="";     //String SQL���� : userlist���� userName, userGender, userEmail�� ?�� ID��
		String SQL = "SELECT userID FROM userlist WHERE userName = ? AND userGender = ? AND userEmail = ?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,userName);
			pstmt.setString(2,userGender);
			pstmt.setString(3,userEmail);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				s=(rs.getString("userID")); return s;
			}else {
				return null;//�ش� ���̵� ����
			}
						
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}