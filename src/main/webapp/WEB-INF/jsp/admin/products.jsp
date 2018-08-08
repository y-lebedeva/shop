<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../../shared/admin/header.jsp"%>

<h2 class="border-bottom">Products</h2>

<p><a href="create">Create</a></p>

<table class="table table-sm table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th>Category</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
    </thead>

    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.amount}</td>
            <td>${product.category.name}</td>
            <td><a href="${product.id}/update">Update</a></td>
            <td><a href="${product.id}/delete">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@ include file="../../shared/admin/footer.jsp"%>