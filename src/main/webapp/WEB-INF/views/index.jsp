<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <%@ page isELIgnored="false" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Employees</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
			<a href="http://localhost:8081/employee/add-employee" class="btn btn-success mb-3">Add New</a>
				<table class="table table-bordered text-center">
				  <thead>
				    <tr>
				      <th>ID</th>
				      <th>First Name</th>
				      <th>Last Name</th>
				      <th>Gender</th>
				      <th>Email</th>
				      <th>Province</th>
				      <th>Action</th>
				    </tr>
				  </thead>
				  <tbody>
				   <c:forEach var="employee" items="${listEmployee}">
					    <tr>
					    	<td><c:out value="${employee.id}" />
					      	<td><c:out value="${employee.firstName}" />
					      	<td><c:out value="${employee.lastName}" />
					      	<td><c:out value="${employee.gender}" />
					      	<td><c:out value="${employee.email}" />
					      	<td><c:out value="${employee.province}" />
					      <td>
					      	<a href="edit-employee?id=<c:out value='${employee.id}' />" class="material-icons">edit</a>
					      	<a href="delete-employee?id=<c:out value='${employee.id}' />" class="material-icons">delete</a>
					      </td>
					     </tr>	
				    </c:forEach>	  
				  </tbody>
				</table>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
</body>
</html>