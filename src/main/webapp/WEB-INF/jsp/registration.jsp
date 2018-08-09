<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/header.jsp"%>

<div class="reg-form container m-auto">
    <h4 class="text-center">Регистрация</h4>

    <form:form method="POST" action="/registration" modelAttribute="user">

        <div class="form-group">
            <form:input path="firstName" class="form-control" placeholder="Имя" autocomplete="off" />
            <form:errors path="firstName" class="d-block invalid-feedback" role="alert" />
        </div>

        <div class="form-group">
            <form:input path="lastName" class="form-control" placeholder="Фамилия" autocomplete="off" />
            <form:errors path="lastName" class="d-block invalid-feedback" role="alert" />
        </div>

        <div class="form-group">
            <form:input path="login" class="form-control" placeholder="Логин" autocomplete="off" />
            <form:errors path="login" class="d-block invalid-feedback" role="alert" />
        </div>

        <div class="form-group">
            <form:password path="password" class="form-control" placeholder="Пароль" />
            <form:errors path="password" class="d-block invalid-feedback" role="alert" />
        </div>

        <div class="form-group">
            <form:password path="confirm" class="form-control" placeholder="Повторите пароль"/>
            <form:errors path="confirm" class="d-block invalid-feedback" role="alert" />
        </div>
        
        <div class="form-group d-flex justify-content-center">
            <button class="btn btn-primary" type="submit">Зарегистрироваться</button>
        </div>

    </form:form>

    <p class="text-center"><a href="/login">Авторизация</a></p>
</div>

<%@include file="../shared/footer.jsp"%>