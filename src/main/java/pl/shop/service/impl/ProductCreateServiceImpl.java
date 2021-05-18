package pl.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.shop.dto.ProductDto;
import pl.shop.mapper.ProductMapper;
import pl.shop.models.Product;
import pl.shop.repository.ProductRepository;
import pl.shop.service.ProductCreateService;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class ProductCreateServiceImpl implements ProductCreateService {

    private static final Logger logger = LoggerFactory.getLogger(ProductCreateServiceImpl.class);
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        productDto.setCreatedAt(new Date());

        Product receivedMappedProduct = productMapper.productDtoToProduct(productDto);
        Product savedProduct = productRepository.save(receivedMappedProduct);
        logger.info("Product created: " + productDto.getProductName());
        return productMapper.productToProductDto(savedProduct);
    }
}
