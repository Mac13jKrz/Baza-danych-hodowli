<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Strona Główna</title>
</head>
<body>
	<form method="post" action="/login">
		<input type="text" name="login" placeholder="login"></input>
		<input type="password" name="password" placeholder="password"></input>
		<input type="submit" value="Zaloguj się">
	</form>
</body>
</html>