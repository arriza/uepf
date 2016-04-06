<%@page import="helper.db.MySQLdb"%>
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
<h1>Zure datuak honakoak dira</h1>			
</header>
<body>
<%
String nan=request.getAttribute("nan").toString();
String password=request.getAttribute("password").toString();
String izena=request.getAttribute("izena").toString();
String abizenak=request.getAttribute("abizenak").toString();
String helbidea=request.getAttribute("helbidea").toString();
String postaKodea=request.getAttribute("postaKodea").toString();
String jaioData=request.getAttribute("jaioData").toString();
String username=request.getAttribute("username").toString();
String mail=request.getAttribute("mail").toString();
%>
<section>
<td>Izena: <%= izena%></td></br>
<td>Abizenak: <%= abizenak%></td></br>
<td>NAN: <%= nan%></td></br>
<td>Helbidea: <%= helbidea%></td></br>
<td>Posta kodea: <%= postaKodea%></td></br>
<td>Jaiotze data: <%= jaioData%></td></br>
<td>Erabiltzaile izena: <%= username%></td></br>
<td>helbide elektronikoa: <%= mail%></td></br>
</section>
</body>
</html>