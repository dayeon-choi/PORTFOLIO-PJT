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
		request.setCharacterEncoding("UTF-8"); //FORM�� 'POST'����� ��
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter script = response.getWriter();
		
		String oldPW = (String)session.getAttribute("userPW");
		String userID = (String)session.getAttribute("userID");
		String newPW = request.getParameter("newPW");
		String newPW_re = request.getParameter("newPW_re");

		//�� ����
		if(oldPW.equals(newPW)){
			script.println("<script>");
			script.println("alert('�� ��й�ȣ�� ������ ��ġ�� �� �����ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}else if(!newPW.equals(newPW_re)){
			script.println("<script>");
			script.println("alert('Ȯ�� ��й�ȣ�� ����ġ�մϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}else {
			
			//�����ͺ��̽��� �� �־����� ���� ������ �α���â���� �̵�
			if((new UserDAO()).changePW(userID, newPW_re)!=-1){
				session.invalidate(); //�ش� ���� ����
				script.println("<script>");
				script.println("alert('��й�ȣ ������ �Ϸ��߽��ϴ�.')");
				script.println("location.replace('login.jsp')");
				script.println("</script>");
			}
			
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}