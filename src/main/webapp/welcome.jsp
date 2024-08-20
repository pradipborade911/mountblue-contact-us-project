<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us Project</title>
</head>
<body>
	<a href="login.jsp">Admin Login</a>
	<div>
		<a href="contactus.jsp">Contact Us</a>
		<%Object isSubmitSuccess = request.getAttribute("isSubmitSuccess");
    %>
		<%if(isSubmitSuccess != null && (boolean)isSubmitSuccess == true){
        %><p>Thank you for reaching out to us. We will review your
			inquiry and respond to you as soon as possible.</p>
		<%
    } %>
	</div>
</body>
</html>