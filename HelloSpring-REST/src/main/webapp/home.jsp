<!DOCTYPE html>
<html lang="en">
<head>
<title>Employee Management System</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="/Employee.js"></script>
<link rel="stylesheet" href="/Employee.css">
</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>Employee Management System</h1>
		</div>
	</div>

	<nav class="navbar navbar-inverse ">
		<div class="container-fluid text-center">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--  <a class="navbar-brand" href="#">Logo</a> -->
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav" id="myList">
					<li><a  onclick="selectPage()">Get Employee</a></li>
					<li><a  onclick="insertPage()">Add Employee</a></li>
					<li><a  onclick="updatePage()">Update Employee</a></li>
					<li><a  onclick="deletePage()">Delete Employee</a></li>
					<li><a  onclick="selectAllPage()">All Employee
							List</a></li>
				</ul>
				<!-- <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul> -->
			</div>
		</div>
	</nav>

	<div class="container text-center">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div id="divData">
					<p id="para1"></p>
					<p id="para2"></p>
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
	<br>
	<div class="container">
		<div class="row"></div>
	</div>
	<br>
	<footer class="container-fluid text-center">
		<p>Copyright @ smartek</p>
	</footer>
</body>
</html>
