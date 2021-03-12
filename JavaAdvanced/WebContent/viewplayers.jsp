<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*,com.ltts.model.*,com.ltts.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Player</title>
</head>
<body>
<%
PlayerDao pd =new PlayerDao();
List<Player> li = pd.getAllPlayers();
%>
<table>
<tr>
<th>Name</th>
<th>DOB</th>
<th>Matches</th>
<th>Runs</th>
<th>Wickets</th>
</tr>
<%
for(Player p:li){
%>  
<tr>
<td><% p.getName(); %></td>
<td><% p.getDob(); %></td>
<td><% p.getMatches(); %></td>
<td><%p.getRuns(); %></td>
<td><%p.getMatches(); %></td>
<td><a href="editplayer.jsp?id=<%=p.getName()%>">Update Player Deets</a></td>
</tr>
<%} %>
</table>
</body>
</html>