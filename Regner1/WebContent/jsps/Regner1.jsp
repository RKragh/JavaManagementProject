<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Regner 1</title>
</head>
<body>
<form method="GET" action="./regner1.jsp">
<%
	int firstNum = 0;
	int secondNum = 0;
	int result = 0;
%>
	<table border="2" cellpadding="10">
	<col width="130">
		<tr>
			<td colspan="7"> Indtast to heltal og tryk på den ønskede operator </td>
		</tr>
		<tr>
			<td> </td>
			<%
				if (request.getParameter("firstNum") != null)
				{
					firstNum = Integer.parseInt(request.getParameter("firstNum"));
				}
			%>
			<td colspan="2"> <input type="text" name="firstNum" value="<%=firstNum%>""> </td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
				
		</tr>
		<tr>
			<td> <input type="submit" name="btnAdd" value="Add"> </td>
			<td> <input type="submit" name="btnSub" value="Sub"> </td>
			<td> <input type="submit" name="btnMul" value="Mul"> </td>
			<td> <input type="submit" name="btnDiv" value="Div"> </td>
			<td> <label>=</label> </td>
			<td colspan="2"> <input type="text" name="result" value="<%=result%>"> </td>
		</tr>
		<tr>	
		
			<%
				if (request.getParameter("secondNum") != null)
				{
					firstNum = Integer.parseInt(request.getParameter("secondNum"));
				}
			%>
			<td> <input type="text" name="secondNum" value="<%=secondNum%>""> </td>
	</table>
</form>
</body>
</html>