<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach JSP tags etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Make Your Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Create Ninja</h1>
		<a class="btn btn-primary" href="/">Go Back</a>
		<form:form method="POST" action="/ninja/new" modelAttribute="ninjaObj" >
			<p>
				First Name:
				<form:input type="text" path="firstName"/>
				<form:errors path="firstName" />
			</p>
			<p>
				Last Name:
				<form:input type="text" path="lastName"/>
				<form:errors path="lastName" />
			</p>
			<p>
				Age:
				<form:input type="number" path="age"/>
				<form:errors path="age" />
			</p>
			<p>
				Dojo:
				<form:select path="creator">
					<c:forEach var="dojo" items="${allDojos}">
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<button>Create</button>
		</form:form>
		
	</div>
</body>
</html>