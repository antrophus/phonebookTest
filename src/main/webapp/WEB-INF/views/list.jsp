<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        #btndel a {
            color: black; 
            text-decoration: none; 
        }
</style>
</head>
<body>

	<h1>전화번호부</h1>

	<h2>전화번호-리스트</h2>

	<p>등록된 전화번호 리스트 입니다.</p>

	<table border="1">
		<tbody>
			<tr>
				<th>이름(name)</th>
				<th>핸드폰(hp)</th>
				<th>회사(company)</th>
				<th colspan="2">관리</th>
			</tr>
			<c:forEach items="${requestScope.personList }" var="personVo">
				<tr>
					<td>${personVo.name}</td>
					<td>${personVo.hp}</td>
					<td>${personVo.company}</td>
					<td><button id="btndel">
							<a href="/phonebooktest/delete?no=${personVo.personId}">삭제하기</a>
						</button> <a href="/phonebooktest/editform?no=${personVo.personId}">[수정폼이동]</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<a href="/phonebooktest/writeform">등록폼으로 이동</a>
</body>
</html>