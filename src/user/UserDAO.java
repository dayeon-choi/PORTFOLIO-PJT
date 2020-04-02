package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {// dao : 데이터베이스 접근 객체
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "minjeong";
	String pw = "jenny8100";
	
	
	public UserDAO() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 로그인을 시도하는 메서드 : 회원 아이디, 비번 체크
	public int login(String userID, String userPassword) {
		System.out.println("user.UserDAO.login() running...");
		
		//프로그램 실행시 용량과 효율에 따라 지역변수로 선언
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		int x = -1;
		String SQL = "SELECT userPassword FROM userlist WHERE userID = ?";
		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			//물음표해당하는 내용을 유저아이디로 1)존재하는지 2)비밀번호무엇인지						
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { //결과(반드시 1개의 레코드)
				if (rs.getString(1).equals(userPassword)) { //해당 ID의 비밀번호 대조
					x = 1; //로그인 성공[반환]
					
				} else { x = 0; } //비밀번호 불일치
			} else //ID값 조회값이 없음.
				x = -1; //해당 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
			x = -2; //데이터베이스 오류
		}finally {
			try { //연결 해제
				if(rs!= null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
				x = -2; //데이터베이스 오류
			}
		}
		return x;
	}//end of login()
	
	
	
	//회원가입 시도 메서드
	public int join(UserDTO user) {
		System.out.println("user.UserDAO.join() running...");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		//ID가 기본키이기 때문에 중복값이 있을 경우 데이터가 들어가지 않는다.
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
			x = pstmt.executeUpdate(); //정상결과 대입
			System.out.println("DB INSERT query");
			x = 0;
			
		}catch(Exception e) {
			e.printStackTrace();
			x = -1; //DB오류 신호 반환
		}finally {
			try { //연결 해제
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			}catch (Exception e2) {
				e2.printStackTrace();
				x = -1; //DB오류 신호 반환
			}
		}
		
		return x;//결과 반환
	}
}