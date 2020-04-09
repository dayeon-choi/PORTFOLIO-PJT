<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%
	request.setCharacterEncoding("UTF-8");
	PrintWriter script = response.getWriter();
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">		
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta charset="EUC-KR">
	<title>Find Password</title>
	
	
	</head>
	<body class="p-3 mb-2 bg-secondary text-white">
	
		<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
		                
						<div class="jumbotron">
							
							<h3 class="text-secondary" style="text-align:center;">비밀번호 찾기</h3>
							<br>
							
		               		<!-- 아이디 입력창 -->
							<form method="post" action="findPwAction1" id="getIDjumbo">
								<div class="form-inline">
									<label class="text-secondary">아이디 입력</label>
									<div class="form-group mx-sm-3 mb-2">
									   <input type="text" name="userID" class="form-control" maxlength="20">
								  	</div>
	  								<button type="submit" class="btn-secondary btn btn-primary mb-2">다음</button>
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