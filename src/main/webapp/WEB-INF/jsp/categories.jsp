<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Categories</h2>

<table border="1">
<c:forEach items="${categories}" var="category">
    <tr>
        <td>${category.getName()}</td>
        <td>${category.getDescription()}</td>
        <td>${category.getParent().getName()}</td>
        <td>${category.getParent().getDescription()}</td>
    </tr>
</c:forEach>
</table>