<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
<link type="text/css" href="/css/main.css" rel="stylesheet" />
<title>Product</title>
</head>
<body>

<div class="wrap">

<div class="navbar navbar-expand navbar-dark bg-dark">
	<div class="collapse navbar-collapse justify-content-between">
		<div class="navbar-text">User Name</div>
		<div class="navbar-nav">
			<a class="nav-item nav-link" href="/logout">Logout</a>
			<a class="nav-item nav-link" href="/products">Shop</a>
		</div>
	</div>
</div>

<div class="main">

    <div class="navbar-nav navbar-light bg-light flex-column col-auto p-2">
        <a class="nav-link px-3" href="/admin/product/all">Products</a>
        <a class="nav-link px-3" href="/admin/categories/all">Categories</a>
        <a class="nav-link px-3" href="/admin/users/all">Users</a>
        <a class="nav-link px-3" href="/admin/orders/all">Orders</a>
    </div>

    <div class="content p-2">