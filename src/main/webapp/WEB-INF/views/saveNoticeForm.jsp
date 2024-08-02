<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<body>
</head>
<body>

	<div class="container mt-5">

		<div class="card m-4">
			<div class="card-body">
				<div class="form-group">
					<h1>채용 공고 등록</h1>
					<label for="comId">회사 ID : </label> <input type="text" class="form-control" id="comId">
				</div>
				<div class="form-group">
					<label for="position">채용 포지션 :</label> <input type="text" class="form-control" id="position">
				</div>
				<div class="form-group">
					<label for="compensation">채용 보상금 : </label> <input type="text" class="form-control" id="compensation">
				</div>
				<div class="form-group">
					<label for="content">채용 내용 : </label>
					<textarea class="form-control" id="content"></textarea>
				</div>
				<div class="form-group">
					<label for="skill">사용 기술: </label> <input type="text" class="form-control" id="skill">
				</div>
				<button id="btn-save" class="btn btn-primary">등록 완료</button>
			</div>
		</div>
	</div>


	<script src="/js/notice.js"></script>
</body>
</html>





