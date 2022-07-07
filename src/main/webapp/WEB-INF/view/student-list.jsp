<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
<!-- jQuery library -->
<!--  Load local css-->
<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/my-style-sheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Student Management</title>
</head>
<body>
<h1 align="center"> Joe Technologies</h1>
<!--ModelAttribute : students-->
<div class="container">
     <form action="/student-management/showAddStudentPage">
<input class="btn btn-info" value="ADD" type="submit">
</form>
<table class="table table-striped">
<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th>Id No</th>
<th>Country</th>
<th>Action</th>

</tr>

<c:forEach var="student" items="${students}">
<tr>
<td>${student.id}</td>
<td>${student.name}</td>
<td>${student.mobile}</td>
<td>${student.idno}</td>
<td>${student.country}</td>
<td>
<a href="updateStudent?userId=${student.id}"><i class="fa fa-pencil-square-o" aria-hidden="true" style="color:green"></i></a>
<a href="deleteStudent?userId=${student.id}" onclick="return confirm('Are you sure you want to delete this student?');"><i class="fa fa-trash-o" aria-hidden="true"  style="color:red"></i></a>
</td>
</tr>
</c:forEach>



</table>
<img alt="fake students photo" src="/student-management/URLToReachResourcesFolder/images/student.png">
    </div>
  


</body>
</html>