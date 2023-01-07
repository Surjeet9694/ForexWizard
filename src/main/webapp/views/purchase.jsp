<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FxWizard | Purchase</title>
<%@include file="./base.jsp"%>
<style>
h1{
	font-size : 52px;
	background: linear-gradient(270deg, #3f5efb, #fc466b);
	
	-webkit-background-clip : text;
	-webkit-text-fill-color : transparent;
}
	.my-card{
		
		margin-top : 35px;
		padding-left: 20px;
		padding-right: 20px;
		padding-bottom: 2px;
		border-radius : 10px;
		}
</style>
</head>
<body style="background-color: #202124;">

		<nav class="navbar navbar-expand-lg navbar-dark bg-dark d-flex align-items-end">
			<a class="navbar-brand" href="/">Forex Wizard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto ">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/report">Report</a></li>
					<li class="nav-item active"><a class="nav-link" href="/purchase">Purchase</a></li>
					
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
		<!-- Purchase form -->
		<div class="container-fluid">
	  
	  		<div class="container">
	  		
	  			<div class="col-md-6 offset-md-3">
	  			
		  			<div class="my-card">
		  			
						<h1 class="text-center mb-4 border-bottom text-muted">Client Details</h1>

					<form action="/handle-purchase" class="text-light">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="first-name">First Name</label> <input type="text"
									class="form-control" id="first-name" name="firstName" placeholder="First Name"
									required>
							</div>
							<div class="form-group col-md-6">
								<label for="last-name">Last Name</label> <input
									type="text" class="form-control" name="lastName" id="last-name"
									placeholder="Last Name" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="email-id">Email</label> <input type="email"
								class="form-control" name="email" id="email-id"
								placeholder="Example : Jhon343@gmail.com" required>
						</div>
						
						<div class="form-group">
							<label for="purchase-date">Purchase Date</label> <input type="date"
								class="form-control" name="membershipPurchaseDate" id="purchase-date" required>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="membership-list">Membership</label> 
								<select id="membership-list" class="form-control" name="membership" required>
									<option selected>Choose...</option>
									<option value="1">One Month</option>
									<option value="6">Six Month</option>
									<option value="12">One Year</option>
									<option value="infinite">Lifetime</option>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label for="price-for-membership">Price</label> <input type="text"
								class="form-control" name="price" id="price-for-membership"
								placeholder="Membership price" required>
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="country-list">Country</label> 
								<input type="text" class="form-control" name="country" id="country-list"
								placeholder="Ex : INDIA">
								
							</div>
							<div class="form-group col-md-6">
								<label for="contact-number">Contact</label> <input type="text"
								class="form-control" name="number" id="contact-number"
								placeholder="XXXXX-XXXXX">
							</div>
						</div>
						
						<div class="container text-center mb-4 mt-3">
							<a href="${pageContext.request.contextPath}/" class="btn btn-danger">back</a>
							 <button type="submit" class="btn btn-success">Save</button>
						</div>
					</form>

				</div>
	  			</div>
	  		
	  		</div>
	  	
	  </div>
	  
</body>
</html>