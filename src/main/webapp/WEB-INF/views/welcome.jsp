<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        @import url('https://fonts.googleapis.com/css?family=Abril+Fatface|Heebo|Raleway+Dots');
    </style>

    <link href="/resources/css/home.css" rel="stylesheet" >

</head>
<body>
<div class="fluid-container top">
    <div class="row">
<div class="col-lg-12 col-md-12 col-sm-12" style="border-bottom: 1px solid #D44D5C;">
<h1>BOOKMARKS</h1>
</div>
</div>
</div>

<div class="fluid-container">
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 formstyle">
            <h2>Add Link</h2>
<form action="/addLink">
    <div class="form-group">
    <label>Name</label>
    <input class="form-control" type="text" placeholder="Detroit Public Library Homepage" name="Name" required>
    </div>
    <div class="form-group">
    <label>Description</label>
    <input class="form-control" type="text" placeholder="Detroit Public Library Homepage" name="Description">
    </div>
    <div class="form-group">
    <label>Date</label>
    <input class="form-control" type="date" name="Date" required>
    </div>
    <div class="form-group">
    <label>URL</label>
    <input class="form-control" type="text" placeholder="http://www.detroit.lib.mi.us/" name="URL" required>
    </div>
    <div class="form-group">
    <label>Category</label>
    <input class=form-control" type="text" placeholder="Places" name="Category" required>
    </div>
    <input class="btn btn-default" type="submit" name="Add">
</form>
        </div>

        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" style="border-right: 1px solid #D44D5C; border-left: 1px solid #D44D5C;">
            <h2>Categories</h2>

<form action="/retrieveLinks">
            <c:forEach items="${categories}" var="item">
            <div style="min-height: 5em; min-width: 80%; border-bottom: 2px solid #484F4B;">
                <input type="submit" class="btn btn-link category" name="Category" value="${item.category}">
            </div>
    </c:forEach>
</form>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <h2>Recently Added</h2>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Category</th>
    </tr>
<c:forEach items="${bdata}" var="item">
<tr>
    <td><a class="links" href="${item.URL}">${item.name}</a></td>
    <td>${item.category}<br></td>
</tr>
</c:forEach>
</table>

        </div>
    </div>
</div>

</body>
</html>