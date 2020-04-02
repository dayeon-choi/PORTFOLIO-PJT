package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : 데이터베이스 접근 객체
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "dayeon";
	String pw = "2399";

	public UserDAO() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인을 시도하는 메서드 : 회원 아이디, 비번 체크
	public int login(String userID, String userPassword) {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		int x=-1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("드라이버 연결 성공!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("데이터 베이스 접속 성공!");
			pstmt.setString(1, userID);//물음표해당하는 내용을 유저아이디로 1)존재하는지 2)비밀번호무엇인지			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					x=1; return x;//인증성공
				} else
					x=0; return x;//비밀번호 불일치
			}
			x=-1; //해당 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}//end of login()
	
	//회원가입 시도하는 메서드
	public int join(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String SQL = "INSERT INTO userlist VALUES(?,?,?,?,?)";
		int x = -1;
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("드라이버 연결 성공!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("데이터 베이스 접속 성공!");
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
	
	//ID를 찾기를 시도하는 메서드
	public String findId(String userName, String userGender, String userEmail) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String s="";     //String SQL설명 : userlist에서 userName, userGender, userEmail이 ?인 ID값
		String SQL = "SELECT userID FROM userlist WHERE userName = ? AND userGender = ? AND userEmail = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("드라이버 연결 성공!");
			pstmt = conn.prepareStatement(SQL);
			System.out.println("데이터 베이스 접속 성공!");
			pstmt.setString(1,userName);
			pstmt.setString(2,userGender);
			pstmt.setString(3,userEmail);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				s=(rs.getString("userID")); return s;
			}else {
				return null;//해당 아이디가 없음
			}
						
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
}