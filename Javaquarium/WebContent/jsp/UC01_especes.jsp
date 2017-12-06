<%@page import="com.javaquarium.action.ListerEspeceAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css">
<link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="message.listerespece.title.pagetitle" /></title>
</head>
<body class="container">

	<!--  message de bienvenue, récupére les informations de l'utilisateur dans la page de connection -->
	<h1>
		<bean:message key="message.listerespece.title.aquarium" />
	</h1>
	<hr />
	<center>
		<h3>
			<bean:message key="message.bienvenue" />
			<bean:write name="utilisateur" property="utilisateur" />
		</h3>
		<bean:message key="message.listerespece.infos"/>
		<a class="btn btn-success btn-xs" href=""> <bean:message key="message.listerespeces.sauvegarder" /></a>				
		<a class="btn btn-danger btn-xs" href=""><bean:message key="message.listerespeces.vider" /> </a>
						
								
	</center>
	<br />
	<center>
		<table class="pure-table">

			<!--  Header du tableau  -->
			<tr>
				<td><bean:message key="tableau.nom" /></td>
				<td><bean:message key="message.tableau.description" /></td>
				<td><bean:message key="message.tableau.couleur" /></td>
				<td><bean:message key="message.tableau.dimension" /></td>
				<td><bean:message key="message.tableau.prix" /></td>
				<td><bean:message key="message.tableau.detail" /></td>
				<td><bean:message key="message.tableau.monaquarium" /></td>

			</tr>

			<!--  Contenu du tableau  -->
			<logic:iterate name="<%= ListerEspeceAction.SESSION_REQUEST %>"
				id="MonPoisson">
				<tr>

					<td><bean:write name="MonPoisson" property="nom" /></td>
					<td><bean:write name="MonPoisson" property="description" /></td>
					<td><bean:write name="MonPoisson" property="couleur" /></td>
					<td><bean:write name="MonPoisson" property="dimension" /></td>
					<td><bean:write name="MonPoisson" property="prix" /></td>
					<td><a class="btn btn-info btn-xs" href=""> <bean:message
								key="message.tableau.lien.details" />
					</a></td>
					<td><a class="btn btn-success btn-xs"
						href="/Javaquarium/jsp/UC02_ajout.jsp"> <bean:message
								key="message.tableau.lien.ajouter" />
					</a> <a class="btn btn-danger btn-xs"
						href="/Javaquarium/removeEspece.do?code=<bean:write name="MonPoisson" property="code"/>"><bean:message
								key="message.tableau.lien.retirer" /> </a></td>

				</tr>
			</logic:iterate>

		</table>
		<br /> <a class="btn  btn-primary btn-xs"
			href="/Javaquarium/jsp/UC02_ajout.jsp"> <bean:message
				key="message.listerespece.button.ajout.espece.title" />
		</a>
	</center>

</body>
</html>