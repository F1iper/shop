package pl.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shop.dto.ProductDto;
import pl.shop.service.DemoShopService;
import pl.shop.service.ProductCreateService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateService productCreateService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productCreateService.save(productDto);
    }


}
