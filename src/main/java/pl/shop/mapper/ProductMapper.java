package pl.shop.mapper;

import pl.shop.dto.ProductDto;
import pl.shop.models.Product;

public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

//    <B, R> R remapObject(B b, R r);
}
