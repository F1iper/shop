package pl.shop.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.shop.product.dto.ProductDto;
import pl.shop.product.mapper.ProductMapper;
import pl.shop.product.domain.Product;
import pl.shop.product.repository.ProductRepository;
import pl.shop.product.service.ProductCreateService;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class ProductCreateServiceImpl implements ProductCreateService {

    private static final Logger logger = LoggerFactory.getLogger(ProductCreateServiceImpl.class);
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto save(ProductDto productDto) {
        productDto.setCreatedAt(new Date());

        Product savedProduct = productRepository.save(productMapper.productDtoToProduct(productDto));
        logger.info("Product created: " + productDto.getProductName());
        return productMapper.productToProductDto(savedProduct);
    }
}
