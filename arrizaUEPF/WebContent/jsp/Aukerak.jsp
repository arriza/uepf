<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>UEPF-UNAIREN EUSKAL PILOTA FEDERAKUNTZA</title>
<link href="/UEPF/css/styleSheet.css" rel="stylesheet" />
</head>
<header>
<h1>Zer egin nahi duzu?</h1>			
</header>
<body>
<%String datorrenNAN=request.getAttribute("nan").toString();
String datorrenPassword=request.getAttribute("password").toString();%>
<section><input type="submit" value="Pasahitza aldatu" onclick = "location='/UEPF/html/PasahitzaAldatu.html'"/></section>
<section><input type="submit" value="Erabiltzaile datuak eguneratu" onclick = "location='/UEPF/html/Eguneraketa.html'"/></section>
<section>
			<form method="POST"  action="/UEPF/uepf/LizentziaEskatuServlet">
				<table>
	   				<tr>
	   					<td><input name="nan" type="hidden"value="<%=datorrenNAN%>"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="password" type="hidden"value="<%=datorrenPassword%>"/></td>
	   				</tr>
	   				</table> 	   				
				<button>Lizentzia eskatu</button>	
			</form>
		</section>
<section>
			<form method="POST"  action="/UEPF/uepf/PdfServlet">
				<table>
	   				<tr>
	   					<td><input name="nan" type="hidden"value="<%=datorrenNAN%>"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="password" type="hidden"value="<%=datorrenPassword%>"/></td>
	   				</tr>
	   				</table> 	   				
				<button>Lizentzia jaitsi</button>	
			</form>
</section>
<section>
			<form method="POST"  action="/UEPF/uepf/DatuakServlet">
				<table>
	   				<tr>
	   					<td><input name="nan" type="hidden"value="<%=datorrenNAN%>"/></td>
	   				</tr>
	   				<tr>
	   					<td><input name="password" type="hidden"value="<%=datorrenPassword%>"/></td>
	   				</tr>
	   				</table> 	   				
				<button>Nire datuak ikusi</button>	
			</form>
</section>
		<section><input type="submit" value="Atzera" onclick = "location='/UEPF/html/Login.html'"/></section>
</body>
</html>