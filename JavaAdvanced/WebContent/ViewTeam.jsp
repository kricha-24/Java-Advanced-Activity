<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import = "java.util.*" %>
    <%@ page import = "com.ltts.model.Team" %>
    <%@ page import = "com.ltts.dao.TeamDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Team</title>
</head>
<body>
<% TeamDao pd=new TeamDao();
List<Team> li=pd.getAllTeams();%>

<table>
<tr>
<th>Team ID</th>
<th>Team Name</th>
<th>Owner Name</th>
<th>Coach Name</th>
<th>Captain ID</th>

</tr>
<%
for(Team t1:li){%>

	
	<tr>
	<td><%=t1.getTeamId() %></td>
	<td><%=t1.getTeamName() %>	</td>
	<td><%=t1.getOwnerName() %></td>
	<td><%=t1.getCoach() %></td>
	<td><%=t1.getCaptainId() %></td>
	<td><a href="editTeam.jsp?id=<%=t1.getTeamId()%>">Update Team Deets</a></td>
	<td><td><a href="deleteteam.jsp?id=<%=t1.getTeamName()%>">Delete Team Deets</a></td>
	</tr>
<%} %>
</table>
</body>
</html>