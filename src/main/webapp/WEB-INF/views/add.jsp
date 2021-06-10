<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  <%@ page isELIgnored="false" %>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create new Employee</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
    	<div class="row">
    		<div class="col-2"></div>
    		<div class="col-8">
    			<div class="card">
        	<div class="card-header">
        		<h3 class="text-center">Add Employee</h3>
        	</div>
        	<div class="card-body">
        		 <form:form action="save-employee" method="post" modelAttribute="emp">
        			<div class="form-group">
		        		<label>First Name<span class="text-danger">*</span></label>
		        		<form:input class="form-control" path="firstName"/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label>Last Name<span class="text-danger">*</span></label>
		        		<form:input class="form-control" path="lastName"/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label>Gender<span class="text-danger">*</span></label>
		        		<form:input class="form-control" path="gender"/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label>Email<span class="text-danger">*</span></label>
		        		<form:input class="form-control" path="email"/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label>Province<span class="text-danger">*</span></label>
		        		<form:input class="form-control" path="province"/>
		        	</div>
		        	
					<button type="submit" class="btn btn-info">Save</button>
		        </form:form>
        	</div>
        </div>
    		</div>
    		<div class="col-2"></div>
    	</div>
    </div>
</body>
</html>