<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="isloggedon.jsp"%>
<%@ page import="dk.tec.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../stylesheets/stylesheet.css">
<title>Login</title>
<meta charset="UTF-8">
</head>

<body>

	<header>
	<div class="h-container">
		<h1>
			<a href="./index.jsp" style="">Task management</a>
		</h1>
		<nav> <%
 	if (session.getAttribute("LoginOK") == null) {
 %> <a
			href="./login.jsp">Login</a> <%
 	}
 %> <a href="./task.jsp">Task</a> <a
			href="./device.jsp">Device</a> </nav>
	</div>
	<div class="clear"></div>
	</header>
	<!-- Main content goes from here -->
	<section class="middle">
	<div class="content-holder">

		<div class="text-container">


			<h1>Tasks</h1>

			<table>
				<tr>
					<th>Subject</th>
					<th>Room</th>
					<th>Date Created</th>
					<th>Deadline date</th>
				</tr>
				<%
					for (Task t : dbTools.returnList()) {
				%>
				<tr>
					<td><%=t.getTaskName()%></td>
					<td><%=t.getRoomLocation()%></td>
					<td><%=t.getFormattedDate(t.getCreateDate())%></td>
					<td><%=t.getFormattedDate(t.getDeadlineDate())%></td>
					<td><form method="GET" action="./edittask.jsp">
					<input type="hidden" name="idOfTask" value="<%=t.getpID()%>">
					<input type="submit" name="btnEditTask" value="More">
					</form></td>
					<td><form method="POST" action="../UpdateTaskServlet">
					<input type="hidden" name="idOfTask" value="<%=t.getpID()%>">
					<input type="submit" name="btnDelTask" value="Delete"></form> </td>
				</tr>
				<%
					}
				%>

			</table>
			
			<form action="./createtask.jsp" method="GET">
			<input type="submit" name="btnCreateTask" value="Create new">
			</form>

		</div>

	</div>
	</section>
	<!-- To here -->
	<div style="clear: both;"></div>
	<footer id="footer"> <!-- Footer content beginning -->
	<div class="container">
		<ul>
			<li class="left-box" style="text-align: right;">
				<p>
					Matti 2014<br> Mattestic & Co © 2014
				</p>
			</li>
			<li class="right-box">
				<ul>
					<li style="margin-top: 10px;"><a>INFORMATION</a></li>
					<li style="margin-top: 5px;"><a>CONTACTS</a></li>
					<li style="margin-top: 5px;"><a>LOCATIONS</a></li>
					<li style="margin-top: 5px;"><a>SUPPORT</a></li>
				</ul>
			</li>
		</ul>
	</div>

	</footer>
	<!-- Footer content ending -->

	<%
		session.removeAttribute("LoginOK");
	%>
</body>

</html>