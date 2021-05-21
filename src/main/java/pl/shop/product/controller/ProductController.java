package pl.shop.product.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shop.product.dto.ProductDto;
import pl.shop.product.service.ProductCreateService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateService productCreateService;

    @PostMapping
    @ApiOperation(value = "Creates a new product.", notes = "When provided a product, adds it to the database.", response = ProductDto.class)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productCreateService.save(productDto);
    }


}
