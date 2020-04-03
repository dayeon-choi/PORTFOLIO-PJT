package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : �����ͺ��̽� ���� ��ü
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "minjeong";
	String pw = "jenny8100";
	
	
	public UserDAO() { // ������ ����ɶ����� �ڵ����� db������ �̷�� �� �� �ֵ�����
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// �α����� �õ��ϴ� �޼��� : ȸ�� ���̵�, ��� üũ
	public int login(String userID, String userPassword) {
		System.out.println("user.UserDAO.login() running...");
		
		//���α׷� ����� �뷮�� ȿ���� ���� ���������� ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		int x = -1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			//����ǥ�ش��ϴ� ������ �������̵�� 1)�����ϴ��� 2)��й�ȣ��������						
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { //���(�ݵ�� 1���� ���ڵ�)
				if (rs.getString(1).equals(userPassword)) { //�ش� ID�� ��й�ȣ ����
					x = 1; //�α��� ����[��ȯ]
					
				} else { x = 0; } //��й�ȣ ����ġ
			} else //ID�� ��ȸ���� ����.
				x = -1; //�ش� ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
			x = -2; //�����ͺ��̽� ����
		}finally {
			try { //���� ����
				if(rs!= null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
				x = -2; //�����ͺ��̽� ����
			}
		}
		return x;
	}//end of login()
	
	
	
	//ȸ������ �õ� �޼���
	public int join(UserDTO user) {
		System.out.println("user.UserDAO.join() running...");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		//ID�� �⺻Ű�̱� ������ �ߺ����� ���� ��� �����Ͱ� ���� �ʴ´�.
		String SQL = "INSERT INTO userlist VALUES(?,?,?,?,?,?,?,?,?)";
		
		int x = -1;
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			pstmt.setString(6, user.getPwQues1());
			pstmt.setString(7, user.getPwQues1_aw());
			pstmt.setString(8, user.getPwQues2());
			pstmt.setString(9, user.getPwQues2_aw());
			x = pstmt.executeUpdate(); //������ ����
			System.out.println("DB INSERT query");
			x = 0;
			
		}catch(Exception e) {
			e.printStackTrace();
			x = -1; //DB���� ��ȣ ��ȯ
		}finally {
			try { //���� ����
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			}catch (Exception e2) {
				e2.printStackTrace();
				x = -1; //DB���� ��ȣ ��ȯ
			}
		}
		
		return x;//��� ��ȯ
	}
	
	
	//���̵� ���� ���� Ȯ�� �޼��� (��й�ȣ ã��)
	public int findID_infindpw(String userID) {
		System.out.println("user.UserDAO.findID() running...");
		int sign = -1;
		
		//���α׷� ����� �뷮�� ȿ���� ���� ���������� ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		int x = -1;
		String SQL = "SELECT * FROM userlist WHERE userID = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			//����ǥ�ش��ϴ� ������ �������̵�� 1)�����ϴ��� 2)��й�ȣ��������						
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { //���ڵ� ������ ���
				sign = 1;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			x = -2; //�����ͺ��̽� ����
		}finally {
			try { //���� ����
				if(rs!= null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
				x = -2; //�����ͺ��̽� ����
			}
		}
				
		return sign; //���̵� ������ ��� 1 ��ȯ	
	}
}