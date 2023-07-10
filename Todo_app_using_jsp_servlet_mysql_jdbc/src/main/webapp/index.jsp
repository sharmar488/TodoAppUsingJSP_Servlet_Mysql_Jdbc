<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <style>
    body {
      display: flex;
      flex-direction: column;
      justify-content: flex-start;
      align-items: center;
      min-height: 100vh;
      margin: 0;
      padding: 0;
    }

    .header {
      background-color: cadetblue;
      width: 100%;
      height:80px;
      position:relative;
    }
    .lgn{
		position: absolute;
		right: 100px;
		top:25px;
		color: black;
		background-color: transparent;
		border: None;
		cursor: pointer;
		font-size: 20px;
	}
	.sgn{
		position: absolute;
		right:30px;
		top:25px;
		background-color: transparent;
		color:black;
		border: None;
		font-size: 20px;
		cursor:pointer
	}

    .footer {
      position: absolute;
      bottom: 0;
      width: 100%;
      height: 50px;
      background-color: cadetblue;
    }

    .content {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 80px;
    }

    .login-form {
      width: 340px;
      padding: 20px;
      background-color: #f0f0f0;
      border: 1px solid #ccc;
    }

    .login-form input[type="text"],
    .login-form input[type="password"] {
      width: 90%;
      padding: 10px;
      margin-bottom: 10px;
    }

    .login-form button {
      width: 100%;
      padding: 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <div class="header">
    <div>
		<h1 style="padding-left:10px; padding-bottom: 20px;">TODO App</h1>
		  <a href="./index.jsp"><button class="lgn" name="login">Login </button></a>
		<a href="./sign_in.jsp"><button class="sgn" name="sign">SignIn</button></a>
	</div>
  </div>
  
  <div class="content">
    <div class="login-form">
      <!-- Login form content -->
      <h2>Login</h2>
      <form method="post"  action=login>
        <input type="text" placeholder="Username" name="username" required>
        <input type="password" placeholder="Password" name="password" required>
        <button type="submit">Login</button>
      </form>
    </div>
  </div>
  <% Boolean invalidUser = (Boolean) request.getAttribute("invalidUser"); %>

<%-- Check if user is invalid and show an alert --%>
<% if (invalidUser != null && invalidUser) { %>
  <script>
    alert("Invalid user. Please enter a valid username and password.");
  </script>
<% } %>
  <div class="footer">
    
  </div>
</body>
</html>