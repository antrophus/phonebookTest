<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>전화번호부-수정 jstl</title>
</head>
<body>
	<h1>전화번호부</h1>

	<h2>전화번호-수정폼</h2>

	<p>수정할 항목을 입력한 후 수정버튼을 클릭해 주세요</p>
	
	<form action="/phonebooktest/edit" method="post">
		<div>
			<label for="txt-name"> 이름(name): </label> 
			<input id="txt-name" type="text" name="name" value="" placeholder="${personVo.name}">
		</div>
		<div>
			<label for="txt-hp"> 핸드폰(hp): </label> 
			<input id="txt-hp" type="text" name="hp" value="" placeholder="${personVo.hp}">
		</div>
		<div>
			<label for="txt-company">회사(company): </label> 
			<input id="txt-company" type="text" name="company" value="" placeholder="${personVo.company}">
		</div>
		<input type="text" name="personId" value="${personVo.personId}">
		<button type="submit">수정(전송)</button>
	</form>
	<br><br>
	<a href="/phonebooktest/list">리스트로 가기</a>
</body>
</html>