<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Gerant</title>
<!-- inclusion du ficjier head.jsp   -->
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
  <div class="" >
   <ul class="nav navbar-nav side-nav"  style="background-color: #FFF; border: 4px solid #738683;">
      <li class="list-group-item"><a href="<%=request.getContextPath()%>/gerant/accueilGerant.jsp""> accueil</a></li><br><br>
  		<li class="list-group-item"><a href="<%=request.getContextPath()%>/listConseiller"> Gestion Conseillers</a></li><br><br>

  		<li class="list-group-item"><a href="#"> Gestion Comptes</a></li><br><br>
	</ul>
    </div>
</body>
</html>