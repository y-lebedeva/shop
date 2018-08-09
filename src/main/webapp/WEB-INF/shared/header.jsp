<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">

    <style><%@include file="main.css"%></style>

    <title>${title}</title>
</head>
<body>
    <div class="wrapper d-flex flex-column">

        <nav class="header sticky-top navbar navbar-expand-sm navbar-dark">
        <c:if test = "${pageName=='products'}">

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbar">
                <div class="navbar-nav w-100 justify-content-between">
                    <span class="nav-item nav-link">
                        ${user.getFirstName()}
                        ${user.getLastName()}
                    </span>

                    <c:if test = "${user.role == 'ADMIN'}">
                        <a class="nav-item nav-link" href="/admin/product/all">Admin</a>
                    </c:if>

                    <a class="nav-item nav-link" href="/logout">Выход</a>

                    <div class="flex-grow-1 d-none d-sm-inline-block"></div>

                    <%-- <form class="form-inline mr-4" name="search-form" action="/search" method="GET">
                        <input type="search" class="form-control form-control-sm" name="text" placeholder="Поиск.." />
                        <button class="search-btn" type="submit">
                            <i class="search-i fas fa-search fa-sm fa-fw fa-inverse"></i>
                        </button>
                    </form> --%>

                    <button class="basket btn nav-item nav-link">
                        <span class="d-sm-none">Корзина</span>
                        <i class="d-none d-sm-inline-block basket-i fas fa-shopping-cart fa-sm fa-fw fa-inverse"></i>
                        <span class="badge badge-light" id="basket-counter">0</span>
                    </button>
                </div>
            </div>
        </c:if>
        </nav>
        <div class="content flex-grow-1">