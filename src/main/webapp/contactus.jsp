<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us</title>
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
	width: 35%;
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

input[type="text"], textarea {
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

#navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 0 0 20px 0;
}

}
.navbar {
	display: flex;
}
</style>
</head>
<body>
	<nav id="navbar">
		<div id="home">
			<a href="login">Admin Login </a>
		</div>
	</nav>
	<div id="main">
		<%Object isSubmitSuccess = request.getAttribute("isSubmitSuccess");
    %>
		<%if(isSubmitSuccess != null && (boolean)isSubmitSuccess == true){
        %><p style="color: green;">We have received your message.
			Thank you for reaching out.</p>
		<p style="color: #333333;">You are welcome to send us another
			inquiry at any time.</p>
		<%
    } %>

		<div id="form-title">
			<h1>Contact Us</h1>
			<p>Please fill this form in a decent manner</p>
		</div>
		<div id="form-div">
			<form action="contactus" method="post">
				<label for="fullName">Full Name<span class="mandatory">*</span></label>
				<input type="text" id="fullName" name="fullName" required> <label
					for="email">E-mail<span class="mandatory">*</span></label> <input
					type="text" id="email" name="email" required> <label
					for="message">Message<span class="mandatory">*</span></label>
				<textarea id="message" name="message" required></textarea>

				<input type="submit" value="SUBMIT">
			</form>
		</div>
	</div>

</body>
</html>
