package pl.shop.product.mapper;

import pl.shop.product.dto.ProductDto;
import pl.shop.product.domain.Product;

public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);
}
