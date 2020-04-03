<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	
	
	<script>
		$(document).ready(function(){
			$("#getInfojumbo").hide();
			
			if(<%= session.getAttribute("userID") %>!=null){
				$("#getIDjumbo").hide();
			}else if(<%= session.getAttribute("checkID") %>!=null){
				alert("존재하지 않는 아이디입니다.");
			}
		});
	</script>
	
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
									   <input type="text" name="userID" class="form-control" >
								  	</div>
	  								<button type="submit" class="btn-secondary btn btn-primary mb-2">다음</button>
								</div>
							</form>
							
							<!-- 정보 입력창 -->
							<form method="post" action="findPwAction2" id="getInfojumbo">
								<label class="text-secondary"><%= session.getAttribute("userID") %>&nbsp;계정 정보 확인</label>
								<div class="form-inline">
									<label class="text-secondary">이름 입력</label>
									<div class="form-group mx-sm-3 mb-2">
									   <input type="text" name="userID" class="form-control" >
								  	</div>
								</div>
								<div class="form-inline">
									<label class="text-secondary">메일주소 입력</label>
									<div class="form-group mx-sm-3 mb-2">
									   <input type="text" name="userID" class="form-control" >
								  	</div>
								</div>
  								<button type="submit" class="btn-secondary btn btn-primary mb-2">다음</button>
							</form>
							
							
						</div>
						
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- 
				<div class="form-group row">
								  <label for="staticEmail" class="col-sm-2 col-form-label">아이디</label>
								  <div class="col-sm-10">
								    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
								  </div>
								</div>
								<div class="form-group row">
								  <label for="inputPassword" class="col-sm-2 col-form-label">이름</label>
								  <div class="col-sm-10">
								    <input type="password" class="form-control" id="inputPassword">
								  </div>
								</div>
				
				
				 -->