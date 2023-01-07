<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FxWizard | Home</title>
<%@include file="./base.jsp"%>
</head>
<body style="background-color: #202124;">

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark d-flex align-items-end">
			<a class="navbar-brand" href="/">Forex Wizard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto ">
					<li class="nav-item active"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/report">Report</a></li>
					<li class="nav-item"><a class="nav-link" href="/purchase">Purchase</a></li>
					
					<li class="nav-item">
						<div class="dropdown" style="cursor:pointer;">
						  <a class="nav-link" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Subscribers
						  </a>
						  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    <a class="dropdown-item" href="/subscribers/${1}">1 Month</a>
						    <a class="dropdown-item" href="/subscribers/${6}">6 Month</a>
						    <a class="dropdown-item" href="/subscribers/${12}">1 Year</a>
						    <c:set var = "infinte" scope = "session" value = "infinite"/>  <!--declaring the variable infinite and setting the value ("infinite")-->
						 <a class="dropdown-item" href="/subscribers/${infinte}">Lifetime</a>
						  </div>
						</div>
				    </li>
					
					<li class="nav-item"><a class="nav-link" href="/about">About</a></li>
				</ul>
			
					<ul class="navbar-nav ml-auto ">
						<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
					</ul>
			</div>
		</nav>
		
		<!-- No data available -->
		<div class="text-white text-center m-5">
			<h1>Sorry No data available</h1>
		</div>
</body>
</html>