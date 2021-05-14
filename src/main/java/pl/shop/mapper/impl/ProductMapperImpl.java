package pl.shop.mapper.impl;

import org.springframework.stereotype.Component;
import pl.shop.dto.ProductDto;
import pl.shop.mapper.ProductMapper;
import pl.shop.models.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .productName(productDto.getProductName())
                .someCrapBasedOnWhichVatCanDiffer(productDto.getSomeCrapBasedOnWhichVatCanDiffer())
                .productNetPrice(productDto.getProductNetPrice())
                .productCategory(productDto.getProductCategory())
                .build();
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .someCrapBasedOnWhichVatCanDiffer(product.getSomeCrapBasedOnWhichVatCanDiffer())
                .productNetPrice(product.getProductNetPrice())
                .productCategory(product.getProductCategory())
                .build();
    }
}
