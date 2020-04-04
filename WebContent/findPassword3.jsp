<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
							
							<h3 class="text-secondary" style="text-align:center;">비밀번호 찾기</h3>
							<br>
							
							<!-- 정보 입력창 -->
							<form method="post" action="findPwAction3" id="getInfojumbo">
								<div class="form-group">
									<label class="text-secondary"><%= session.getAttribute("userID") %>&nbsp;계정 정보 확인</label>
								</div>
								<div class="form-group">
								<label class="text-secondary">질문1)&nbsp;<%= session.getAttribute("pwQues1")%></label>
								   <input type="text" name="pwQues1_aw" placeholder="답" class="form-control" maxlength="50">
							  	</div>
							
								<div class="form-group">
								<label class="text-secondary">질문2)&nbsp;<%= session.getAttribute("pwQues2")%></label>
								   <input type="text" name="pwQues2_aw" placeholder="답" class="form-control" maxlength="50">
							  	</div>
								
  								<button type="submit" class="btn-secondary btn btn-primary form-control">다음</button>
							</form>
							
							
						</div>
						
						
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
	</body>
</html>