<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${user.userName}</h2>
<div class="container">
<div class="row">
<div class="col-md-3"></div>
<div class="col-md-6">
<table class="table">
	<thead>
		<tr>
			<th>
			#ID
			</th>
			<th>
			Title
			</th>
			<th>
			Description
			</th>
			<th>
			Number Of Pages
			</th>
			<th>
			Actions
			</th>
			<tbody>
			<c:forEach items="${books }" var="book">
			<tr>
			
			<td><c:out value="${book.id }"/></td>
			<td><c:out value="${book.title }"/></td>
			<td><c:out value="${book.description }"/></td>
			<td><c:out value="${book.numberOfPages }"/></td>
			<td><a href="/edit/book/${book.id}" class="btn btn-warning"><i class="bi bi-pen"></i> Edit</a> <form action="/delete/book/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form></td>
			</c:forEach>
			</tbody>
</table>
</div>
<div class="col-md-3"></div>
</div>
</div>



</body>
</html>