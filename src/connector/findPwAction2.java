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
		request.setCharacterEncoding("UTF-8"); //FORM�� 'POST'����� ��
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		UserDAO temp = new UserDAO();
		
		String sign = temp.findInfo_infindpw((String)session.getAttribute("userID"), userName, userEmail);
		
		if(!(sign.equals(null))) {
			session.setAttribute("userPW", sign);
			System.out.println("���� �н����� setAtt: "+session.getAttribute("userPW"));
			response.sendRedirect("findPassword_fin.jsp");
		}else {
			script.println("<script>");
			script.println("alert('DB������ �߻��߽��ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}