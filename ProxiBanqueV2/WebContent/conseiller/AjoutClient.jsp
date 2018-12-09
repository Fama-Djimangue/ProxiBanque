<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire Ajouter client</title>

</head>
<body>
	<c:if test="${creation==false}">
		 <div class="alert alert-danger" align="center"><strong>Echec Création: merci de choisir au moins un type de compte</strong></div>
	</c:if>

<!--  Inclusion de nav -->
<jsp:include page="/template/header.jsp"></jsp:include>

 <div id="page-wrapper">

            <div class="container-fluid">

      <br/>  <br/>  <br/>
<div class="col-sm-2"></div>					
<div class="col-sm-8 text-center">      
               <div class="panel panel-default">
					<div class="panel-heading" style="background-color: #205421; padding: 2px; color:#fff;">
						<h3 align="center">
							<b>Ajouter un client</b>
						</h3>
					</div>
  <form onsubmit="return verif()" class="form" method="POST" action="<%=request.getContextPath()%>/creatclient" style="margin: 50px;">
            
                  <div class="form-group text-left">
                 <label for="nom">Nom Client :</label>
                 <input type="text" id="nomclient"  name="nomclient" class="form-control">
                 </div>
                 <div class="form-group text-left" >
                 <label for="nom">Prénom Client :</label>
                 <input type="text" id="prenomclient"  name="prenomclient" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="name">Email Client :</label>
                 <input type="text" id="emailclient" name="emailclient"  class="form-control">
                </div>
                 <div class="form-group text-left">
                 <label for="prenom">Adresse Client :</label>
                 <input  id="adresseclient" name="adresseclient" class="form-control">
                 </div>
                 <div class="form-group text-left">
                 <label for="prenom">Code Postal :</label>
                 <input  id="codepostal" name="codepostal" class="form-control">
                 </div>
                <div class="form-group text-left">
                 <label for="prenom">Ville Client :</label>
                 <input  id="villeclient" name="villeclient" class="form-control">
                 </div>
                <div class="form-group text-left">
                 <label for="name">Téléphone Client :</label>
                 <input type="text" id="telclient" name="telclient"  class="form-control">
                </div>
                <div class="form-group text-left">
                 <label for="name">Profession Client :</label>
                 <input type="text" id="professionclient" name="professionclient"  class="form-control">
                </div>

                 
                <div class="form-group text-left">
                <label for="name">Type Compte:</label>
                <p><label><input type="checkbox" id="type" name="checkBoxCptEpargne" value="EPARGNE">Epargne</label>   
                <label><input type="checkbox" id="type" name="checkBoxCptCourant" value="COURANT">Courant</label>
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
	<!-- insertion du footer -->
	<jsp:include page="/template/footer.jsp"></jsp:include>

	<script type="text/javascript"
		src="<c:url  value="/resources/js/script.js"/>"></script>

	
</body>
</html>