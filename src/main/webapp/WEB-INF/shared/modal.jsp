<%@page contentType="text/html;charset=UTF-8" language="java"%>

<%-- <div class="modal fade" id="search-modal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">&times;</button>
                <h5 class="modal-title text-center m-2">Поиск</h5>
                <form>
                    <div class="form-group col-auto">
                        <input class="form-control" type="search" placeholder="Название товара.." />
                    </div>
                    <div class="form-group d-flex flex-column justify-content-center">
                        <button class="btn btn-primary m-auto" type="submit">Найти</button>
                    </div>
                </form>
                <div class="products d-flex flex-wrap">
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product_name m-2">product 1</span>
                    </div>
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product-name m-2">product 2</span>
                    </div>
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product-name m-2">product 3</span>
                    </div>
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product-name m-2">product 4</span>
                    </div>
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product-name m-2">product 5</span>
                    </div>
                    <div class="product m-2 border rounded">
                        <img src="product.png">
                        <span class="product-name m-2">product 6</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> --%>

<div class="modal fade" id="basket-modal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body">
                <button class="close" data-dismiss="modal">&times;</button>
                <h5 class="modal-title text-center m-2">Basket</h5>
                
                <div class="products d-flex flex-wrap"></div>

                <div class="container">
                    <div class="row align-items-end justify-content-between">
                        <div class="col">
                            <p>Sum: <span id="basket-sum">0</span>$</p>
                            <p>Discount <span id="discount-value">0</span>%: <span id="basket-discount">0</span>$</p>
                            <h5>Total: <span id="basket-total">0</span>$</h5>
                        </div>
                        <div class="col-3 m-2 align-self-end d-flex justify-content-end">
                            <button type="button" class="btn btn-primary mr-2">Order</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>