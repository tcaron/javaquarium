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
<title><bean:message key="message.inscription.title.pagetitle" /></title>
</head>

<body class="container">
	<h1>
		<bean:message key="message.inscription.title.headertitle" />
	</h1>
	<hr />
	<ul class="list-group">
		<html:errors />
	</ul>
	<html:form action="/ajouterNouveauUtilisateur" styleClass="form-horizontal">
		
		<div class="form-group">
			<label for="login" class="col-sm-3 control-label"> <bean:message
					key="message.inscription.input.name.login" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login"
					property="utilisateur" />
					
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-3 control-label"> <bean:message
					key="message.inscription.input.name.password" />
			</label>
			<div class="col-sm-5">
				<html:password styleClass="form-control" styleId="password"
					property="motDePasse" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-9">
				<html:submit property="submit" styleClass="btn btn-success">
					<bean:message key="message.inscription.button.name.submit" />
				</html:submit>
				
				<html:reset property="reset" styleClass="btn btn-danger">
					<bean:message key="message.inscription.button.name.reset" />
				</html:reset>
				<a class="btn btn-primary col-sm-offset-1" href="/Javaquarium/jsp/UC00_login.jsp"> <bean:message key="message.inscription.button.name.retouraccueil" />
			</a>
			</div>
		</div>
		
	</html:form>
</body>
</html>