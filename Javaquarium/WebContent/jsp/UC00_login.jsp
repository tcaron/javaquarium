<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean-1.2.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html-1.2.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic-1.2.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="message.login.title.pagetitle" /></title>
<link rel="stylesheet" href="/Javaquarium/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>
		<bean:message key="message.login.title.headertitle" />
	</h1>
	<hr />
	<ul class="list-group">
		<html:errors />
	</ul>

	<html:form action="pageLogin" styleClass="form-horizontal">
		<div class="form-group">
			<label for="login" class="col-sm-3 control-label"> <bean:message
					key="message.login.input.name.login" />
			</label>
			<div class="col-sm-5">
				<html:text styleClass="form-control" styleId="login"
					property="utilisateur" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-3 control-label"> <bean:message
					key="message.login.input.name.password" />
			</label>
			<div class="col-sm-5">
				<html:password styleClass="form-control" styleId="password"
					property="motDePasse" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-9">
				<html:submit property="submit" styleClass="btn btn-success">
					<bean:message key="message.login.button.name.submit" />
				</html:submit>
				<html:reset property="reset" styleClass="btn btn-danger">
					<bean:message key="message.login.button.name.reset" />
				</html:reset>
			</div>
		</div>
	</html:form>

</body>
</html>