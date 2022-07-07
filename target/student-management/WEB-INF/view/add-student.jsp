<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Student Management</title>
</head>
<body>
<div class="container">
<!-- create a spring form where user can enter data-->
<h3 alidgn="center">Add Student</h3>
<!--ModelAttribute : students-->

<form:form action="save-student" modelAttribute="student" method="POST" class="form">
<form:hidden path="id"/>
<div class="form-group">
<label>Name : </label>
<form:input path="name" class="form-control" placeholder="Enter Name"/>
</div>
<div class="form-group">
<label>Mobile : </label>
<form:input path="mobile" class="form-control" placeholder="Enter Mobile Number"/>
</div>
<div class="form-group">
<label>Id No : </label>
<form:input path="idno" class="form-control" placeholder="Enter National ID Number"/>
</div>
<div class="form-group">
<label>Country : </label>
<form:input path="country" class="form-control" placeholder="Enter Country"/>
</div>


<input type="submit" class="btn btn-sm btn-primary" value="Submit">
<input type="reset" class="btn btn-sm btn-info" value="Reset"> 
<br/>

</form:form>

</div>
</body>
</html>