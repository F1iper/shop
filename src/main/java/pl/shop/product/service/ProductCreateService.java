package pl.shop.product.service;

import pl.shop.product.dto.ProductDto;

public interface ProductCreateService {

    ProductDto save(ProductDto productDto);
}
