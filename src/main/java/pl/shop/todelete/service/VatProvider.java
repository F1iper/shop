package pl.shop.todelete.service;

import java.math.BigDecimal;

public interface VatProvider {

    BigDecimal getDefaultVat();
    BigDecimal getVatForProductCategory(String someCrapBasedOnWhichVatCanDiffer); // Wychodzę tutaj z fantastycznego założenia, że podatek
                                                             // różni się w zależności od kategorii produktu.
                                                             // Jak się nie podoba, to mnie pozwijcie. Hehe.

}
