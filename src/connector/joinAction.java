package connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDAO;
import user.UserDTO;

@WebServlet("/joinAction")
public class joinAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //FORM�� 'POST'����� ��
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter script = response.getWriter();
		System.out.println("connector.joinAction servlet running...");
		
		//login.jsp ���Ͽ��� �Է¹��� ���̵�, ��й�ȣ
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String pwQues1 = request.getParameter("pwQues1");
		String pwQues1_aw = request.getParameter("pwQues1_aw");
		String pwQues2 = request.getParameter("pwQues2");
		String pwQues2_aw = request.getParameter("pwQues2_aw");
		

		if (userID=="" || userPW=="" || userName=="" || userGender=="" || userEmail=="" 
				|| pwQues1=="" || pwQues1_aw=="" || pwQues2=="" || pwQues2_aw==""){
			//�Է¾ȵ� ������ �ϳ��� ���� ��
			script.println("<script>");
			script.println("alert('�Է��� �� �� ������ �ֽ��ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
			
		}else{
			
			//�����ͺ��̽� ���� �� ��й�ȣ ��� �˻�
			
			
			UserDAO userDAO = new UserDAO();//�ν��Ͻ� ����
			//user_temp
			UserDTO user_t = new UserDTO(userID, userPW, userName, userGender, userEmail, 
					pwQues1, pwQues1_aw, pwQues2, pwQues2_aw);
			
			int result = userDAO.join(user_t); //�����ͺ��̽� ����
			//join�Լ������� �ڵ����� �ߺ����� �ɷ���.(�ߺ����� �ִ°�� ƨ��)
			if(result==-1){
				script.println("<script>");
				script.println("alert('�̹� �����ϴ� ���̵� �Դϴ�.')");
				script.println("history.back()");
				script.println("</script>");
			}else{//���� ����
				System.out.println("Completed - connector.joinAction servlet");
				System.out.println(user_t);
				script.println("<script>");
				script.println("alert('ȸ�������� �Ϸ�Ǿ����ϴ�. �α��� â���� �̵��մϴ�.')"); //�۵� �ȵ�
				script.println("location.replace('login.jsp')");
				script.println("</script>");
			}
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
