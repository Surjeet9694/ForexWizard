<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FxWizard | Report</title>
<%@include file="./base.jsp"%>
<style>

h1{
	font-size : 52px;
	background: linear-gradient(270deg, #3f5efb, #fc466b);
	
	-webkit-background-clip : text;
	-webkit-text-fill-color : transparent;
}

	.my-card{
		
		margin-top : 55px;
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
		
		
		<!-- Form for signal report -->
		
		<div class="container-fluid">
	  
	  		<div class="container">
	  		
	  			<div class="col-md-6 offset-md-3">
	  			
		  			<div class="my-card">
		  			
						<h1 class="text-center mb-4 border-bottom text-muted">Update details</h1>

					<form action="${pageContext.request.contextPath }/update-handle" class="text-light">							 
					
						<input type="hidden" value="${data.id }" name="id" />
						<input type="hidden" value="${data.msgIdOfVipChannel }" name="msgIdOfVipChannel" />
						<input type="hidden" value="${data.msgIdOfFreeChannel }" name="msgIdOfFreeChannel" />
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="currency-pair">Currency Pair </label> <input type="text"
									class="form-control" name="pair" id="currency-pair"
									placeholder="Example : USDCHF" value="${data.pair }" required>
							</div>
							
							<div class="form-group col-md-4">
								<label for="buy-sell">Buy/Sell</label> 
								<select id="buy-sell" class="form-control" name="sellBuy"  required>
										<c:set var="Buy" value="" />
										<c:set var="Sell" value="" />
										
										<c:if test="${data.sellBuy  == 'buy' }">
											<c:set var="Buy" value="selected" />
										</c:if>
										<c:if test="${data.sellBuy  == 'sell' }">
											<c:set var="Sell" value="selected" />
										</c:if>
									<option class="text-success" value="Buy" ${Buy }>Buy</option>
									<option class="text-danger" value="Sell" ${Sell }>Sell</option>
								</select>
							</div>
							
							<div class="form-group col-md-4">
								<label for="channel-vip-free">Channel</label> 
								<select id="channel-vip-free" class="form-control" name="channel" required>
										<c:set var="VIP" value="" />
										<c:set var="FREE" value="" />
										<c:set var="BOTH" value="" />
										
										<c:if test="${data.channel  == 'VIP' }">
											<c:set var="VIP" value="selected" />
										</c:if>
										<c:if test="${data.channel  == 'FREE' }">
											<c:set var="FREE" value="selected" />
										</c:if>
										<c:if test="${data.channel  == 'BOTH' }">
											<c:set var="BOTH" value="selected" />
										</c:if>
									<option value="VIP" ${VIP }>VIP</option>
									<option value="FREE" ${FREE }>FREE</option>
									<option value="BOTH" ${BOTH }>BOTH</option>
								</select>
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group  col-md-6">
								<label for="order-date">Order Date</label> <input type="date"
									class="form-control" id="order-date" value="${data.orderDate }" name="orderDate"  required>
							</div>
							
							<div class="form-group  col-md-6">
								<label for="token-number">Token</label> <input type="text"
									class="form-control" name="tokenNo" value="${data.tokenNo }" id="token-number" placeholder="#XXXXXXXX">
							</div>
						</div>
						
						<div class="form-group">
							<label for="entry-point">Entry</label> <input type="text"
								class="form-control" name="entryPoint" id="entry-point" value="${data.entryPoint }" required placeholder="ex : 1.4352">
						</div>
						
						<div class="form-group">
							<label for="stoploss">Stoploss</label> <input type="text"
								class="form-control" name="stopLoss" id="stoploss" required value="${data.stopLoss }" placeholder="ex : 1.4352"> 
						</div>
						
						<div class="form-group">
							<label for="take-profit">Take Profit</label> <input type="text"
								class="form-control" name="takeProfit" id="take-profit" required value="${data.takeProfit }" placeholder="ex : 1.4352">
						</div>
						
						<div class="form-row">
							<div class="form-group  col-md-6">
									<label for="signal-status">Status </label> 
									<select class="form-control" name="status" id="signal-status" required>
									
										<c:set var="Running" value="" />
										<c:if test="${data.status  == 'Running' }">
											<c:set var="Running" value="selected" />
										</c:if>
									
										<c:set var="set_sl_to_entry" value="" />
										<c:if test="${data.status  == 'set sl to entry' }">
											<c:set var="set_sl_to_entry" value="selected" />
										</c:if>
									
										<c:set var="close_half_and_set_sl_to_entry" value="" />
										<c:if test="${data.status  == 'close half set sl to entry' }">
											<c:set var="close_half_and_set_sl_to_entry" value="selected" />
										</c:if>
										
										<c:set var="sl" value="" />
										<c:if test="${data.status  == 'Hit sl' }">
											<c:set var="sl" value="selected" />
										</c:if>
										
										<c:set var="tp" value="" />
										<c:if test="${data.status  == 'Hit tp' }">
											<c:set var="tp" value="selected" />
										</c:if>
										
										<c:set var="close" value="" />
										<c:if test="${data.status  == 'Closed with' }">
											<c:set var="close" value="selected" />
										</c:if>
										
										<option value="Running" ${Running }>Running</option>
										<option value="set sl to entry" ${set_sl_to_entry }>Running set sl to entry</option>
										<option value="close half set sl to entry" ${close_half_and_set_sl_to_entry }>Running close half and set sl to entry</option>
										<option value="Hit sl" ${sl }>Hit sl</option>
										<option value="Hit tp" ${tp }>Hit tp</option>
										<option value="Closed with" ${close }>Closed with</option>
									</select>
							</div>
							<div class="form-group  col-md-6">
								<label for="pip">Pips </label> <input type="text"
									class="form-control" name="pips" value="${data.pips }" id="pip"
									placeholder="Pips" required>
							</div>
						</div>
	
							
						<div class="container text-center mb-4 mt-3">
							<a href="${pageContext.request.contextPath}/report" class="btn btn-danger">back</a>
							 <button class="btn btn-success" type="submit">Save</button>
						</div>
					</form>

				</div>
	  			</div>
	  		
	  		</div>
	  	
	  </div>
</body>
</html>