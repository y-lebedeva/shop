<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../../shared/admin/header.jsp"%>

<div class="border-bottom">
    <h2 class="text-capitalize">Product</h2>
    <h4>${action}</h4>
</div>

<form:form method="POST" action="${action}" modelAttribute="product" class="edit-form m-2 p-2">

    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:input path="name" class="form-control"/>
        <form:errors path="name" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:textarea path="description" rows="3" class="form-control"/>
        <form:errors path="description" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="price">Price</form:label>
        <form:input path="price" class="form-control"/>
        <form:errors path="price" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:input path="amount" class="form-control"/>
        <form:errors path="amount" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="category">Category</form:label>
        <form:select path="category" class="custom-select">
            <form:option value="${null}" label="--Please Select"/>
            <form:options items="${categories}" itemValue="id" itemLabel="name"/>
        </form:select>
    </div>

    <button type="submit" class="btn btn-outline-primary">Submit</button>
    <button type="reset" class="btn btn-outline-secondary">Reset</button>
</form:form>

<%@ include file="../../shared/admin/footer.jsp"%>