<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Login</title>
<style>
body {
	background-color: gainsboro;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

#main {
	background-color: white;
	padding: 10px;
	width: 50%;
	min-width: 500px;
	margin: 0 auto;
}

#form-title {
	background-color: gainsboro;
	padding: 20px;
	margin-bottom: 20px;
}

#form-title h1 {
	margin: 0;
}

#form-title p {
	margin: 0;
}

#form-div {
	padding: 15px;
	display: flex;
	flex-direction: column;
}

label {
	display: flex;
	gap: 5px;
	margin-top: 10px;
	font-weight: bold;
}

.mandatory {
	color: red;
	font-weight: bold;
}

input[type="text"], input[type="password"], textarea {
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	width: 100%;
	box-sizing: border-box;
	/* Ensure padding and border are included in width */
}

textarea {
	resize: vertical; /* Allow vertical resizing */
	min-height: 100px; /* Set a minimum height for the textarea */
}

input[type="submit"] {
	margin: 10px auto;
	font-weight: bold;
	padding: 10px 20px;
	border: none;
	background-color: gray;
	color: white;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div id="main">
		<div id="home">
			<a href="welcome.jsp">HOME</a>
		</div>
		<div id="form-title">
			<h1>Admin Login</h1>
			<p>This is admin login page</p>
		</div>
		<div id="form-div">
			<form action="login" method="post">
				<label for="username">Enter username<span class="mandatory">*</span></label>
				<input type="text" id="username" name="username" required> <label
					for="password">Enter password<span class="mandatory">*</span></label>
				<input type="password" id="password" name="password" required>
				<%if(request != null){
					%><p style="color: red;">Incorrect username or password. Please try again.</p><%
				} %>

				<label for="submit"></label> <input type="submit" value="LOGIN">
			</form>
		</div>
	</div>

</body>
</html>
