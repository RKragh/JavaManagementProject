<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-8">
<title>Insert title here</title>
<style>
td {
	color: blue;
	padding: 10px;
}
</style>
</head>
<body style="font-family: Arial">
	<%
		int num1, num2;
		String sNum1;
		String sNum2;
		int total = 0;
		if (request.getParameter("btnOK") != null) {
			num1 = Integer.parseInt(request.getParameter("txtFirstName"));
			num2 = Integer.parseInt(request.getParameter("powerOf"));
			sNum1 = "" + num1;
			sNum2 = "" + num2;
			total = num1;
			for (int i = 0; i < num2; i++) {
				total *= num1;
			}
		} else {
			num1 = 0;
			num2 = 0;
			sNum1 = "" + num1;
			sNum2 = "" + num2;
		}
	%>
	<form method="GET" action="powerof.jsp">
		Number: &nbsp;<input type="text" name="txtFirstName"
			value="<%=sNum1%>" />&nbsp; In the power of: &nbsp;<input
			type="text" name="powerOf" value="<%=sNum2%>" />&nbsp; <input
			type="submit" name="btnOK" value="OK" style="width: 80px" />&nbsp; <input
			type="reset" name="btnCancel" value="Cancel" style="width: 80px" />
	</form>

	<br /> Resultat af oplרftning:
	<table border="1">
		<%
			if (request.getParameter("btnOK") != null) {
		%>
		<tr>
			<td><%=total%>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>