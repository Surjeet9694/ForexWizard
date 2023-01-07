<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FxWizard | Report</title>
<%@include file="./base.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-confirmation2/dist/bootstrap-confirmation.min.js"></script>

</head>
<body style="background-color: #202124;">
		<nav class="navbar navbar-expand-xl navbar-dark bg-dark d-flex align-items-end">
			<a class="navbar-brand" href="/">Forex Wizard</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto ">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item active"><a class="nav-link" href="/report">Report</a></li>
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
		
		
	<div class="table-responsive">
		<table class="table mt-4 mb-4 text-white">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">S/B</th>
				<th scope="col">Pair</th>
				<th scope="col">Token</th>
				<th scope="col">Entry</th>
				<th scope="col">Stoploss</th>
				<th scope="col">Take Profit</th>
				<th scope="col">Status</th>
				<th scope="col">Pips</th>
				<th scope="col">Channel</th>
				<th scope="col">Action</th>
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
					<td class="${slRowColor } ${profit}">${data.get(i).sellBuy }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).pair }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).tokenNo }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).entryPoint }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).stopLoss }</td>       
					<td class="${slRowColor } ${profit}">${data.get(i).takeProfit }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).status }</td>
					<td class="${slRowColor } ${profit}">${data.get(i).pips }</td>
					<c:set var="VIP_color" value="" />
					<c:if test="${data.get(i).channel  == 'VIP' }">
						<c:set var="VIP_color" value="text-warning" />
					</c:if>
					
					<c:set var="FREE_color" value="" />
					<c:if test="${data.get(i).channel  == 'FREE'}">
						<c:set var="FREE_color" value="text-info" />
					</c:if>
					
					<c:set var="BOTH_color" value="" />
					<c:if test="${data.get(i).channel  == 'BOTH'}">
						<c:set var="BOTH_color" value="text-muted" />
					</c:if>
					<td class="${VIP_color } ${FREE_color} ${BOTH_color}">${data.get(i).channel }</td>
					<td><a href="/delete/${data.get(i).id }"  data-toggle="confirmation"><i
							class="fa-solid fa-trash text-danger m-2"></i></a> <a
						href="/update/${data.get(i).id }"><i
							class="fa-solid fa-pen-nib text-primary m-2"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>


		<!-- Add signal details -->
		<div class="container text-center mt-4">
			<a style="text-decoration : none;" href="/reportForm"><button type="button" class="btn btn-outline-info">Add new signal</button></a>
		</div>

<!-- This code is for delete confimation it is added in delete icon as "data-toggle="confirmation" --> 
<!-- Also add these 4 lines in head tag  -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-confirmation2/dist/bootstrap-confirmation.min.js"></script> -->




		
		<script>
		$('[data-toggle=confirmation]').confirmation({
		   rootSelector: '[data-toggle=confirmation]'
		});
		</script>
		
		
		
</body>
</html>