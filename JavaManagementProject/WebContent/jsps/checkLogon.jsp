<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dk.tec.dbTools" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		if (user == "" || password == "")
		{
			response.sendRedirect("login.jsp");
			return;
		}
		dbTools db = new dbTools();
		boolean ok = db.checkUser(user, password);
		
		if (ok == true)
		{
			session.setAttribute("LoginOK", true);
			response.sendRedirect("index.jsp");
		
		}	else
		{
			response.sendRedirect("login.jsp");
		}	%>


</body>
</html>