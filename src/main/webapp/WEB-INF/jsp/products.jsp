<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/header.jsp"%>


<c:forEach items="${categories}" var="category">

<c:if test="${!category.products.isEmpty()}">
<div class="category">
    <div class="category-header navbar navbar-expand-sm navbar-light bg-light
        justify-content-center font-weight-bold sticky-top">
        ${category.getName()}
    </div>

    <div class="products container d-flex flex-wrap p-2">

    <c:forEach items="${category.products}" var="product">

        <div class="product m-2 border rounded">
            <img src="product.png" width="150" height="150">
            <span class="product-name m-2">${product.name}</span>
            <p class="product-price m-2"><span class="product-price-value m-2">${product.price}</span>$</p>
            <a class="add-basket btn btn-outline-success m-4" href="product/${product.id}/add">В корзину</a>
        </div>

    </c:forEach>

    </div>
</div>
</c:if>

</c:forEach>


<c:if test="${!products.isEmpty()}">
<div class="category">
    <div class="category-header navbar navbar-expand-sm navbar-light bg-light
        justify-content-center font-weight-bold sticky-top">
        Uncategorized
    </div>

    <div class="products container d-flex flex-wrap p-2">

    <c:forEach items="${products}" var="product">

        <div class="product m-2 border rounded">
            <img src="product.png" width="150" height="150">
            <span class="product-name m-2">${product.name}</span>
            <p class="product-price m-2"><span class="product-price-value m-2">${product.price}</span>$</p>
            <a class="add-basket btn btn-outline-success m-4" href="product/${product.id}/add">В корзину</a>
        </div>

    </c:forEach>

    </div>
</div>
</c:if>

<%@include file="../shared/footer.jsp"%>





