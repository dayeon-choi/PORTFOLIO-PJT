<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<title>IntoJoin</title>
	</head>
	<body class="p-3 mb-2 bg-secondary text-white">
		<div class="container">
			<div class="row">
		        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
		            <div class="row">
		                <div class="col-lg-6 col-md-8 mx-auto">
						<div class="jumbotron">
							<form method="post" action="joinAction.jsp">
								<h3 class="text-secondary" style="text-align:center;">JOIN</h3>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
								</div>
								<div class="form-group">
									<label class="text-secondary">성별을 선택해주세요</label>
								    <select class="form-control" id="exampleFormControlSelect1" name="userGender">
								      <option value="여자">여자</option>
								      <option value="남자">남자</option>
								    </select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="이메일" name="userEmail" maxlength="50">
								</div>
								<input type="submit" class="btn btn-secondary btn btn-primary form-control" value="회원가입">
							</form>
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