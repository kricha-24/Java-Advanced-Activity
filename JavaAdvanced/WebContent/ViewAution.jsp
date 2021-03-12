<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.*" %>
     <%@ page import = "com.ltts.model.Aution" %>
     <%@ page import = "com.ltts.dao.AutionDao" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Aution</title>
</head>
<body>
<% AutionDao pd = new AutionDao();
List<Aution> li= pd.getAllAutions();%>
<table>
<tr>
<th>Auction ID</th>
<th>Player ID</th>
<th>Team ID</th>
<th>Year Of Buy</th>
<th>Price</th>

</tr>
<%
for(Aution p1:li){%>

	
	<tr>
	<td><%=p1.getAutionId() %></td>
	<td><%=p1.getPlayerID() %>	</td>
	<td><%=p1.getTeamId() %></td>
	<td><%=p1.getYear() %></td>
	<td><%=p1.getPrice() %></td>
	<td><a href="editAution.jsp?id=<%=p1.getAutionId()%>">Update Aution Deets</a></td>
	<td><a href="deleteAution.jsp?id=<%=p1.getAutionId()%>">Delete Aution Deets</a></td>
	</tr>
<%} %>

</table>
</body>
</html>