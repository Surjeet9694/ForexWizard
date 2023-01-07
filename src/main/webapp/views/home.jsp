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
		
		
	<!-- Showing the signal info  -->
	
	<div class="container-fluid">
		
		<div class="container">
			<div class="table-responsive">
			<table class="table mt-4 mb-4 text-white">
				<thead>
					<tr>
						<th scope="col">Date</th>
						<th scope="col">Pair</th>
						<th scope="col">Status</th>
						<th scope="col">Pips</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" begin="0" end="${data.size()-1}">
										
						<c:set var="slRowColor" value="" />
						<c:if test="${data.get(i).status  == 'Hit sl' }">
							<c:set var="slRowColor" value="text-danger" />
						</c:if>
						
						<c:set var="profit" value="" />
						<c:if test="${data.get(i).status  == 'Hit tp' || data.get(i).status == 'Closed with'}">
							<c:set var="profit" value="text-success" />
						</c:if>
						
						<tr>
							<td class="${slRowColor } ${profit}">${data.get(i).orderDate }</td>
							<td class="${slRowColor } ${profit}">${data.get(i).pair }</td>
							<td class="${slRowColor } ${profit}">${data.get(i).status }</td>
							<td class="${slRowColor } ${profit}">${data.get(i).pips }</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table> 
			</div>
		</div>
	
	</div>
	
</body>
</html>