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
<script src="/Javaquarium/js/jquery-3.2.1.min.js"></script>
<script src="/Javaquarium/js/bootstrap.min.js"></script>
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
		<a class="btn btn-danger btn-xs" href="/Javaquarium/logout.do"><bean:message
				key="message.listerespeces.deconnexion" /> </a>
		<h3>
			<bean:message key="message.bienvenue" />
			<bean:write name="user" scope="session" />
		</h3>
		<bean:message key="message.listerespece.infos" />
		(
		<bean:write name="aquarium_size" scope="session" />
		) <a class="btn btn-success btn-xs"
			href="/Javaquarium/saveAquarium.do"> <bean:message
				key="message.listerespeces.sauvegarder" /></a> <a
			class="btn btn-danger btn-xs" href="/Javaquarium/emptyAquarium.do"><bean:message
				key="message.listerespeces.vider" /> </a>


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
					<td><a class="btn btn-info btn-xs" data-toggle="modal"
						href="#p-<bean:write name="MonPoisson" property="id"/>"> <bean:message
								key="message.tableau.lien.details" />
					</a></td>
					<td><a class="btn btn-success btn-xs"
						href="/Javaquarium/addAquarium.do?id=<bean:write name="MonPoisson" property="id"/>"><bean:message
								key="message.tableau.lien.ajouter" /> </a> <a
						class="btn btn-danger btn-xs"
						href="/Javaquarium/removeAquarium.do?id=<bean:write name="MonPoisson" property="id"/>"><bean:message
								key="message.tableau.lien.retirer" /> </a></td>

				</tr>
				<!-- Modal -->
				<div class="modal fade"
					id="p-<bean:write name="MonPoisson" property="id"/>" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">
									<bean:write name="MonPoisson" property="nom" />
								</h4>
							</div>
							<div class="modal-body">
								<p>
									<bean:message key="message.tableau.description" />
									:
									<bean:write name="MonPoisson" property="description" />
								</p>
								<p>
									<bean:message key="message.tableau.couleur" />
									:
									<bean:write name="MonPoisson" property="couleur" />
								</p>
								<p>
									<bean:message key="message.tableau.dimension" />
									:
									<bean:write name="MonPoisson" property="dimension" />
								</p>
								<p>
									<bean:message key="message.tableau.prix" />
									:
									<bean:write name="MonPoisson" property="prix" />
								</p>
							</div>
							<div class="modal-footer"></div>
						</div>

					</div>
				</div>
			</logic:iterate>

		</table>
		<br /> <a class="btn  btn-primary btn-xs"
			href="/Javaquarium/jsp/UC02_ajout.jsp"> <bean:message
				key="message.listerespece.button.ajout.espece.title" />
		</a>
	</center>
</body>
</html>