<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hibernate.utils.GetAllData"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>System Level Test</title>
</head>
<body>
<br>If you've reached this page:
<ul>
<li>The Tomcat server is running successfully.
<li>The application controller is functioning as intended.
</ul>
<br>

<%
String[] args = {};
GetAllData.main(args);
%>

If SQL data is listed above:
<ul>
<li>The SQL database server is running successfully.
<li>The database has been successfully queried.
<li>The Java application "GetAllData.java" is functioning as intended.
</ul>
<br>

</body>
</html>