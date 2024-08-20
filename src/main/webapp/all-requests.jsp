<%@page import="io.mountblue.pojos.ContactRequest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 40px;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
</style>

</head>
<body>
	<div id="home">
		<a href="welcome.jsp">HOME</a>
	</div>

	ACTIVE REQUESTS
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
		</tr>
		<%
		List<ContactRequest> allUnarchivedRequests = (List) request.getAttribute("allUnarchivedRequests");
		for (ContactRequest conatctRequest : allUnarchivedRequests) {
		%>
		<tr>
			<td><%=conatctRequest.getFullName()%></td>
			<td><%=conatctRequest.getEmail()%></td>
			<td><%=conatctRequest.getMessage()%></td>
		</tr>
		<%
		}
		%>
	</table>

	ARCHIVED REQUESTS
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
		</tr>
		<%
		List<ContactRequest> allArchivedRequests = (List) request.getAttribute("allArchivedRequests");
		for (ContactRequest conatctRequest : allArchivedRequests) {
		%>
		<tr>
			<td><%=conatctRequest.getFullName()%></td>
			<td><%=conatctRequest.getEmail()%></td>
			<td><%=conatctRequest.getMessage()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>