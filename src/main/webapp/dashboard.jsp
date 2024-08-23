<%@page import="io.mountblue.pojos.Request"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
table {
	width: 80%;
	margin: 0 auto 40px auto;
	border-collapse: collapse;
	table-layout: fixed;
}

th, td {
	padding: 10px;
	text-align: justify;
	border-bottom: 1px solid #ddd;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: wrap;
	height: 50px;
}

tbody {
	display: block;
	max-height: 400px;
	overflow-x: auto;
}

thead, tbody tr {
	display: table;
	width: 100%;
	table-layout: fixed;
	vertical-align:top;
}


#navbar {
text-align: right;
	margin: 20px 0 20px 0;
}

.navbar {
	display: flex;
}
</style>
</head>
<body>
	<%if(session.getAttribute("user")==null){
	response.sendRedirect("/login");
}
%>
	<nav class="navbar">
		<div class="collapse navbar-collapse" id="navbar">
			<div id="logout">
				<a href="logout">Logout </a>
			</div>
		</div>
	</nav>

	<h2>ACTIVE REQUESTS</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
			List<Request> allUnarchivedRequests = (List) request.getAttribute("allUnarchivedRequests");
				for (Request conatctRequest : allUnarchivedRequests) {
		%>
		<tr>
			<td><%=conatctRequest.getFullName()%></td>
			<td><%=conatctRequest.getEmail() %></td>
			<td><%=conatctRequest.getMessage() %></td>
			<td><%=conatctRequest.getStatus() %></td>
			<td>
				<form action="dashboard" method="post">
					<input type="hidden" name="id" value=<%=conatctRequest.getId()%>>
					<input type="hidden" name="status" value="Archive"> <input
						type="submit" value="Archive">
				</form>
			</td>
		</tr>
		<%
				}
		%>
	</table>
	<h2>ARCHIVED REQUESTS</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
			<th>Change Status</th>
		</tr>
		<%
				List<Request> allArchivedRequests = (List) request.getAttribute("allArchivedRequests");
				for (Request conatctRequest : allArchivedRequests) {
		%>
		<tr>
			<td><%=conatctRequest.getFullName()%></td>
			<td><%=conatctRequest.getEmail()%></td>
			<td><%=conatctRequest.getMessage()%></td>
			<td><%=conatctRequest.getStatus()%></td>
			<td>
				<form action="dashboard" method="post">
					<input type="hidden" name="id" value=<%=conatctRequest.getId()%>>
					<input type="hidden" name="status" value="Active"> <input
						type="submit" value="Active">
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>