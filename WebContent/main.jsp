<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!--alt+B 실행-->
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta charset="utf-8">
	    <title>PORTFOLIO</title>
	
		<link rel="stylesheet" href="css/main_comp.css">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	</head>
	<body>
	    <header>
	        <h2 id="headerh2">PORTFOLIO</h2>
	        <img id="head-img" src="media/profile2.png">
	    </header>
	
	    <section>
	        
	        <div id="sections">
	            <ul class="nav nav-tabs" id="myTab" role="tablist">
	                <li class="nav-item" >
	                  <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">자기소개서</a>
	                </li>
	                <li class="nav-item">
	                  <a class="nav-link" id="portfolio-tab" data-toggle="tab" href="#portfolio" role="tab" aria-controls="portfolio" aria-selected="false">활동</a>
	                </li>
	                <li class="nav-item">
	                  <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">홈</a>
	                </li>
	                <li class="nav-item">
	                  <a class="nav-link" id="meeting-tab" data-toggle="tab" href="#meeting" role="tab" aria-controls="meeting" aria-selected="false">모의면접</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" id="company-tab" data-toggle="tab" href="#company" role="tab" aria-controls="company" aria-selected="false">회사정보</a>
	                </li>
	                
	            </ul>
	            <div class="tab-content" id="myTabContent">
	                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">profile</div>
	                <div class="tab-pane fade" id="portfolio" role="tabpanel" aria-labelledby="portfolio-tab">portfolio</div>
	                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">home</div>
	                <div class="tab-pane fade" id="meeting" role="tabpanel" aria-labelledby="meeting-tab">meetinge</div>
	                <div class="tab-pane fade" id="company" role="tabpanel" aria-labelledby="company-tab">company</div>
	            </div>
	        </div>
	
	    </section>
	
	    <footer>
	        Developed by 다연,민정
	    </footer>
	
	</body>
</html>