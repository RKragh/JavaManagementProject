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

		if (session.getAttribute("Names1") == null) {
			session.setAttribute("Names1", new Integer(0));
		}
		if (session.getAttribute("NamesArr") == null) {
			session.setAttribute("NamesArr", new ArrayList<Integer>());
		}
		ArrayList<Integer> arr = (ArrayList<Integer>)session.getAttribute("NamesArr");
		int total = (Integer)session.getAttribute("Names1");
		if (request.getParameter("btnOK") != null) {
			int numbers = Integer.parseInt(request.getParameter("txtFirstName"));
			total += numbers;
			arr.add(total);
			session.setAttribute("Names1", total);
		}
	%>
	<form method="GET" action="Adder.jsp">
		Number One: &nbsp;<input type="text" name="txtFirstName" value=0 />&nbsp;
		<input type="submit" name="btnOK" value="OK" style="width: 80px" />&nbsp;
		<input type="reset" name="btnCancel" value="Cancel"
			style="width: 80px" />
	</form>
	<br /> Resultat af plus regnestykket:
	<table border="1">
		<%
			for (int i = 0; i < arr.size(); i++) {
		%>
		<tr>
			<td><%=arr.get(i)%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>