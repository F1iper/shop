package pl.shop.service;

import pl.shop.dto.ProductDto;

public interface ProductCreateService {

    ProductDto save(ProductDto productDto);
}
