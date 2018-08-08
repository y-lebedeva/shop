package com.epam.javard.shop.web.validator;

import com.epam.javard.shop.dto.Product;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Product product = (Product) o;

        if (product.getName() == null || product.getName().isEmpty()) {
            errors.rejectValue("name", "label.validate.product.nameEmpty");
        }

        if (product.getPrice() == null || product.getPrice() < 0) {
            errors.rejectValue("price", "label.validate.product.priceError");
        }

        if (product.getAmount() == null || product.getAmount() < 0) {
            errors.rejectValue("amount", "label.validate.product.amountError");
        }
    }
}
