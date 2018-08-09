
let getProductHtml = function(item) {
    return '<div id="product' + item.id + '" class="product expand m-2 border rounded">' +
                '<img src="product.png">' +
                '<span class="product-name m-2">' + item.name + '</span>' +
                '<p class="product-price m-2"><span class="product-price-value m-2">' + item.price + '</span>$</p>' +
                '<p class="product-count">' + item.count + '</p>' +
                '<a class="del-basket btn btn-outline-success m-4" href="/product/' + item.id + '/del">Delete</a>' +
            '</div>';
}

let success = function (data) {
    let json = JSON.parse(data);

    if (json.count < 1) {
        $('#basket-modal .products').html('пусто');
        $('#discount-value').html(0);
        $('#basket-sum').html(0);
        $('#basket-discount').html(0);
        $('#basket-total').html(0);
        $('#basket-counter').html(0);
        return;
    }

    $('#basket-modal .products').html('');
    for (let i = 0; i < json.items.length; i++) {
        const item = json.items[i];
        const productHtml = getProductHtml(item);
        $('#basket-modal .products').append(productHtml);
    }

    $('#basket-sum').html(json.sum);
    $('#discount-value').html(json.discount);

    let discount = json.sum * json.discount / 100;
    $('#basket-discount').html(discount);

    let total = json.sum - discount;
    $('#basket-total').html(total);

    $('#basket-currency').html(json.currency);

    $('#basket-counter').html(json.count);

    $('a.del-basket').on('click', function() {
        $.get({
            url: this.href,
            success: success
        });
        return false;
    });
}


$(function () {

    $('a.add-basket').on('click', function() {
        $.get({
            url: this.href,
            success: success
        });
        return false;
    });
});