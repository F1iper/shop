package pl.shop.product.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import pl.shop.category.domain.Category;

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
    private String description;

    //will probably need some pics, either via url or blob in db
    private String photoUrl;

    //probably not a good idea to hold this value directly in the entity long-term. sticking it here so we dont forget
    private int available;

    @CreatedDate
    private Date createdAt;

    public Product(UUID randomUUID, String productType, String someCrapBasedOnWhichVatCanDiffer, BigDecimal bigDecimal, Category productCategory, Date date) {
    }
}
