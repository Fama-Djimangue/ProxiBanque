<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Conseiller</title>
</head>
<body>
	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div class="container-fluid text-center">
		<div class="row content">
			<!--     insertion du side bar left -->
			<jsp:include page="/template/sidebarGerant.jsp"></jsp:include>

			<div class="col-sm-10 text-center">

				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #804d7a">

						<h3 class="panel-title " style="color: white">
							<b>FORMULAIRE MODIFICATION CONSEILLER</b>
						</h3>

					</div>

					<div class="panel-body" style="color: #804d7a">
						<div class="form-responsive">
							<form class="form-horizontal"
								action="modifConseiller" method="post">

								<div class="form-group">
						<!-- 			<label class="control-label col-sm-4" for="idInput">ID:</label> -->
									<div class="col-sm-5">
										<input type="hidden" class="form-control" name="id"
											value=${conseillerAmodifier.id_employer } id="IdInput"
											readonly="readonly" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="nomInput">Nom:</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="nom" value=${conseillerAmodifier.nom_employer }
											id="nomInput" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-4" for="prenomInput">Prenom:</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="prenom"
											required="required"
											value=${conseillerAmodifier.prenom_employer }
											id="prenomInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="emailInput">Email:
									</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="email"
											required="required"
											value=${conseillerAmodifier.email_employer } id="EmailInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="adresseInput">Adresse:
									</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="adresse" value=${conseillerAmodifier.adresse_employer }
											id="adresseInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="villeInput">Ville:
									</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="ville" value=${conseillerAmodifier.ville_employer }
											id="villeInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="telephoneInput">Telephone:
									</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="telephone"
											value=${conseillerAmodifier.telephone_employer }
											id="TelephoneInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="codePostalInput">Code
										Postal: </label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="codePostal" value=${conseillerAmodifier.code_postal }
											id="CodePostalInput" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-8">
										<button type="submit" class="btn btn-sucess"
											style="margin-top: 5px; margin-bottom: 5px; color: white; background-color: #78A419">
											<b>Valider</b>
										</button>
									</div>
								</div>
							</form>
						</div>
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

</html>