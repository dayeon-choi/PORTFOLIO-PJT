<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Find Password</title>
	</head>
	<body>
		<body class="p-3 mb-2 bg-secondary text-white">

		<% 
			
		
		%>
		
		<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
						<div class="jumbotron">
						
							<form method="post" action="joinAction">
								<h3 class="text-secondary" style="text-align:center;">사용자 정보 확인</h3>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="5">
									<p class="text-danger"></p>
								</div>
						
						
							
							</form>
							
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>