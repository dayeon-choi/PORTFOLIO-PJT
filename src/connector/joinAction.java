package connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDAO;
import user.UserDTO;

@WebServlet("/joinAction")
public class joinAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter script = response.getWriter();
		System.out.println("connector.joinAction servlet running...");
		
		//login.jsp 파일에서 입력받은 아이디, 비밀번호
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String pwQues1 = request.getParameter("pwQues1");
		String pwQues1_aw = request.getParameter("pwQues1_aw");
		String pwQues2 = request.getParameter("pwQues2");
		String pwQues2_aw = request.getParameter("pwQues2_aw");
		

		if (userID=="" || userPW=="" || userName=="" || userGender=="" || userEmail=="" 
				|| pwQues1=="" || pwQues1_aw=="" || pwQues2=="" || pwQues2_aw==""){
			//입력안된 정보가 하나라도 있을 시
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
			
		}else{
			
			//데이터베이스 접근 전 비밀번호 양식 검사
			
			
			UserDAO userDAO = new UserDAO();//인스턴스 생성
			//user_temp
			UserDTO user_t = new UserDTO(userID, userPW, userName, userGender, userEmail, 
					pwQues1, pwQues1_aw, pwQues2, pwQues2_aw);
			
			int result = userDAO.join(user_t); //데이터베이스 삽입
			//join함수내에서 자동으로 중복값이 걸러짐.(중복값이 있는경우 튕김)
			if(result==-1){
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디 입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}else{//가입 성공
				System.out.println("Completed - connector.joinAction servlet");
				System.out.println(user_t);
				script.println("<script>");
				script.println("alert('회원가입이 완료되었습니다. 로그인 창으로 이동합니다.')"); //작동 안됨
				script.println("location.replace('login.jsp')");
				script.println("</script>");
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
