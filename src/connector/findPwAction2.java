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

@WebServlet("/findPwAction1")
public class findPwAction2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter script = response.getWriter();
		HttpSession session = request.getSession();
		
		System.out.println("doget메서드");
		String userID = request.getParameter("userID");		
		
		if((new UserDAO()).findID_infindpw(userID)==1) {
			//아이디 정보 존재
			session.setAttribute("userID", userID);
		}else {
			//아이디 정보 없음 
			session.setAttribute("checkID", "false");
		}
		
		response.sendRedirect("findPassword.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}