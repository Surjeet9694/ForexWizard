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
		  			
						<h1 class="text-center mb-4 border-bottom text-muted">Singal details</h1>

					<form action="report-handle" class="text-light">
							
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="currency-pair">Currency Pair </label>
								<select id="currency-pair" class="form-control" name="pair" required>	
									<option selected>Choose...</option>
									<option value="AUDCAD">AUDCAD</option>
									<option value="AUDCHF">AUDCHF</option>
									<option value="AUDJPY">AUDJPY</option>
									<option value="AUDNZD">AUDNZD</option>
									<option value="AUDUSD">AUDUSD</option>
									<option value="CADCHF">CADCHF</option>
									<option value="CADJPY">CADJPY</option>
									<option value="CHFJPY">CHFJPY</option>
									<option value="EURAUD">EURAUD</option>
									<option value="EURCAD">EURCAD</option>
									<option value="EURCHF">EURCHF</option>
									<option value="EURGBP">EURGBP</option>
									<option value="EURJPY">EURJPY</option>
									<option value="EURNZD">EURNZD</option>
									<option value="EURUSD">EURUSD</option>
									<option value="GBPAUD">GBPAUD</option>
									<option value="GBPCAD">GBPCAD</option>
									<option value="GBPCHF">GBPCHF</option>
									<option value="GBPJPY">GBPJPY</option>
									<option value="GBPNZD">GBPNZD</option>
									<option value="GBPUSD">GBPUSD</option>
									<option value="NZDCAD">NZDCAD</option>
									<option value="NZDCHF">NZDCHF</option>
									<option value="NZDJPY">NZDJPY</option>
									<option value="NZDUSD">NZDUSD</option>
									<option value="USDCAD">USDCAD</option>
									<option value="USDCHF">USDCHF</option>
									<option value="USDJPY">USDJPY</option>
									<option value="GOLD">GOLD</option>
								</select>
							</div>
							
							<div class="form-group col-md-4">
								<label for="buy-sell">Buy/Sell</label> 
								<select id="buy-sell" class="form-control" name="sellBuy" required>
									<option selected>Choose...</option>
									<option class="text-success" value="Buy">Buy</option>
									<option class="text-danger" value="Sell">Sell</option>
								</select>
							</div>
							
							<div class="form-group col-md-4">
								<label for="channel-vip-free">Channel</label> 
								<select id="channel-vip-free" class="form-control" name="channel" required>
									<option selected>Choose...</option>
									<option value="VIP">VIP</option>
									<option value="FREE">FREE</option>
									<option value="BOTH">BOTH</option>
								</select>
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group  col-md-6">
								<label for="order-date">Order Date</label> <input type="date"
									class="form-control" id="order-date" name="orderDate" required>
							</div>
							
							<div class="form-group  col-md-6">
								<label for="token-number">Token</label> <input type="text"
									class="form-control" name="tokenNo" id="token-number" placeholder="#XXXXXXXX">
							</div>
						</div>
						
						<div class="form-group">
							<label for="entry-point">Entry</label> <input type="text"
								class="form-control" name="entryPoint" id="entry-point" required placeholder="ex : 1.4352">
						</div>
						
						<div class="form-group">
							<label for="stoploss">Stoploss</label> <input type="text"
								class="form-control" name="stopLoss" id="stoploss" required placeholder="ex : 1.4352"> 
						</div>
						
						<div class="form-group">
							<label for="take-profit">Take Profit</label> <input type="text"
								class="form-control" name="takeProfit" id="take-profit" required placeholder="ex : 1.4352">
						</div>
						
						<div class="form-row">
							<div class="form-group  col-md-6">
								<label for="pip">Pips </label> <input type="text"
									class="form-control" name="pips" id="pip"
									placeholder="Pips">
							</div>
							<div class="form-group  col-md-6">
									<label for="signal-status">Status </label> 
									<select class="form-control" name="status" id="signal-status" disabled required>
										<option value="Running" Selected>Running</option>
									</select>
							</div>
						</div>
	
							
						<div class="container text-center mb-4 mt-3">
							<a href="${pageContext.request.contextPath}/report" class="btn btn-danger">back</a>
							 <button type="submit" class="btn btn-success">Save</button>
						</div>
					</form>

				</div>
	  			</div>
	  		
	  		</div>
	  	
	  </div>
</body>
</html>