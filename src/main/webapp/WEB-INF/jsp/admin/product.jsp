<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${action=='create'}"><h4>Create</h4></c:if>
<c:if test="${action=='update'}"><h4>Update</h4></c:if>
<c:if test="${action=='delete'}"><h4>Delete</h4></c:if>

<form:form method="POST" action="${action}" modelAttribute="product">

    <form:label path="name">Name</form:label><br/>
    <form:input path="name"/>
    <form:errors path="name"/><br/>

    <form:label path="description">Description</form:label><br/>
    <form:input path="description"/>
    <form:errors path="description"/><br/>

    <form:label path="price">Price</form:label><br/>
    <form:input path="price"/>
    <form:errors path="price"/><br/>

    <form:label path="amount">Amount</form:label><br/>
    <form:input path="amount"/>
    <form:errors path="amount"/><br/>

    <form:select path="category">
        <form:option value="${null}" label="--Please Select"/>
        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
    </form:select><br/>

    <button type="submit">Submit</button>
    <button type="reset">Reset</button>
</form:form>
