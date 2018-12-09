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
<div class="col-sm-2 sidenav">
      <ul class="list-group">
  		<li class="list-group-item"><a href="<%=request.getContextPath()%>/listeUser"> Gestion utilisateurs</a></li><br><br>
  		<li class="list-group-item"><a href="#"> Gestion films</a></li><br><br>
  		<li class="list-group-item"><a href="#"> Gestion acteurs</a></li><br><br>
	</ul>
    </div>
</body>
</html>