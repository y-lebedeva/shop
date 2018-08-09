<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/header.jsp"%>

<div class="auth-form container m-auto">
    <h4 class="text-center">Авторизация</h4>

    <form:form method="POST" action="/login" modelAttribute="user">

        <div class="form-group">
            <form:input path="login" class="form-control" placeholder="Логин" />
        </div>

        <div class="form-group">
            <form:password path="password" class="form-control" placeholder="Пароль" />
        </div>

        <div class="form-group d-flex justify-content-center">
            <button class="btn btn-primary" type="submit">Вход</button>
        </div>

        <form:errors path="login" class="d-block alert alert-danger" role="alert" />

    </form:form>

    <p class="text-center"><a href="/registration">Регистрация</a></p>
</div>

<%@include file="../shared/footer.jsp"%>