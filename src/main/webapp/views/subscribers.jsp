<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FxWizard | Subscribers</title>
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
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/report">Report</a></li>
					<li class="nav-item"><a class="nav-link" href="/purchase">Purchase</a></li>
					
					<li class="nav-item">
						<div class="dropdown" style="cursor:pointer;">
						  <a class="nav-link active" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
		
		
		<div class="table-responsive">
		<table class="table mt-4 mb-4 text-white">
		<thead>
			<tr>
				<th scope="col">S.N.</th>
				<th scope="col">Reg.Id</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Country</th>
				<th scope="col">Contact</th>
				<th scope="col">Membership</th>
				<th scope="col">Price</th>
				<th scope="col">Purchase Date</th>
				<th scope="col">Expiry Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="i" begin="0" end="${purchase.size()-1}">
				<tr >
					<td>${i+1}</td>
					<td>${purchase.get(i).id }</td>
					<td>${purchase.get(i).firstName } ${purchase.get(i).lastName }</td>
					<td>${purchase.get(i).email }</td>
					<td>${purchase.get(i).country }</td>
					<td>${purchase.get(i).number }</td>
						<c:set var="membership" value="${purchase.get(i).membership }"/>
					<c:if test="${purchase.get(i).membership  == 'infinite' }">
						<c:set var="membership" value="Lifetime" />
					</c:if>
					<td>${membership }</td>       <!-- Here we are using only membership variable cuz purchase.get(i).membership get value of membership ("infinite") -->
					<td>${purchase.get(i).price }</td>
					<td>${purchase.get(i).membershipPurchaseDate }</td>
					<td>${purchase.get(i).membershipExpiryDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>