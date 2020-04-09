package connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDAO;

@WebServlet("/loginAction")
public class loginAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter script = response.getWriter();
		System.out.println("connector.loginAction servlet running...");
		
		//login.jsp 파일에서 입력받은 아이디, 비밀번호
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPassword");		
		UserDAO userDAO = new UserDAO(); //인스턴스생성
		
		//로그인 테스트 [DAO 연결]
		int result = userDAO.login(userID, userPW);
		
		if(result == 1){ //로그인 성공			
			System.out.println("Completed - connector.loginAction servlet");
			response.sendRedirect("main.jsp");
		}
		else if(result == 0 || result == -1){//로그인 실패[ID 또는 PW 불일치]
			script.println("<script>");
			script.println("alert('아이디 또는 비밀번호가 일치하지 않습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}		
		else if(result == -2){//DB오류
			script.println("<script>");
			script.println("alert('DB오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
