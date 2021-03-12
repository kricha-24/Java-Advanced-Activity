<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*" %>
    <%@ page import = "com.ltts.model.*" %>
    <%@ page import = "com.ltts.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Player</title>
</head>
<body>
<% String name=request.getParameter("id");
PlayerDao pd=new PlayerDao();
Player p1=pd.getPlayerByName(name);
%>
<form action="./DeletePlayer" method="post">
Player Name Confirm: <input type="text" value = "<%=p1.getName() %>" name = "pname"> <br><br>

<input type="submit" value="Delete Player">

</form>
</body>
</html>