<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../../shared/admin/header.jsp"%>

<div class="border-bottom">
    <h2 class="text-capitalize">Product</h2>
    <h4>${action}</h4>
</div>

<form:form method="POST" action="${action}" modelAttribute="newUser" class="edit-form m-2 p-2">

    <div class="form-group">
        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" class="form-control"/>
        <form:errors path="firstName" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" class="form-control"/>
        <form:errors path="lastName" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="login">Login</form:label>
        <form:input path="login" class="form-control"/>
        <form:errors path="login" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:select path="role">
            <form:options items="${roles}" itemValue="name" itemLabel="name" />
        </form:select>
    </div>

    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:password path="password" class="form-control"/>
        <form:errors path="password" class="invalid-feedback d-block"/>
    </div>

    <div class="form-group">
        <form:label path="confirm">Confirm password</form:label>
        <form:password path="confirm" class="form-control"/>
        <form:errors path="confirm" class="invalid-feedback d-block"/>
    </div>

    <button type="submit" class="btn btn-outline-primary">Submit</button>
    <button type="reset" class="btn btn-outline-secondary">Reset</button>
</form:form>

<%@ include file="../../shared/admin/footer.jsp"%>