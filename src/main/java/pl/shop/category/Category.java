package pl.shop.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.shop.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Category {

    /**
     * Na razie bez wchodzenia w szczegóły konwersji na rekordy w bazie danych. Zrobimy na to taska i
     * ktoś potem będzie się męczył. :)
     * Jakoś tak mi w trakcie wyszło, że Category będzie Enumem... chyba, że to nie ma sensu, to się
     * zmieni. Na razie mi tu wychodzi sklep z jedzeniem, ale to kwestia kosmetyczna. Może np.
     * domena sprzedaży sprzętu elektronicznego da nam możliwość zastosowania ciekawszych
     * rozwiązań?
     * ...
     * Wydaje mi się, że bazy MySQL wspierają Enumy, więc może nie jest to strzal w stopę.
     */

    HEALTHY_FOOD,
    JUNK_FOOD,
    TEAS_AND_COFFEES,
    SPICES,
    GRAINS_AND_LENTILS,
    NUTS_AND_SEEDS,
    DRIED_FRUITS,
    SNACKS,
    DRINKS;

    private String categoryName;
    List<Product> productList = new ArrayList<>();
}
