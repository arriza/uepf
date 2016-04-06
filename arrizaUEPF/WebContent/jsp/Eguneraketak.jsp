<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UEPF-UNAIREN EUSKAL PILOTA FEDERAKUNTZA</title>
<link href="/UEPF/css/styleSheet.css" rel="stylesheet" />
</head>
<header>
<h1>Erabiltzaile datuen aldaketa</h1>
			<h3>Sartu datu berria</h3>
</header>
<body>
<% String aldagaia=null;
String datorrenMota=request.getAttribute("mota").toString();
String datorrenNan=request.getAttribute("nan").toString();
String datorrenPassword=request.getAttribute("password").toString();
String datorrenValue=request.getAttribute("valueZaharra").toString();
switch(datorrenMota){
	case "izena":
		aldagaia="Izen berria sartu";
		break;
	case "abizena":
		aldagaia="Abizen berria sartu";
		break;
	case "abizena2":
		aldagaia="Bigarren abizen berria sartu";
		break;
	case "helbidea":
		aldagaia="Helbide berria sartu";
		break;
	case "postaKodea":
		aldagaia="Posta kode berria sartu";
		break;
	case "jaioData":
		aldagaia="Jaiotze data berria sartu";
		break;
	case "email":
		aldagaia="Email berria sartu";
		break;
	case "username":
		aldagaia="Erabiltzaile izen berria sartu";
		break;

	}%>

<section>
			<form method="POST"  action="/UEPF/uepf/EguneraketaServlet">
				<table>
					<tr>
	   					<td>Zure egungo datua honakoa da:<%= datorrenValue%></td>
	   					
	   				</tr>
					<tr>
	   					<td><%= aldagaia%>:</td>
	   					<td><input name="value"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="nan" type="hidden"value="<%=datorrenNan%>"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="password" type="hidden"value="<%=datorrenPassword%>"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="mota" type="hidden"value="<%=datorrenMota%>"/></td>
	   				</tr>
	   				</table> 	   				
				<button>Aurrera</button>	
			</form>
		</section>
</body>
</html>