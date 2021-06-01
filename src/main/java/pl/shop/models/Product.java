package pl.shop.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "products")
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
