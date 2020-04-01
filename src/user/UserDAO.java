package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : 데이터베이스 접근 객체
	String url = "jdbc:mysql://localhost:3307/jspproject?serverTimezone=UTC&user=root&password=jenny8100";
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs = null;

	public UserDAO() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 연결 성공!");
			conn = DriverManager.getConnection(url);
			System.out.println("데이터 베이스 접속 성공!");
			stmt = conn.createStatement();
			String usejspproject = "use jspproject;";
			stmt.executeUpdate(usejspproject);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인을 시도하는 메서드 : 회원 아이디, 비번 체크
	public int login(String userID, String userPassword) {
		int x = -1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			//물음표해당하는 내용을 유저아이디로 1)존재하는지 2)비밀번호무엇인지						
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					x = 1; //인증성공
					return x;
				} else x = 0; //비밀번호 불일치
					return x;
			}
			
			x = -1; //해당 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}//end of login()
	
	
	//회원가입 시도하는 메서드
	public int join(UserDTO user) {
		//ID가 기본키이기 때문에 중복값이 있을 경우 데이터가 들어가지 않는다.
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
			x = -1; //오류 신호 반환
		}
		return x;
	}
}