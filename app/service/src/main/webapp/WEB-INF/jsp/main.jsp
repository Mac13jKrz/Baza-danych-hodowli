<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>strona główna</title>
 <link rel="stylesheet" href="styles.css">
</head>
<body style="background-image: url('${pageContext.servletContext.contextPath}/wygląd/tło wejściowe.png');
background-size: cover;background-repeat-y: no-repeat">

<div style="margin: 200px auto; width: 50%;">
<form style="display: grid; margin: 50px auto;" method="POST" action="${pageContext.servletContext.contextPath}/register/confirm">
    <b>Login:</b> <input type="text" name="login">
    <b>Hasło:</b> <input type="password" name="haslo1">
    <b>Powtórz hasło:</b> <input type="password" name="haslo2">
    <input type="submit" value="Utwórz konto" name="rejestruj">
</form>
</div>
</body>
</html>