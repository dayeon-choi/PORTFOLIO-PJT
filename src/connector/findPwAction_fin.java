package connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

@WebServlet("/findPwAction_fin")
public class findPwAction_fin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String oldPW = (String)session.getAttribute("userPW");
		String userID = (String)session.getAttribute("userID");
		String newPW = request.getParameter("newPW");
		String newPW_re = request.getParameter("newPW_re");

		//값 검토
		if(oldPW.equals(newPW)){
			script.println("<script>");
			script.println("alert('새 비밀번호는 기존과 일치할 수 없습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else if(!newPW.equals(newPW_re)){
			script.println("<script>");
			script.println("alert('확인 비밀번호가 불일치합니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else {
			
			//데이터베이스에 잘 넣었으면 세션 삭제후 로그인창으로 이동
			if((new UserDAO()).changePW(userID, newPW_re)!=-1){
				session.invalidate(); //해당 세션 삭제
				script.println("<script>");
				script.println("alert('비밀번호 변경을 완료했습니다.')");
				script.println("location.replace('login.jsp')");
				script.println("</script>");
			}
			
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}