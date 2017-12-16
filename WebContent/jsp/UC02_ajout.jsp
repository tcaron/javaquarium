<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
<title><bean:message key="message.ajout.title.pagetitle" /></title>
</head>
<body class="container">
	<h1>
		<bean:message key="message.ajout.title.headertitle" />
	</h1>
	<hr />
	<div class="pure-control-group">
		<bean:message key="ajouter.message.poisson" />
	</div>
	<html:form action="ajouterNouveauPoisson" styleClass="form-horizontal">
		<html:errors />
		<br />

		<div class="form-group">
			<label for="nom" class="col-sm-3 control-label"> <bean:message
					key="tableau.nom" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login" property="nom" />
			</div>
		</div>

		<div class="form-group">
			<label for="description" class="col-sm-3 control-label"> <bean:message
					key="message.tableau.description" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login"
					property="description" />
			</div>
		</div>
		<div class="form-group">
			<label for="couleur" class="col-sm-3 control-label"> <bean:message
					key="message.tableau.couleur" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login"
					property="couleur" />
			</div>
		</div>

		<div class="form-group">
			<label for="dimension" class="col-sm-3 control-label"> <bean:message
					key="message.tableau.dimension" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login"
					property="dimension" />
			</div>
		</div>

		<div class="form-group">
			<label for="prix" class="col-sm-3 control-label"> <bean:message
					key="message.tableau.prix" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login" property="prix" />
			</div>
		</div>
		<div class="col-sm-offset-3 col-sm-9">
			<html:submit property="submit" styleClass="btn btn-success">
				<bean:message key="message.ajout.button.name.submit" />
			</html:submit>
			<html:reset property="reset" styleClass="btn btn-danger">
				<bean:message key="message.ajout.button.name.reset" />
			</html:reset>
			<a class="btn btn-primary col-sm-offset-1"
				href="/Javaquarium/listerEspece.do"> <bean:message
					key="message.listerespece.title.aquarium" />
			</a>

		</div>



	</html:form>

</body>
</html>