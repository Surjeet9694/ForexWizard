<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="./base.jsp"%>
<!-- 
<style>
.my-card {
	margin-top: 50px;
	padding-left: 20px;
	padding-right: 20px;
	padding-bottom: 2px;
	border-radius: 10px;
}
</style>
background: rgb(9,88,121);
background: linear-gradient(90deg, rgba(9,88,121,1) 0%, rgba(255,85,0,1) 100%);    


 background: rgb(9,88,121);
background: linear-gradient(90deg, #17ffc6 0%, #03448c 100%);  

background: linear-gradient(90deg, #051E22 0%, #5A944D 100%);

-->
 
 <style>
 /* Change Autocomplete styles in Chrome*/
input:-webkit-autofill,
input:-webkit-autofill:hover, 
input:-webkit-autofill:focus,
textarea:-webkit-autofill,
textarea:-webkit-autofill:hover,
textarea:-webkit-autofill:focus,
select:-webkit-autofill,
select:-webkit-autofill:hover,
select:-webkit-autofill:focus {
  border: 1px solid green;
  -webkit-text-fill-color: #fff;
  transition: background-color 5000s ease-in-out 0s;
}

 @import "https://use.fontawesome.com/releases/v5.5.0/css/all.css";
html {
  height: 100%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(90deg, #051E22 0%, #5A944D 100%);
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 360px;
  padding: 60px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 2em;
  padding: 0;
  color: #1da4f2;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  
  padding: 10px 0;
  font-size: 19px;
  color: #fff;
  margin-bottom: 28px;
  border: none;
  border-bottom: 1px solid #fff;
  width:100%;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #1da4f2;
  font-size: 1em;
  border-radius: 1em;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #1da4f2;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}

.login-box a:hover {
  border-radius: 5px;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #1da4f2);
  animation: btn-anim1 .5s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #1da4f2);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #1da4f2);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,100% {
    bottom: 100%;
  }
}
 
 </style>
</head>
<body style="background-color: #202124;">

	 

	<!-- Login form -->
	<div class="login-box">
    	 <h2>Login</h2>
   		 <form method="POST" action="/login" id="loginform">
           <div class="user-box">
              <input type="text" name="username" required>
              <label>Username</label>
           </div>
           <div class="user-box">
              <input type="password" name="password" required>
              <label>Password</label>
           </div>
	       <a href="#" onclick="myFunction()">
	         <span></span>
	         <span></span>
	         <span></span>
	         <span></span>
	         Submit
	       </a>
   	    </form>
   </div>
	
	<script>
		function myFunction(){
			document.getElementById("loginform").submit();
		}
	</script>


	<!-- Purchase form -->
	<!-- <div class="d-flex align-items-center justify-content-center" style="height: 92vh; width : 100% ">
		
		<div class="container">

			<div class="col-md-6 offset-md-3 text-white">

				<div class="my-card">

					<form method="POST" action="/login" class="form-signin">
						<h2 class="form-heading text-center">Log in</h2>
						<div class="form-group">
							<label>Username</label> <input name="username" type="text"
								class="form-control" placeholder="Username" required />
						</div>
						<div class="form-group">
							<label>Password</label> <input name="password" type="password"
								class="form-control" placeholder="Password" required />
						</div>

						<div class="container text-center mb-4 mt-3">
							<button type="submit" class="btn btn-success">Login</button>
						</div>
					</form>

				</div>
			</div>

		</div>

	</div> 
 -->
</body>
</html>