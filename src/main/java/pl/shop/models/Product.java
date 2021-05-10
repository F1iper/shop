package pl.shop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class Product {

    /**
     * Na razie bez wchodzenia w szczegóły konwersji na rekordy w bazie danych. Zrobimy na to taska i
     * ktoś potem będzie się męczył. :)
     */

    private UUID id;
    private String productName;
    private String someCrapBasedOnWhichVatCanDiffer;
    private BigDecimal productNetPrice;
    private Category productCategory;

}
