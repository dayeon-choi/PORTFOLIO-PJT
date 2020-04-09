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
public class findPwAction1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM�� 'POST'����� ��
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		System.out.println("doget�޼���");
		String userID = request.getParameter("userID");		
		
		if((new UserDAO()).findID_infindpw(userID)==1) {
			//���̵� ���� ����
			session.setAttribute("userID", userID);
			response.sendRedirect("findPassword2.jsp");
			
		}else {
			//���̵� ���� ���� 
			System.out.println("���̵���������");
			script.println("<script>");
			script.println("alert('���̵� �������� �ʽ��ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
