<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Products</h2>

<%--
<form:form method="POST" action="/product/create" modelAttribute="product">
    <form:label path="name">Name</form:label><br/>
    <form:input path="name"/><br/>
    <form:errors path="name"/><br/>

    <form:label path="description">Description</form:label><br/>
    <form:input path="description"/><br/>
    <form:errors path="description"/><br/>

    <form:label path="price">Price</form:label><br/>
    <form:input path="price"/><br/>
    <form:errors path="price"/><br/>

    <form:label path="amount">Amount</form:label><br/>
    <form:input path="amount"/><br/>
    <form:errors path="amount"/><br/>

    <button type="submit">Create New Product</button>
</form:form>
--%>

<table border="1">
<c:forEach items="${products}" var="producti">
    <tr>
        <td>${producti.getId()}</td>
        <td>${producti.getName()}</td>
        <td>${producti.getPrice()}</td>
        <td>${producti}</td>
        <%--
        <td>
            <form:form method="POST" action="/product/update/${producti.getId()}">
                <button type="submit">Delete</button>
            </form:form>
        </td>
        <td>
            <form:form method="POST" action="/product/delete/${producti.getId()}">
                <button type="submit">Delete</button>
            </form:form>
        </td>
        --%>
    </tr>
</c:forEach>
</table>