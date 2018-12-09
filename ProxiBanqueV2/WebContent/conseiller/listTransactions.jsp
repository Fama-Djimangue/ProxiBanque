<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Transaction</title>
</head>
<body>

	<c:if test="${compte==false}">
		<p align="center" style="color: red">Echec Virement: Compte saisi inextant!</p>
	</c:if>
	<c:if test="${montant==false}">
		<p align="center" style="color: red">Echec Operation: Solde Compte insuffisant!</p>
	</c:if>
	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div class="container-fluid text-center">
		<div class="row content">
			<!--     insertion du side bar left -->
			<jsp:include page="/template/sidebarConseiller.jsp"></jsp:include>

			<div class="col-sm-10 text-left">
				<button type="button" class="btn btn-sm btn-info"
					title="Faire un dépôt"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateDepot" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Depot
				</button>
				<button type="button" class="btn btn-sm btn-info"
					title="Faire un retrait"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateRetrait" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Retrait
				</button>
				<button type="button" class="btn btn-sm btn-info"
					title="Faire un virement"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateVirement" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Virement
				</button>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 align="center">
							<b>Liste des Transaction</b>
						</h3>
					</div>
					<div class="panel-body">Panel Content</div>
					<div class="table-responsive">
						<table class="table table-striped" id="tableUser">
							<thead>
								<tr>
									<th>NUMERO</th>
									<th>MONTANT</th>
									<th>TRANSACTION</th>
									<th>DATE</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="transaction" items="${transactions}">
									<tr class="succes">
										<td>${transaction.numero_transact}</td>
										<td>${transaction.type_transact}</td>
										<td>${transaction.montant_transact}</td>
										<td>${transaction.date_transact}</td>

										<td><button type="button" class="btn btn-danger"
												title="Supprimer">
												<span class="glyphicon glyphicon-trash"></span>
											</button> <a
											href="ficheTransact?idTransact=${transaction.id_transact}"><button
													type="button" class="btn btn-info" title="Modifier">
													<span class="glyphicon glyphicon-pencil"></span>
												</button></a></td>

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

<!--  ########################MODAL AJOUT DEPOT##############################  -->

<div class="modal fade modal-admin " id="CreateDepot" tabindex="-1"
	role="dialog" aria-labelledby="CreateDepot" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: rgb(193, 25, 83)">

			<form action="createDepot" method="POST" id="submitForm">

				<div class="panel-heading"
					style="background-color: rgb(193, 25, 83)">

					<h3 class="panel-title " style="color: white">Création Dépôt</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						<legend>Informations Dépôt</legend>

						<input type="hidden" class="form-control" name="compte"
							required="required" value="${numCompte}" id="compteInput" /><br>
						<label for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
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
<!--  ########################MODAL AJOUT RETRAIT##############################  -->

<div class="modal fade modal-admin " id="CreateRetrait" tabindex="-1"
	role="dialog" aria-labelledby="" CreateRetrait"" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: rgb(193, 25, 83)">

			<form action="createRetrait" method="POST" id="submitForm">

				<div class="panel-heading"
					style="background-color: rgb(193, 25, 83)">

					<h3 class="panel-title " style="color: white">Creation Retrait</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						<legend>Informations Retrait</legend>

						<input type="hidden" class="form-control" name="compte"
							required="required" value="${numCompte}" id="compteInput" /><br>
						<label for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
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
<!--  ########################MODAL AJOUT VIREMENT##############################  -->

<div class="modal fade modal-admin " id="CreateVirement" tabindex="-1"
	role="dialog" aria-labelledby="CreateVirement" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: rgb(193, 25, 83)">

			<form action="createVirement" method="POST" id="submitForm">

				<div class="panel-heading"
					style="background-color: rgb(193, 25, 83)">

					<h3 class="panel-title " style="color: white">Creation
						Virement</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						<legend>Informations Virement</legend>

						<input type="hidden" class="form-control" name="cptDeb"
							required="required" value="${numCompte}" id="compteInput" /><label
							for="cptCredInput">Compte à créditer: </label> <input type="text"
							class="form-control" name="cptCred" required="required"
							placeholder="Votre Compte à créditer" id="cptCredInput" /><br>
						<label for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
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