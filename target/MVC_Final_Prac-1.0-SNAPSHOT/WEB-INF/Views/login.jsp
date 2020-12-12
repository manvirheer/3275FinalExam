<%--
  Created by IntelliJ IDEA.
  User: cjjc2
  Date: 2020-11-18
  Time: 12:28 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yahoo!!</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">

    <style>

        h1 {

            text-align:center;
        }
    </style>
</head>
<body>
<p><font color="red">${errorMessage}</font></p>

<h1>Log In</h1>
<div class="container">
<form action="login.do" method="POST">

    <fieldset class="form-group">
    <label>Name :</label>
    <input name="username" type="text" class="form-control" />

    </br>

    <label>Password :</label>
     <input name="password" type="password" class="form-control"/>

    </fieldset>
    <input class="btn btn-success" type="submit" />
</form>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
