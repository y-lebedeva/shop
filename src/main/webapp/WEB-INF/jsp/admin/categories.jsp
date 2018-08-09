<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../../shared/admin/header.jsp"%>

<h2 class="border-bottom">Categories</h2>

<p><a href="create">Create</a></p>

<table class="table table-sm table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Parent</th>
            <td>Update</td>
            <td>Delete</td>
        </tr>
    </thead>

    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>${category.parent.name}</td>
            <td><a href="${category.id}/update">Update</a></td>
            <td><a href="${category.id}/delete">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@ include file="../../shared/admin/footer.jsp"%>