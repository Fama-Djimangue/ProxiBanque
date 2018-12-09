<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Transaction</title>
</head>
<body>
	<!-- inclusion de la page de l'entete -->

	<jsp:include page="/template/header.jsp"></jsp:include>

	<div class="container-fluid text-center">
		<div class="row content">
			<!--     insertion du side bar left -->
			<jsp:include page="/template/sidebarConseiller.jsp"></jsp:include>

			<div class="col-sm-10 text-center">

				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #804d7a">

						<h3 class="panel-title " style="color: white">
							<b>FORMULAIRE MODIFICATION TRANSACTION</b>
						</h3>

					</div>

					<div class="panel-body" style="color: #804d7a">
						<div class="form-responsive">
							<form class="form-horizontal"
								action="modifConseiller" method="post">

								<div class="form-group">
									<label class="control-label col-sm-4" for="idInput">ID:</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="id"
											value=${transactAModif.id_transact } id="IdInput"
											readonly="readonly" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="nomInput">Nom:</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" required="required"
											name="nom" value=${transactAModif.numero_transact }
											id="nomInput" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-4" for="prenomInput">Prenom:</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="prenom"
											required="required"
											value=${transactAModif.montant_transact }
											id="prenomInput" />
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-4" for="emailInput">Email:
									</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="email"
											required="required"
											value=${transactAModif.type_transact } id="EmailInput" />
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