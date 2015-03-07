<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.Date"
%>
<%
	Date date = new Date();
	String dateStr = date.toString();
	boolean isRunning = (Boolean) session.getAttribute("isRunning");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家CONサンプル</title>
</head>
<body>
<p>
これは家CONのサンプルです<br>
現在の時刻は<%= dateStr %>です
</p>
<% if( isRunning == false ){ %>
	<!-- isRunningがfalseの時 -->
	<form method="post" action="/lavazzaSample/SampleServlet?isRunning=true">
	<input type="submit" value="start">
	</form>
<% } else { %>
	<!-- isRunningがtrueの時 -->
	<form method="post" action="/lavazzaSample/SampleServlet?isRunning=false">
	<input type="submit" value="stop">
	</form>
<% } %>
</body>
</html>