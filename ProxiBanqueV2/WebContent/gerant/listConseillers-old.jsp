<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Conseillers</title>
</head>
<body>
	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div class="container-fluid text-center">
		<div class="row content">
			<!--     insertion du side bar left -->
			<jsp:include page="/template/sidebarGerant.jsp"></jsp:include>

			<div class="col-sm-10 text-left">
				<button type="button" class="btn btn-sm btn-info"
					title="Ajouter un nouveau conseiller"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateConseiller" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Ajouter
				</button>

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 align="center">
							<b>Liste des Conseillers</b>
						</h3>
					</div>
					<div class="panel-body">Panel Content</div>
					<div class="table-responsive">
						<table class="table table-striped" id="tableUser">
							<thead>
								<tr>
									<th>Nom</th>
									<th>Prenom</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="conseiller" items="${conseillers}">
									<tr class="succes">
										<td>${conseiller.nom_employer}</td>
										<td>${conseiller.prenom_employer}</td>
										<td>${conseiller.email_employer}</td>
										<td><button type="button" class="btn btn-danger"
												title="Supprimer">
												<span class="glyphicon glyphicon-trash"></span>
											</button>
											<button type="button" class="btn btn-info" title="Modifier">
												<span class="glyphicon glyphicon-pencil"></span>
											</button></td>

										<!-- utilisation des EL -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- insertion du footer -->
	<jsp:include page="/template/footer.jsp"></jsp:include>

	<script type="text/javascript"
		src="<c:url  value="/resources/js/script.js"/>"></script>

</body>
<!-- ########################MODAL AJOUT UTILISATEUR##############################  -->

<div class="modal fade modal-admin " id="CreateConseiller" tabindex="-1"
	role="dialog" aria-labelledby="CreateConseiller" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: rgb(193, 25, 83)">

			<form action="createCons" method="POST" id="submitForm">

				<div class="panel-heading"
					style="background-color: rgb(193, 25, 83)">

					<h3 class="panel-title " style="color: white">Creation
						utilisateur</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						<legend>Informations utilisateur</legend>

						<label for="nomInput">Nom: </label> <input type="text"
							class="form-control" required="required" name="nom"
							placeholder="Votre Nom" id="nomInput" /><br> <label
							for="prenomInput">Prenom: </label> <input type="text"
							class="form-control" name="prenom" required="required"
							placeholder="Votre Prenom" id="prenomInput" /><br> <label
							for="loginnput">Email: </label> <input type="text"
							class="form-control" name="email" required="required"
							placeholder="Votre Email" id="EmailInput" /><br> <label
							for="nomInput">Adresse: </label> <input type="text"
							class="form-control" required="required" name="adresse"
							placeholder="Votre Adresse" id="adresseInput" /><br> <label
							for="nomInput">Ville: </label> <input type="text"
							class="form-control" required="required" name="ville"
							placeholder="Votre Ville" id="villeInput" /><br> <label
							for="nomInput">Telephone: </label> <input type="text"
							class="form-control" required="required" name="telephone"
							placeholder="Votre Telephone" id="telephoneInput" /><br> <label
							for="nomInput">Code Postal: </label> <input type="text"
							class="form-control" required="required" name="codePostal"
							placeholder="Votre Code Postal" id="codePostalInput" /><br>
						<label for="loginnput">Login: </label> <input type="text"
							class="form-control" name="login" required="required"
							placeholder="Votre Login" id="loginInput" /><br> <label
							for="editPasInput">Mot de Passe: </label> <input type="password"
							class="form-control" name="password" required="required"
							placeholder="Votre  Password" id="loginInput" /><br>
					</fieldset>

				</div>

				<div class="modal-footer ">
					<button type="submit" onClick="" class="btn btn-info"
						value="submit">Valider</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-warning">Annuler</button>
				</div>

			</form>
		</div>
	</div>
</div>

</html>