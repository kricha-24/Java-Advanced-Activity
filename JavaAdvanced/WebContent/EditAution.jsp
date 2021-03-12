<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.*" %>
    <%@ page import = "com.ltts.model.Aution" %>
    <%@ page import = "com.ltts.dao.AutionDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Aution</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
AutionDao pd=new AutionDao();
Aution p1=pd.getAutionById(id);
%>
<form action="./UpdateAution" method="post">
Aution Id: <input type="hidden" value = "<%=p1.getAutionId() %>" name = "aid"> <br><br>
Bidding Price : <input type="number" value="<%=p1.getPrice() %>" name="aprice"> <br><br>
<input type="submit" value="Update Aution">

</form>
</body>
</html>