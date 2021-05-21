package pl.shop.product.domain;

import lombok.*;
import pl.shop.category.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String productName;
    private String someCrapBasedOnWhichVatCanDiffer;
    private BigDecimal productNetPrice;
    private Category productCategory;
    private Date createdAt;

}
