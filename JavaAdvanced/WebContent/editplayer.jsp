<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="java.util.*,com.ltts.model.*,com.ltts.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Player</title>
</head>
<body>
<%
int home =Integer.parseInt(request.getParameter("name"));
PlayerDao pd = new PlayerDao();
Player p1= pd.getPlayerByName("name");

%>
<form action ="./UpdatePlayer" method= "post">
Name: <%=p1.getName() %> <br><br>
DOB: <input type="text" value="<%=p1.getDob()%>" name="dob"><br>
Matches: <input type="number" value="<%=p1.getMatches()%>" name="mat"><br>
Runs: <input type="number" value="<%= p1.getRuns()%>" name="run"><br>
Wickets: <input type="number" value="<%= p1.getWickets()%>" name="wic"><br>
<input type="submit" value="Update Player">

</form>
</body>
</html>