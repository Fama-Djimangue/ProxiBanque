<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relevé du Compte</title>
</head>
<body>
	<c:if test="${compte==false}">
	 <div class="alert alert-danger" align="center"><strong>Echec Virement: Compte saisi inextant!</strong></div>
	</c:if>
	<c:if test="${montant==false}">
	<div class="alert alert-danger" align="center"><strong>Echec Operation: Solde Compte insuffisant!</strong></div>
	</c:if>

<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>
	
	<br/>

        <div id="page-wrapper">

            <div class="container-fluid">

                <button type="button" class="btn-success"
					title="Faire un dépôt" 
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateDepot" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Depot
				</button>
				<button type="button" class="btn-info"
					title="Faire un retrait"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateRetrait" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Retrait
				</button>
				<button type="button" class="btn-warning"
					title="Faire un virement"
					style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
					data-target="#CreateVirement" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Virement
				</button>		
				
			<div class="panel panel-default">
				<div class="panel-heading"
					style="background-color: #ccc; padding: 2px; font-size: 50px; color: #205421;">
						<h3 align="center">
							<b>Relevé de Compte numéro ${numCompte}</b>
						</h3>
					</div>
				

				
					<div class="table-responsive">
						<table class="table" id="tableFormat" border="1">
							<thead>
								<tr class="success" align="center">
									<th colspan="5" style="text-align: center; font-size:20px;">Transaction du compte</th>									
									</tr>
									<tr>
									<th>AVANT</th>
									<th>TYPE</th>
									<th>MONTANT</th>
									<th>APRES</th>
									<th>DATE</th>
									</tr> 
							</thead>
							<tbody>
								<c:forEach var="transaction" items="${transactions}">
									<tr class="succes">
									<c:if test="${virement!=true}">
										<td>${transaction.solde_avant}</td>
										</c:if>
										<c:if test="${virement==true}">
										<td>${transaction.solde_avant_cred}</td>
										</c:if>
										<td>${transaction.type_affich} <b>${transaction.compteRef}</b></td>
										<td>${transaction.montant_transact}</td>
										<c:if test="${virement!=true}">
										<td>${transaction.solde_apres}</td>
										</c:if>
										<c:if test="${virement==true}">
										<td>${transaction.solde_apres_cred}</td>
										</c:if>
										<td>${transaction.date_transact}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
		         <div class="form-group" align="right">
                 <label for="name">Solde Compte:</label>
                 <input type="text" align="right" readonly="readonly"  value="${soldeCompte}">
                </div>		
				
				</div>
		</div>
	<!-- insertion du footer -->
	<jsp:include page="/template/footer.jsp"></jsp:include>

	<script type="text/javascript"
		src="<c:url  value="/resources/js/script.js"/>"></script>

</body>
<c:if test="${compte==false}">
	<p align="center" style="color: red">Echec de lacreation ce compte
		est inextant!</p>
</c:if>
<!--  ########################MODAL AJOUT DEPOT##############################  -->


<div class="modal fade modal-admin " id="CreateDepot" tabindex="-1"
	role="dialog" aria-labelledby="CreateDepot" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px">

		<div class="panel panel-info  " style="border-color:#5cb85c">

			<form action="createDepot" method="POST" id="submitForm">
			
				<div class="panel-heading"
					style="background-color: #5cb85c">

					<h3 class="panel-title " style="color: white">Dépôt</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
                      <label
							for="compteInput">Numero Compte: </label> <input type="text"
							class="form-control" name="compte" value="${numCompte}"
							id="compteInput" readonly="readonly" /><br> <label
							for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
					</fieldset>

				</div>

				

				<div class="modal-footer ">
					<button type="submit" onClick="" class="btn btn-success"
						value="submit">Valider</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-danger">Annuler</button>
				</div>

			</form>
		</div>
	</div>
</div>

<!--  ########################MODAL AJOUT RETRAIT##############################  -->

<div class="modal fade modal-admin " id="CreateRetrait" tabindex="-1"
	role="dialog" aria-labelledby="CreateRetrait" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: #46b8da;">

			<form action="createRetrait" method="POST" id="submitForm">

				<div class="panel-heading"
					style="background-color: #46b8da;">

					<h3 class="panel-title " style="color: white">Retrait</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						   <label
							for="compteInput">Numero Compte: </label> <input type="text"
							class="form-control" name="compte" value="${numCompte}"
							id="compteInput" readonly="readonly"/><br> <label
							for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
					</fieldset>

				</div>

				<div class="modal-footer ">
					<button type="submit" onClick="" class="btn btn-info"
						value="submit">Valider</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-danger">Annuler</button>
				</div>

			</form>
		</div>
	</div>
</div>

<!--  ########################MODAL AJOUT VIREEMENT##############################  -->

<div class="modal fade modal-admin " id="CreateVirement" tabindex="-1"
	role="dialog" aria-labelledby="CreateVirement" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px" id="">

		<div class="panel panel-info  " style="border-color: #eea236;">

			<form action="createVirement" method="POST" id="submitForm">
			
				<div class="panel-heading"
					style="background-color: #eea236;">

					<h3 class="panel-title " style="color: white">Virement</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
			
						 <label
							for="cptDebInput">Compte à débiter: </label> <input type="text"
							class="form-control" name="cptDeb" value="${numCompte}"
							placeholder="Votre Compte à débiter" id="cptDebInput" readonly="readonly" /><br> <label
							for="cptCredInput">Compte à créditer: </label> <input type="text"
							class="form-control" name="cptCred" required="required"
							placeholder="Votre Compte à créditer" id="cptCredInput" /><br> <label
							for="montantInput">Montant: </label> <input type="text"
							class="form-control" name="montant" required="required"
							placeholder="Votre Montant" id="montantInput" /><br>
					</fieldset>

				</div>

				<div class="modal-footer ">
					<button type="submit" onClick="" class="btn btn-warning"
						value="submit">Valider</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-danger">Annuler</button>
				</div>

			</form>
		</div>
	</div>
</div>

</html>
</html>