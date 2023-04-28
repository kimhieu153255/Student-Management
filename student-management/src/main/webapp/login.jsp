<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<style>
.fullscreen{height:100vh; with:100%;}
</style>
</head>
<body >
	<div class=" fullscreen d-flex align-items-center justify-content-center">
		<div class="container h-3 bg-body-secondary py-5 px-3 rounded" style="min-height: 50%; width: 35%">
			<div class="container-fluid fs-1 text-center fw-semibold" style="margin-bottom: 20%;">Login</div>
			<div class="container-fluid">
				<form action="login" method="post" class="d-flex flex-column align-items-center">
					<input type="text" name="Username" placeholder="Username" style="line-height: 50px; width: 100%;" class="fw-medium fs-5 mb-3 border rounded px-3"/>
					<input type="password" name="Password" placeholder="Password" style="line-height: 50px; width: 100%;"  class="fw-medium fs-5 mb-3 border rounded px-3"/>
					<input class="btn btn-primary fw-medium" type="submit" value="Submit" style="line-height: 40px; width: 30%;">
				</form>
			</div>
		</div>
	</div>
</body>
</html>