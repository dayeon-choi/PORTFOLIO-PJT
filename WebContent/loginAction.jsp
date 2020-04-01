<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>

<jsp:useBean id="user"  class="user.UserDTO" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" /> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IntoLogin</title>
	</head>
	<body>
	<%
		UserDAO userDAO = new UserDAO(); //인스턴스생성
		
		//로그인 테스트
		int result = userDAO.login(user.getUserID(), user.getUserPassword());
		
		if(result == 1){ //로그인 성공
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("<location.href = 'main.jsp'");
			script.println("</script>");
		}
		else if(result == 0){//로그인 실패
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 일치하지 않습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result == -1){//아이디 없음
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디 입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}		
		else if(result == -2){//DB오류
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('DB오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}		
	%>
	</body>
</html>