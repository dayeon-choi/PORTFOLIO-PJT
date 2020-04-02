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
		request.setCharacterEncoding("UTF-8"); //FORM�� 'POST'����� ��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter script = response.getWriter();
		System.out.println("connector.loginAction servlet running...");
		
		//login.jsp ���Ͽ��� �Է¹��� ���̵�, ��й�ȣ
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPassword");		
		UserDAO userDAO = new UserDAO(); //�ν��Ͻ�����
		
		//�α��� �׽�Ʈ [DAO ����]
		int result = userDAO.login(userID, userPW);
		
		if(result == 1){ //�α��� ����			
			System.out.println("Completed - connector.loginAction servlet");
			response.sendRedirect("main.jsp");
		}
		else if(result == 0 || result == -1){//�α��� ����[ID �Ǵ� PW ����ġ]
			script.println("<script>");
			script.println("alert('���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}		
		else if(result == -2){//DB����
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
