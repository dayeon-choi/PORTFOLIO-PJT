<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Find Password</title>
</head>
<body class="p-3 mb-2 bg-secondary text-white">



<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
		                
						<div class="jumbotron">
							
							<h3 class="text-secondary" style="text-align:center;">비밀번호 변경</h3>
							<br>
							<form method="post" action="findPwAction_fin" id="getInfojumbo">
								<div class="form-inline">
									<label class="text-secondary">새 비밀번호</label>
									<div class="form-group mx-sm-3 mb-2">
									   <input type="password" name="newPW" class="form-control" maxlength="20">
								  	</div>
								</div>
								<div class="form-inline">
									<label class="text-secondary">비밀번호 확인</label>
									<div class="form-group mx-sm-3 mb-2">
									   <input type="password" name="newPW_re" class="form-control" maxlength="20">
								  	</div>
								</div>
								<br>
  								<button type="submit" class="btn-secondary btn btn-primary mb-2">변경하기</button>
							</form>
							
							
						</div>
						
						
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>