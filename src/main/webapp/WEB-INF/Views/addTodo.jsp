<%--
  Created by IntelliJ IDEA.
  User: Manvir Heer
  Date: 2020-12-11
  Time: 11:11 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container">
    <h1>Add an entry</h1>
    <form method="POST" >
        <fieldset class="form-group">
            <label> Description :</label>
            <input name="item" type="text" class="form-control" required />
        </fieldset>

        <fieldset class="form-group">
            <label> Priority :</label>
            <input name="priority" type="text" class="form-control" required />
        </fieldset>


        <fieldset class="form-group">
            <label> Time :</label>
            <input name="time" type="text" class="form-control" required />
        </fieldset>


        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
