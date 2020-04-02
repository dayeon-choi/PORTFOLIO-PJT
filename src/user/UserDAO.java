package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : �����ͺ��̽� ���� ��ü
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "dayeon";
	String pw = "2399";

	public UserDAO() { // ������ ����ɶ����� �ڵ����� db������ �̷�� �� �� �ֵ�����
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// �α����� �õ��ϴ� �޼��� : ȸ�� ���̵�, ��� üũ
	public int login(String userID, String userPassword) {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		int x=-1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("����̹� ���� ����!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("������ ���̽� ���� ����!");
			pstmt.setString(1, userID);//����ǥ�ش��ϴ� ������ �������̵�� 1)�����ϴ��� 2)��й�ȣ��������			
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
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String SQL = "INSERT INTO userlist VALUES(?,?,?,?,?)";
		int x = -1;
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("����̹� ���� ����!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("������ ���̽� ���� ����!");
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
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String s="";     //String SQL���� : userlist���� userName, userGender, userEmail�� ?�� ID��
		String SQL = "SELECT userID FROM userlist WHERE userName = ? AND userGender = ? AND userEmail = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("����̹� ���� ����!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("������ ���̽� ���� ����!");
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