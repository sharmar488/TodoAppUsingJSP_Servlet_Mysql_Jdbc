<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

 body{
 	display: flex;
 	flex-direction: column;
 	justify-content: flex-start;
 	margin: 0;
 	padding: 0;
 }
 .content{
 	display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 100px;
 }
 .header {
      background-color: cadetblue;
      width: 100%;
      height:80px;
      position:relative;
    }
 .signin-form {
      width: 440px;
      padding: 20px;
      background-color: #f0f0f0;
      border: 1px solid #ccc;
    }

    .signin-form input[type="text"],
    .signin-form input[type="password"] {
      width: 95%;
      padding: 10px;
      margin-bottom: 10px;
    }

    .signin-form button {
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
	</div>
  </div>
	<div class="content">
		<div class="signin-form">
			<h2>Registration Form</h2>
			<form method="post" action=sign_in>
			<input type="text" name="name" placeholder="Name">
			<input type="text" name="username" placeholder="Email">
			<input type="password" name="password" placeholder="Password">
			<button type="submit">Register</button>
			</form>
		</div>
	</div>
    
</body>
</html>