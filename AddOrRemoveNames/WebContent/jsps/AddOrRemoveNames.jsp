<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	if (session.getAttribute("nameList") == null)
	{
		session.setAttribute("nameList", new ArrayList<String>());
	}
	
	ArrayList<String> arr = (ArrayList<String>)session.getAttribute("nameList");
	
	if (request.getParameter("btnAdd") != null)
	{
		
		arr.add(request.getParameter("inputName"));
	}
	else if (request.getParameter("btnDel") != null)
	{
		
		arr.remove(Integer.parseInt(request.getParameter("selectName")));
		
	}
%>
<form method="GET" action="./AddOrRemoveNames.jsp">
	Indtast Navn:
	<input type="text" name="inputName">
	<input type="submit" name="btnAdd" value="Tilføj Navn">
	<br>
	Vælg Navn:
	<select name="selectName">
	<% for (int i = 0; i < arr.size(); i++)
		{%>
		<option value="<%=i%>"><%=arr.get(i)%></option>
		<%}
	%>
	</select>
	<input type="submit" name="btnDel" value="Fjern Navn">
	</form>
</body>
</html>