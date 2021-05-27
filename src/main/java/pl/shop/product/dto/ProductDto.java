package pl.shop.product.dto;

import lombok.*;
import pl.shop.category.domain.Category;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private UUID id;
    private String productName;
    private String someCrapBasedOnWhichVatCanDiffer;
    private BigDecimal productNetPrice;
    private Category productCategory;
    private Date createdAt;
}
