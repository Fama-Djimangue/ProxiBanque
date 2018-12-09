<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compte(s) du Client</title>
</head>
<body>
<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>
	
		<br/>

        <div id="page-wrapper">

            <div class="container-fluid">

			<c:if test="${nbCompte==2}">	
			<br><br>
  		  </c:if>

			<c:if test="${nbCompte==1}">	
			 <button type="button" class="btn-success"
				title="Ajouter un compte"
				style="margin-top: 15px; margin-bottom: 5px; margin-left: 5px"
				data-target="#AjoutCompte" data-toggle="modal">
					<span class="glyphicon glyphicon-plus"></span>Ajouter
				</button>
			</c:if>

			
		     
				<div class="panel panel-default">
			   <div class="panel-heading"
					style="background-color: #ccc; padding: 2px; font-size: 50px; color: #205421;">
						<h3 align="center">
							<b>Liste de (s) Compte(s) de ${nomclient}</b>
						</h3>
					</div>
				
					<div class="table-responsive">
						<table class="table"  width="100%" id="tableFormat">
							<thead>
								<tr class="success">
									<th>Numéro Compte</th>
									<th>Solde Compte</th>
									<th>Date Ouverture</th>
									<th>Type Compte</th>
									<th>Taux rénumération</th>
									<th>Découverte</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="compte" items="${listecomptes}">
									<tr class="succes">
										<td>${compte.numero_compte}</td>
										<td>${compte.solde_compte}</td>
										<td>${compte.date_ouverture}</td>
										<td>${compte.type_compte}</td>
										<td>${compte.taux_remuneration}</td>
										<td>${compte.decouvert}</td>
										<td><a href="relevercompte?idCompte=${compte.id_compte}&numcompte=${compte.numero_compte}"> <button
													type="button" class="btn btn-success" title="Relevé Compte">
													<span class="glyphicon glyphicon-tasks"></span>
												</button></a>
									   
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
<!--  ######################## MODAL AJOUT COMPTE ##############################  -->

<div class="modal fade modal-admin " id="AjoutCompte" tabindex="-1"
	role="dialog" aria-labelledby="AjoutCompte" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px">

		<div class="panel panel-info  " style="border-color: #5cb85c">
			<form action="ajoutCompte" method="post" id="submitForm">
				<div class="panel-heading" style="background-color: #5cb85c">

					<h3 class="panel-title " style="color: white">Ajout compte</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
					<input type="hidden" name="idDuclient" value="${idclt}"	id="idDuclient"/><br>					
						${nomclient} dispose déja d'un compte ${TypeCompte} voulez-vous lui 
						<label>créer un compte ${TypeACreer}</label><br>
						<input type="hidden" name="typeCompte" value="${TypeCompte}" id="idDuclient"/>
						<input type="hidden" name="nomclient" value="${nomclient}" id="nomclient"/>
					</fieldset>

				</div>

				<div class="modal-footer ">

					<button type="submit" onClick="" class="btn btn-success"
						value="submit">Oui</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-danger">Non</button>
				</div>
			</form>
		</div>
	</div>
</div>

</html>