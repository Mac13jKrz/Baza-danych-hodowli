<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
td{
margin: 1px 2px;
border: 1px solid silver;
border-radius: 2px;
padding: 3px;
text-align: center;
}
table{
margin: 220px auto;
border: 1px solid black;
border-radius: 2px;
}
</style>
<meta charset="ISO-8859-1">
<title>Moje Krowy</title>
</head>
<body style="background-image: url('${pageContext.servletContext.contextPath}/wygląd/tło główne.png');
background-size: cover;background-repeat-y: no-repeat">
	<div id="container">
	<div>Zalogowano jako, ${user}! <a href="./logout">Wyloguj się</a></div>
		<c:if test="${kruwy!=null}">
		<table>
			<tr>
			<th>numer ID</th>
			<th>data paszportu</th>
			<th>kolczyk ID</th>
			<th>data urodzenia</th>
			<th>płeć</th>
			<th>rasa</th>
			<th>numer ID matki</th>
			<th>kolczyk ID matki</th>
			</tr>
			<c:forEach var="kruwa" items="${kruwy}">
				<tr>${kruwa}</tr>
			</c:forEach>
			<tr>
			<form action="/dodajKrowe" method="post">
			</tr>
				<td><input type="text" name="numer_ID"></td>
				<td><input type="date" name="data_paszportu"></td>
				<td><input type="number" name="kolczyk_ID"></td>
				<td><input type="date" name="data_urodzenia"></td>
				<td><input type="text" name="plec"></td>
				<td><input type="text" name="rasa"></td>
				<td><input type="text" name="numer_ID_matki"></td>
				<td><input type="number" name="kolczyk_ID_matki"></td>
				<td><input type="submit" value="dodaj"></td>
			<tr>
			</form>
		</table>
		</c:if>
	</div>
</body>
</html>