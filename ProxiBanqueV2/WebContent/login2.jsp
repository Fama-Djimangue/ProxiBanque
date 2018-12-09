<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Veuillez vous identifier</h1>
	</div>

	<form method="POST" action="j_security_check">
		<table align="center">
			<tr>
				<td>Login :</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type="password" name="j_password" value=""></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Valider"></td>
				<td><input type="reset" value="Annuler"></td>
			</tr>
		</table>
	</form>
</head>
</body>
</html>