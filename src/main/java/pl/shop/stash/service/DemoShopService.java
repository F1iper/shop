package pl.shop.stash.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.shop.exception.IncorrectVatException;
import pl.shop.product.domain.Product;

import java.math.BigDecimal;
import java.math.MathContext;

public class DemoShopService {

    /**
     * To miał być 'właściwy' Service, ale zdążyłem się po drodze nauyczyć, że Spring nie akceptuje
     * zależności do interfejsów. :/
     * Ten interfejs nie będzie niezbędny, bo jest tylko na potrzeby Mockowania, ale nie chcę go
     * wywalać, więc 'Springowy" service przenoszę do klasy Service.
     */

    // Wstrzykujemy zależność VatProvider. Gdyż jak chcemy coś kupić, musimy płacić VAT <--- top quality
    // economy knowledge.
    VatProvider vatProvider;

    public DemoShopService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    /**
     * Znacie loggera? Każdy go zna, on zawsze fajne pomysły maaaa....
     * Sorki.
     * Dorzucony do metod, bo dzięki temu, w bardziej WYSUBLIMOWANY od System.out.println()
     * sposób, będziemy mieli logowane co się dzieje, co się nie udało i jak bardzo mamy
     * zacząć być sfrustrowani. Odpalajcie sobie testy i np. tam logger na konsolce będzie
     * nas informował co się dzieje.
     */
    private static final Logger logger = LoggerFactory.getLogger(DemoShopService.class);

    /**
     * Nadzwyczaj ważna funkcjonalność. Chociaż chyba zgodna ze sztuką, bo mam dla niej test i to nawet
     * napisany w metodologii TDD <sunglasses emoji>.
     */
    public int convertStringInputToInt(String number) {
        if (number.isBlank()) {
            logger.error("Lol, no input.");
        }
        if (!number.isBlank()) {
            logger.info("NASA levels of calculations there.");
        }
        return Integer.parseInt(number);
    }

    /**
     * Tu się już robi poważnie. Metody na wyliczanie cen produktów (af kors, na BigDecimalach, bo do hajsów
     * zawsze BigDecimala wykorzystujemy. Double gubi precyzję) z uwzglęnieniem VATu. Interfejs VatProvider
     * służy chwilowo do Mockowania dla testów. Potem się pomyśli jak go rozwinąć.
     */
    public BigDecimal calculateTheGrossPriceForDefaultVat(Product product) throws IncorrectVatException {
        logger.info("Called getGrossPriceForDefaultVat, product: " + product.getProductName() +
                ", net price: " + product.getProductNetPrice() +
                ", VAT: " + vatProvider.getDefaultVat());
        return calculateGrossPrice(product.getProductNetPrice(), vatProvider.getDefaultVat());
    }

    public BigDecimal calculateTheGrossPriceForGivenVat(Product product) throws IncorrectVatException {
        logger.info("Called getGrossPriceForGivenVat, product: " + product.getProductName() +
                ", net price: " + product.getProductNetPrice() + ", VAT value: " +
                vatProvider.getVatForProductCategory(product.getSomeCrapBasedOnWhichVatCanDiffer()));
        BigDecimal vatValue = vatProvider.getVatForProductCategory(product.getSomeCrapBasedOnWhichVatCanDiffer());
        return calculateGrossPrice(product.getProductNetPrice(), vatValue);
    }

    /**
     * Metoda prywatna -> pomocnicza do powyższych, a więc jej nie testujemy.
     */
    private BigDecimal calculateGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws IncorrectVatException {
        // Tutaj ustalamy liczbę miejsc po przecinku. BigDecimal jest maksymalnie dokładny cen
        // rzędu 23.878735834 raczej nie potrzebujemy. :)
        MathContext precision = new MathContext(4);
        // Operujemy na BigDecimalach, więc wygląda to nieco 'nietypowo'. Sprawdzamy czy wartość VATu nie jest zbut duża.
        // Samo vatValue == 1 nie zadziała, gdyż to BigDecimal właśnie.
        if (vatValue.compareTo(BigDecimal.ONE) == 1) {
            throw new IncorrectVatException("VAT value cannot be higher than 100% of the base price.");
        }
        // Mam nadzieję, że nie jesteście poirytowani tyloma sweet komenciami. :)
        // Te komentarze służą przede wszystkim mi, opisuję sobie i łatwiej mi zrozumieć co się dzieje.
        // Jeżeli VAT mamy 23%, no cenę bazową należy zamieć na jej 123%, a więc ONE + vatValue (np. 0.23 właśnie).
        return netPrice.multiply(BigDecimal.ONE.add(vatValue)).round(precision);
    }
}
