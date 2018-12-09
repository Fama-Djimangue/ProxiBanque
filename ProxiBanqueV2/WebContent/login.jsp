<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- boostrap CSS -->
<link href="<c:url  value="/resources/css/bootstrap.css"/>"
	rel=" ">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- boostrap JS -->
<script type="text/javascript"
	src="<c:url  value="/resources/js/bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url  value="/resources/js/bootstrap.min.js"/>"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentification</title>
</head>
<body>
	<c:if test="${resultat==false}">
		<p align="center" style="color: red">Login ou Mot Incorrect!</p>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">

				<div class="panel panel-success" style="margin-top: 200px">

					<div>
						<img src="<%=request.getContextPath()%>/resources/img/bandeau.png" />
					</div>

					<div class="panel-body">

				<form method="POST" action="connexion" class="form-horizontal">
				
				          <div class="row">
				       		<div class="col-lg-3"></div>
							<div class="col-sm-6">		
							<div class="form-group input-group">							
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" class="form-control" name="username" placeholder="Entrer votre login">
                            </div>
                            </div>
                            </div>
                            
                            <div class="row">
                          	<div class="col-lg-3"></div>
                            <div class="col-sm-6">	
                            <div class="form-group input-group">
                           <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" name="password" placeholder="Entrer votre mot de passe">
                            </div>
                            </div>                           
                            </div>   
				            <br/>
							<div align="center" class="form-group">
								<div class="col-sm-offset-1 col-sm-10">
									<button type="submit" class="btn btn-success">Connexion</button>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer" style="background-color: #205421">

					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-2">
		</div>
	</div>
</body>
</html>