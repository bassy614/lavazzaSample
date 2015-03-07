<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.Date"
%>
<%
	Date date = new Date();
	String dateStr = date.toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家CONサンプル</title>
</head>
<body>
<p>これは家CONのサンプルです<br>
現在の時刻は<%= dateStr %>です</p>
</body>
</html>