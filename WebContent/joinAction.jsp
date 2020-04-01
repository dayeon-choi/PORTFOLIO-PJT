<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!-- userDTO함수 생성 -->
<jsp:useBean id="user" class="user.UserDTO" scope="page" />
<jsp:setProperty name="user" property="userID" />
<jsp:setProperty name="user" property="userPassword" /> 
<jsp:setProperty name="user" property="userName" />
<jsp:setProperty name="user" property="userGender" />
<jsp:setProperty name="user" property="userEmail" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>IntoJoin</title>
	</head>
	<body>
	<%
		PrintWriter script = response.getWriter();
		System.out.println("1");
		
		if (user.getUserID() == null | user.getUserPassword() == null | user.getUserName() == null | user.getUserGender() == null | user.getUserEmail() == null){
			System.out.println("4");
			script.println("<script>");
			
			script.println("alert('입력이 안 된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}else{
			
			UserDAO userDAO = new UserDAO();//인스턴스 생성
			int result = userDAO.join(user);
			
			if(result==-1){
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디 입니다.')");
				script.println("history.back()");
				script.println("</script>");
			}else{//가입 성공
				script.println("<script>");
				script.println("location.href='main.jsp'");
				script.println("</script>");
			}
		}
	%>
	</body>
</html>