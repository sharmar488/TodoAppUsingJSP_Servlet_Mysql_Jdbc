<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     <%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
     <%@ include file="common\header.html" %>
 <%--    <%@ include file="common\footer.html" %>--%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo's List</title>
<style type="text/css">
.mytodo{
 background-color: cadetblue;
 }
 .my-link{
 color:black;
 font-size: 20px;
 }
 
</style>
<link rel="stylesheet"
 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
 integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
 crossorigin="anonymous">
</head>
<body>
<header>
<ul class="mytodo">
    <li><a href="<%=request.getContextPath()%>/list"
     class="my-link">My Todos</a></li>
   </ul>
 </header>
 <div class="row">
  <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

  <div class="container">
   <h3 class="text-center" style="margin-top: 20px;">List of Todos</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Todo</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Title</th>
      <th>Target Date</th>
      <th>Todo Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (Todo todo: todos) {  -->
     <c:forEach var="todo" items="${listTodo}">

      <tr>
       <td><c:out value="${todo.title}" /></td>
       <td><c:out value="${todo.targetDate}" /></td>
       <td><c:out value="${todo.status}" /></td>

       <td><a href="edit?id=<c:out value='${todo.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="delete?id=<c:out value='${todo.id}' />">Delete</a></td>

       <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>
</body>
</html>