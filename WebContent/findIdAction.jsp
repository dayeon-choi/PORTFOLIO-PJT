<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userName" />
<jsp:setProperty name="user" property="userGender" />
<jsp:setProperty name="user" property="userEmail" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<title>IntoFindId</title>
	</head>
	<body class="p-3 mb-2 bg-secondary text-white">
		<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
						<div class="jumbotron">
							<h3 class="text-secondary" style="text-align:center;">FIND ID</h3>
							<%
							PrintWriter script = response.getWriter();
							if (user.getUserName() == null || user.getUserGender() == null || user.getUserEmail() == null){
								script.println("<script>");
								script.println("alert('입력이 안 된 사항이 있습니다.')");
								script.println("history.back()");
								script.println("</script>");
							}else{
								UserDAO userDAO = new UserDAO();//인스턴스 생성
								String result = userDAO.findId(user.getUserName(), user.getUserGender(),user.getUserEmail());
								
								if(result==null){
									script.println("<script>");
									script.println("alert('해당되는 아이디가 없습니다.')");
									script.println("history.back()");
									script.println("</script>");
								}else{//가입 성공
							%>
									<h6 class="text-secondary"><%=user.getUserName() %>님의 아이디는</h6>
									<h6 class="text-secondary"><%=result %>입니다.</h6>
							<%
								}
							}
							
							%>	
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
				
	</body>
</html>