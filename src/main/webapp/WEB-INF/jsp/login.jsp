<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h4>Авторизация</h4>

<form:form method="POST" action="/login" modelAttribute="user">

    <form:input path="login" placeholder="Логин" /><br>

    <form:password path="password" placeholder="Пароль" /><br>

    <button type="submit">Вход</button>

    <form:errors path="login" />

</form:form>

<p><a href="/registration">Регистрация</a></p>