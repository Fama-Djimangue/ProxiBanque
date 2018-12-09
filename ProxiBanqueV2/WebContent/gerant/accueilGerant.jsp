<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>accueil</title>
</head>
<body>
	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div class="container-fluid text-center ">
		<div class="row content">
			<!--     insertion du side bar left -->
			<jsp:include page="/template/sidebarGerant.jsp"></jsp:include>

			<div class="col-sm-10 text-left">
				<!-- Inclusion de l'image d'accueil -->
				<img
					src="<%=request.getContextPath()%>/resources/img/panneC.jpg"
					style="margin-top: 15px" />


			</div>

		</div>
	</div>
	<!-- insertion du footer -->
	<jsp:include page="/template/footer.jsp"></jsp:include>

</body>
</html>