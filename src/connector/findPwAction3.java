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

@WebServlet("/findPwAction3")
public class findPwAction3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String Ques1aw = (String) session.getAttribute("pwQues1_aw");
		String Ques2aw = (String) session.getAttribute("pwQues2_aw");
		String pwQues1_aw = request.getParameter("pwQues1_aw");
		String pwQues2_aw = request.getParameter("pwQues2_aw");
		
		//답 확인
		if(Ques1aw.equals(pwQues1_aw) && Ques2aw.equals(pwQues2_aw)) {
			response.sendRedirect("findPassword_fin.jsp");
		}else {
			script.println("<script>");
			script.println("alert('답이 옳지 않습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}