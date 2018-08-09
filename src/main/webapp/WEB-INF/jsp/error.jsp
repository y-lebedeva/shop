<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/header.jsp"%>

<div class="auth-form container m-auto">
    <h4 class="text-center">Error</h4>
    <div class="d-block alert alert-danger"><code>${message}</code></div>
</div>

<%@include file="../shared/footer.jsp"%>