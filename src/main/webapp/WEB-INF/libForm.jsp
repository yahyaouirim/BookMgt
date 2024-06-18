<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Book</h1>
<form:form action="/lib" method="post" modelAttribute="lib">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="location">Location</form:label>
        <form:errors path="location"/>
        <form:textarea path="location"/>
    </p>
     
    <input type="submit" value="Submit"/>
</form:form>  
</body>
</html>