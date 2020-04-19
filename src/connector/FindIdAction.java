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

@WebServlet("/FindIdAction")
public class FindIdAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM이 'POST'방식일 때
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		System.out.println("connector.FindIdAction servlet running...");
		
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		
		if (userName == null || userGender == null || userEmail == null){
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else {
			//입력 안된 사항이 없다면 미리 userID 당겨오기
			String userID = (new UserDAO()).findId(userName,userGender,userEmail);
			if(userID==null) {
				script.println("<script>");
				script.println("alert('일치하는 아이디가 없습니다.')");
				script.println("history.back()");
				script.println("</script>");
			}else {
				session.setAttribute("userName", userName);
				session.setAttribute("userID", userID);
				response.sendRedirect("findId2.jsp");
			}
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
