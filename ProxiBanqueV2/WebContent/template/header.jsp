<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- inclusion du ficjier head.jsp   -->
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>

<div id="wrapper">
<!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <!-- <div class="navbar-header">
               <a class="navbar-brand" href="#">Proxi Banque</a> 
            </div>-->
            <!-- Top Menu Items -->
        <ul class="nav navbar-left top-nav">  
        <li><a href="<%=request.getContextPath()%>/listeclient" class="active">Accueil</a></li>
        <%-- <li><a href="<%=request.getContextPath()%>/listecompte"> Gestion Comptes</a></li>
        <li><a href="<%=request.getContextPath()%>/listTransact"> Gestion Transaction</a></li> --%>        
          </ul>      	
          
        <!-- <ul class="nav navbar-header top-nav">
          <span class="titre"><span style="color:#205421;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Proxi</span><span style="color:#a70303;">Banque</span> <span style="color:#ffe003; font-size:30px;">La banque près de chez vous</span> 
        </ul> -->
        
        
            <ul class="nav navbar-right top-nav">
              <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" class="active"> <i class="fa fa-user"></i>  ${CompteConnect.login}<b class="caret"></b></a>
                    <ul class="dropdown-menu">            
                        <li>
                         <a href="#" data-target="#Deconnexion" data-toggle="modal"><i class="fa fa-fw fa-power-off"></i>Déconnexion</a>
                        </li>
                    </ul>
                </li>
            </ul>

        </nav>


</body>

<!--  ######################## MODAL DECONNEXION ##############################  -->

<div class="modal fade modal-admin " id="Deconnexion" tabindex="-1"
	role="dialog" aria-labelledby="Deconnexion" aria-hidden="true">

	<div class="col-md-4  col-lg-offset-4" style="margin-top: 25px">

		<div class="panel panel-info  " style="border-color: #a70303;">

			<form action="deconnexion" method="post" id="submitForm">
				<div class="panel-heading" style="background-color: #a70303;">

					<h3 class="panel-title " style="color: white">Déconnexion</h3>

				</div>

				<div class="panel-body" style="color: #000033">

					<fieldset>
						<label for="compteInput">Voulez-vous vraiment vous
							déconnecter </label>
					</fieldset>

				</div>

				<div class="modal-footer ">

					<button type="submit" onClick="" class="btn btn-danger"
						value="submit">Oui</button>
					<button type="button" onClick="" data-dismiss="modal"
						class="btn btn-success">Non</button>
				</div>
			</form>
		</div>
	</div>
</div>

</html>