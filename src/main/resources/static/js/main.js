$(function() {

    let topHeight = $('.header').outerHeight();
    $('.category-header').css("top", topHeight);


    $('.category .product').on('click', function() {
        $('.category .product').removeClass('expand');
        $(this).addClass('expand');
    });


    $('.basket').on('click', function() {
        $('#basket-modal').modal('show');
    });

    $('form[name="search-form"]').on('click', function() {
        event.preventDefault();
        $('#search-modal').modal('show');
    });
});
