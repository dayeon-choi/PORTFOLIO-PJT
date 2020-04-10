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
						<div class="jumbotron">
							<form method="post" action="FindIdAction">
								<h3 class="text-secondary" style="text-align:center;">FIND ID</h3>
								<h6 class="text-secondary" style="text-align:center;">찾고 싶으신 아이디의 정보를 입력해주세요 </h6>
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
								<input type="submit" class="btn btn-secondary btn btn-primary form-control" value="아이디 찾기">
							</form>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>