package pl.shop.product.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import pl.shop.product.dto.ProductDto;
import pl.shop.product.service.ProductCreateService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateService productCreateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new product.", notes = "When provided a product, adds it to the database.", response = ProductDto.class)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productCreateService.createProduct(productDto);
    }

//    todo implement getAllProductAsList service
//    @GetMapping
//    public List<ProductDto> getAllProductsAsList() {
//        return productGetListService.getProductList();
//    }

}
