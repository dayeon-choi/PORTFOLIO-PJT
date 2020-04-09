package connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;

@WebServlet("/findPwAction2")
public class findPwAction2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String userID = (String)session.getAttribute("userID");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		
		UserDAO temp = new UserDAO();
		
		//정보맞는지 확인
		String sign = temp.findInfo_infindpw(userID, userName, userEmail);
		
		if(sign.equals("er")) {
			script.println("<script>");
			script.println("alert('정보가 일치하지 않습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(sign.equals("erd")) {
			script.println("<script>");
			script.println("alert('데이터베이스 오류입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else {
			session.setAttribute("userPW", sign);
			session.setAttribute("userName", userName);
			session.setAttribute("userEmail", userEmail);
			
			//해당 아이디의 질문과 답 가져오기(DB) session에 저장
			temp.getQuestions(userID);
			session.setAttribute("pwQues1", temp.pwQues1);
			session.setAttribute("pwQues1_aw", temp.pwQues1_aw);
			session.setAttribute("pwQues2", temp.pwQues2);
			session.setAttribute("pwQues2_aw", temp.pwQues2_aw);
			
			System.out.println("유저 패스워드 setAtt: "+session.getAttribute("userPW"));
			response.sendRedirect("findPassword3.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}