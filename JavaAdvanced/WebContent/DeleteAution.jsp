<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*" %>
    <%@ page import = "com.ltts.model.Aution" %>
    <%@ page import = "com.ltts.dao.AutionDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Aution</title>
</head>
<body>
<% int name=Integer.parseInt(request.getParameter("id"));
AutionDao pd=new AutionDao();
Aution p1=pd.getAutionById(name);
%>
<form action="./DeleteAuction" method="post">
Aution Id Confirm : <input type="text" value = "<%=p1.getAutionId() %>" name = "aid"> <br><br>

<input type="submit" value="Delete Aution">

</form>
</body>
</html>