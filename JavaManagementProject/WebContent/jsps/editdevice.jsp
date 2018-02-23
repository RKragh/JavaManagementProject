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
 		%> 
 		<a href="./login.jsp">Login</a> <%
 		}
 		%>
 		
		<a href="./task.jsp">Task</a> 
		<a	href="./device.jsp">Device</a> </nav>
	</div>
	<div class="clear"></div>
	</header>
	<!-- Main content goes from here -->
	<section class="middle">
	<div class="content-holder">

		<div class="text-container">
		<% 
		int id = Integer.parseInt(request.getParameter("idOfDevice"));
		Device d = new Device();
		d = dbTools.getDeviceById(id);	
		%> 

			<h1>Edit Device</h1> 
			<br>			
			<form action="../UpdateDeviceServlet" method="POST">
 
			<label>pID: <%= d.getpID() %></label>
			<br> <br>
			<label>Brand</label><br>
			<input type="Text" name="deviceBrand" value="<%= d.getBrandStr()  %>"> 
			<br>
			<label>Model</label><br>
			<input type="Text" name="model" value="<%= d.getModelStr() %>">
			<br>
			<label>Room</label><br>
			<input type="Text" name="roomLocation" value="<%= d.getRoomLocationStr() %>">
			<br>
			<label>Device type</label><br>
			<input type="Text" name="deviceType" value="<%= d.getDeviceTypeStr()  %>">
			<br>
			<input type="hidden" name="idOfDevice" value="<%=d.getpID() %>">
			<input type="submit" name="submit" value="Gem">
			
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