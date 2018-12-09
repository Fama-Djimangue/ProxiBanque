<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier client</title>

</head>
<body>


<!--  Inclusion de nav -->
<jsp:include page="/template/header.jsp"></jsp:include>

    <div id="page-wrapper">

            <div class="container-fluid">
	
	<br/><br/><br/>
		<div class="col-sm-2"></div>					
<div class="col-sm-8 text-center">						
						<div class="panel panel-default">
							<div class="panel-heading" style="background-color: #205421; padding: 2px; color:#fff;">
						<h3 align="center">
							<b>Modifier client</b>
						</h3>
					</div>
		
  <form name="myForm" class="form" method="POST" action="<%=request.getContextPath()%>/modifierclient" style="margin: 50px;">
  <input type="hidden" name="idclient" value="${client.id_client}" class="form-control">
             
                 <div class="form-group text-left " >
                 <label for="nom">Nom Client :</label>
                 <input type="text" id="nomclient"  name="nomclient" value="${client.nom_client}" class="form-control">
                 </div>
                  <div class="form-group text-left">
                 <label for="nom">Prénom Client :</label>
                 <input type="text" id="prenomclient"  name="prenomclient" value="${client.prenom_client}" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="name">Email Client :</label>
                 <input type="text" id="emailclient" name="emailclient"  value="${client.email_client}" class="form-control">
                </div>
                 <div class="form-group text-left">
                 <label for="prenom">Adresse Client :</label>
                 <input id="adresseclient" name="adresseclient" value="${client.adresse_client}" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="prenom">Code Postal :</label>
                 <input  id="codepostal" name="codepostal" value="${client.code_postal}" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="prenom">Ville Client :</label>
                 <input  id="villeclient" name="villeclient" value="${client.ville_client}" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="name">Téléphone Client :</label>
                 <input type="text" id="telclient" name="telclient"  value="${client.telephone_client}" class="form-control">
                </div>
                <div class="form-group text-left">
                 <label for="name">Profession Client :</label>
                 <input type="text" id="professionclient" name="professionclient" value="${client.profession_client}"  class="form-control">
                </div>
                 
	          <div style="text-align: right;">
	            <button type="submit" style="background-color:#a70303;; font-size:1.4em; width: 100px; color:#fff">Valider</button>
	          </div>
	         
        </form>

</div>
<div class="col-sm-2"></div>
</div>
     
    </div>
    
  </div>

<!-- Inserer footer -->
<jsp:include page="/template/footer.jsp"></jsp:include>



</body>
</html>