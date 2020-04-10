<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>	
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<title>IntoFindId</title>
	</head>
	<body class="p-3 mb-2 bg-secondary text-white">
		<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
						<div class="jumbotron" id="getIdInfojumbo">
							<h3 class="text-secondary" style="text-align:center;">FIND ID</h3><br><br>							
							<div class="form-group">
								<h6 class="text-secondary" style="text-align:center;"><%= session.getAttribute("userName") %>님의 아이디는</h6>
							</div>
							<div>
								<h6 class="text-secondary" style="text-align:center;"><%= session.getAttribute("userID") %> 입니다.</h6>
							</div>
							<br><br>
							<div>
								<a href="login.jsp" class="text-white"><button type="button" class="btn btn-secondary btn btn-primary form-control">로그인 화면으로</button></a>
							</div>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</body>
</html>