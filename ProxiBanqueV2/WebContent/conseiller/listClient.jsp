<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Clients du Conseillers</title>
</head>
<body>

	<c:if test="${modif==true}">
		<div class="alert alert-success" align="center">
			<strong>Modification faite avec succés !!!</strong>
		</div>
	</c:if>
	<c:if test="${creation==true}">
		<div class="alert alert-success" align="center">
			<strong>Ajout fait avec succés !!!</strong>
		</div>
	</c:if>

	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div id="page-wrapper">

		<div class="container-fluid">

			<a href="conseiller/AjoutClient.jsp"><button type="button"
					class="btn-success" title="Ajouter un nouveau conseiller"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateClient" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Ajouter
				</button></a>




			<div class="panel panel-default">
				<div class="panel-heading"
					style="background-color: #ccc; padding: 2px; font-size: 50px; color: #205421;">
					<h3 align="center">
						<b>Liste des Clients</b>
					</h3>
				</div>
				
				<div class="table-responsive">
					<table class="table" width="100%" id="tableFormat">
						<thead>
							<tr class="success">
								<th>Nom</th>
								<th>Prenom</th>
								<th>Email</th>
								<th>Adresse</th>
								<th>CP / Ville</th>
								<th>Téléphone</th>
								<th>Profession</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="client" items="${clients}">
								<tr class="succes">
									<td>${client.nom_client}</td>
									<td>${client.prenom_client}</td>
									<td>${client.email_client}</td>
									<td>${client.adresse_client}</td>
									<td>${client.code_postal}/${client.ville_client}</td>
									<td>${client.telephone_client}</td>
									<td>${client.profession_client}</td>
									<td><a href="listecompte?idclient=${client.id_client}">
											<button type="button" class="btn btn-success"
												title="Compte client">
												<span class="glyphicon glyphicon-check"></span>
											</button>
									</a> <a href="modifierclient?idclient=${client.id_client}">
											<button type="button" class="btn btn-warning"
												title="Modifier">
												<span class="glyphicon glyphicon-pencil"></span>
											</button>
									</a></td>

									<!-- utilisation des EL -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>

	<!-- insertion du footer -->
	<jsp:include page="/template/footer.jsp"></jsp:include>

	<script type="text/javascript"
		src="<c:url  value="/resources/js/script.js"/>"></script>

</body>
</html>