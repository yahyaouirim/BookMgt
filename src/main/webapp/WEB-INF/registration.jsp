<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>
<form:form action="/register" method="post" modelAttribute="user">
    <p>
        <form:label path="userName">UserName</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="confirm">confirm</form:label>
        <form:errors path="confirm"/>     
        <form:password  path="confirm"/>
    </p> 
     <input type="submit" value="Register"/>
     
  </form:form>
</body>
</html>