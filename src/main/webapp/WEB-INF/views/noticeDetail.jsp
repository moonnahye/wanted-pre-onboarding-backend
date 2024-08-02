<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<br> <a href="/" class="btn btn-secondary">모든 채용공고 보기</a>


		<div class="card m-4">
			<div class="card-body">
				<input type="hidden" id="id" value="${notice.id}">
				<h6 class="card-title">채용공고ID : ${notice.id}</h6>
				<h5 class="card-title">회사 이름 : ${notice.company.name}</h5>
				<h5 class="card-title">국가 : ${notice.company.nation}</h5>
				<h5 class="card-title">지역 : ${notice.company.area}</h5>
				<br>
				<h5 class="card-title">채용 포지션 : ${notice.position}</h5>
				<h5 class="card-title">채용 보상금 : ${notice.compensation}</h5>
				<h5 class="card-title">사용기술 : ${notice.skill}</h5>
				<br>
				<h5 class="card-title">채용 내용 : ${notice.content}</h5>

			</div>
		</div>



	</div>

	<script src="/js/notice.js"></script>
</body>
</html>