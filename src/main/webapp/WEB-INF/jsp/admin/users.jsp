<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../../shared/admin/header.jsp"%>

<h2 class="border-bottom">Users</h2>

<p><a href="create">Create</a></p>

<table class="table table-sm table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Login</th>
            <th>Role</th>
            <td>Update</td>
            <td>Delete</td>
        </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="iuser">
        <tr>
            <td>${iuser.id}</td>
            <td>${iuser.firstName} ${iuser.lastName}</td>
            <td>${iuser.login}</td>
            <td>${iuser.role}</td>
            <td><a href="${iuser.id}/update">Update</a></td>
            <td><a href="${iuser.id}/delete">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<%@ include file="../../shared/admin/footer.jsp"%>