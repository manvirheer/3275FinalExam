<%--
  Created by IntelliJ IDEA.
  User: Manvir Heer
  Date: 2020-12-11
  Time: 10:08 p.m.
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        h1 {

            text-align: center;
        }
    </style>

</head>
<body>

<%--<h1>Todos for ${name}</h1>--%>
<%--<h1>Your Todos are</h1>--%>

<%--${todos}--%>

<%--<a class="button" href="add-todo">Add</a>--%>


<H1>Your Todos</H1>

<h1>Hi ${name}</h1>


<div class="container">
    <table class="table table-striped">
        <caption>Your Todos are</caption>

        <thead>
        <tr>
            <th>Details</th>
            <th>Time on Creation</th>
            <th>Priority</th>
        </tr>
        </thead>



        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.getItem()}</td>
                <td>${todo.getTime()}</td>
                <td>${todo.getPriority()}</td>
                <td>

                    <a type="button" class="btn btn-primary"
                       href="update-todo?id=${todo.getId()}">Edit</a>

                    <a type="button" class="btn btn-warning"
                       href="delete-todo?id=${todo.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div>
        <a class="btn btn-success" href="addTodo">Add</a>
    </div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
