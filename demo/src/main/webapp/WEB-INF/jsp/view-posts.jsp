<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en" data-bs-theme="light">
<head>
    <title>View User's Posts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<div class="container-fluid py-5">
    <div class="p-5 mb-4 bg-body-tertiary rounded-3">
        <h1 class="text-body-emphasis">This is a JSP Demo</h1>
        <p class="lead">
        <table class="table table-stripped table-hover">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col">Body</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="posts">
                <tr>
                    <td>${posts.title}</td>
                    <td>${posts.body}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </p>
    </div>

    <div class="container-fluid py-5">
        <div class="p-5 text-center bg-body-tertiary rounded-3">
            <form action="posts" method="POST">
                <h1 class="text-body-emphasis">Add post</h1>
                <div class="mb-3">
                    <label for="postTitle" class="form-label">Title</label>
                    <input type="text" class="form-control" id="postTitle" name="title"
                           placeholder="Title">
                </div>
                <div class="mb-3">
                    <label for="postBody" class="form-label">Post</label>
                    <input type="text" class="form-control" id="postBody" name="body" placeholder="Body">
                </div>

                <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">Add post</button>
                </div>
            </form>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger" role="alert">${errorMessage}</div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>