<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Student Management</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
  	<style>
  		li:hover{
  			background-color: #6c757d;
  			border-radius: 10px;
  			transition: all 0.3s ease;
  			transition-delay: 0.00001s;
  		}
  		li:hover a span{
  			color: white;
  		}
  	</style>
  
  </head>
  <body>
  <div class="d-flex">
  	<div class="d-flex flex-column flex-shrink-0 p-3 bg-light border-end" style="width: 260px; min-height: 100vh;">
  		<a href="home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
	      <img alt="Logo" src="https://w7.pngwing.com/pngs/1008/532/png-transparent-wolf-logo-symbol.png" style="with:100px;height: 100px; border-radius: 100%">
	      <span class="fs-5 fw-bold">Student Management</span>
    	</a>
    	<hr>
	    <ul class="nav nav-pills flex-column mb-auto">
	      <li>
	        <a href="home" class="nav-link link-dark d-flex align-items-center fs-5" aria-current="page">
	          <ion-icon name="people-outline"></ion-icon>
			  <span class="ms-2">Students</span>
	        </a>
	      </li>
	      <li >
	        <a href="course-list" class="nav-link link-dark d-flex align-items-center fs-5">
	          <ion-icon name="grid-outline"></ion-icon>
	          <span class="ms-2">Courses</span>
	        </a>
	      </li>
	      <li>
	        <a href="courses-of-student" class="nav-link link-dark d-flex align-items-center fs-5">
	          <ion-icon name="search-outline"></ion-icon>
	          <span class="ms-2">Student's Courses</span>
	        </a>
	      </li>
	      <li>
	        <a href="score-student" class="nav-link link-dark d-flex align-items-center fs-5" >
	          <ion-icon name="search-outline"></ion-icon>
	          <span class="ms-2">Scores Board</span>
	        </a>
	      </li>
	    </ul>
  	</div>
  	<div class="container-fluid">
	    <div class="text-center my-5 fs-3 fw-bold">Student's Scores</div>
	    	<form action="score-student" method="post" class="d-flex mx-auto justify-content-center">
				<input type="number" name="Year" placeholder="Year" class="fw-medium fs-5 border rounded px-3 me-1" value="${Year}"/>
				<input type="number" name="StudentId" placeholder="Student ID" class="fw-medium fs-5 border rounded px-3 me-1" value="${StudentId}"/>
				<button type="submit" class="btn btn-outline-secondary fw-medium">Search</button>
			</form>
 			<div class="fs-4 fw-semibold text-danger">${error}</div>
 			<c:if test="${not empty scores}">
			    <div class="container border  border-0 border-secondary mt-3" >
				    <div class="container-fluid border rounded bg-body-tertiary" style="overflow: auto; height: 400px">
				   	    <table class="table">
					      <thead>
					        <tr>
					          <th scope="row" class="text-center">ID</th>
					          <th scope="row" class="text-center">Name</th>
					          <th scope="row" class="text-center">Lecturer</th>
					          <th scope="row" class="text-center">Score</th>
					          <th scope="row" class="text-center">Notes</th>
					        </tr>
					      </thead>
					      <tbody>
					        <c:forEach var="t" items="${scores}">
					          <tr>
					            <td class="text-center">${t.getId()}</td>
					            <td class="text-center">${t.getName()}</td>
					            <td class="text-center">${t.getLecturer()}</td>
					            <td class="text-center">${t.getYear()}</td>
					            <td class="text-center">${t.getNotes()}</td>
					          </tr>
					        </c:forEach>
					      </tbody>
					    </table>
				    </div>
	   	 		</div>
	   	 	</c:if>
   		</div>
	</div>
  </body>
</html>
