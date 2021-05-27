package pl.shop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.shop.exceptions.IncorrectVatException;
import pl.shop.models.Category;
import pl.shop.models.Product;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class demoShopServiceTest {

    /**
     * Nie wiem na jakim kto jest poziomie. Może to wszystko oczywistości dla Was albo i
     * jakieś głupoty tutaj tworzę i nawet nie wiem albo może i coś jest niejasne.
     * W obu przypadkach wiecie gdzie mnie znaleźć. :)
     */

    private static DemoShopService demoShopService;
    VatProvider vatProvider;

    @Test
    void shouldConvertGivenStringToInt() {
        //given
        String providedNumber = "2456";
        int expectedResult = 2456;
        //when
        int actualResult = demoShopService.convertStringInputToInt(providedNumber);
        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void shouldCalculateGrossPriceForDefaultVat() throws IncorrectVatException {
        //given
        Product product = generateTheProduct("Vegan cheese", "someCrapBasedOnWhichVatCanDiffer", "6.0", Category.HEALTHY_FOOD, Date.from(Instant.now()));
        Mockito.when(vatProvider.getDefaultVat()).thenReturn(new BigDecimal("0.23"));
        //when
        BigDecimal actualResult = demoShopService.calculateTheGrossPriceForDefaultVat(product);
        //then
        assertThat(actualResult).isEqualTo("7.380");
    }

    @Test
    void shouldCalculateGrossPriceForGivenVat() throws IncorrectVatException {
        //given
        Product product = generateTheProduct("Powdered tears of your enemies", "someCrapBasedOnWhichVatCanDiffer", "10.0", Category.SNACKS, Date.from(Instant.now()));
        Mockito.when(vatProvider.getVatForProductCategory(product.getSomeCrapBasedOnWhichVatCanDiffer())).thenReturn(new BigDecimal("0.13"));
        BigDecimal expectedResult = new BigDecimal("11.30");
        //when
        BigDecimal actualResult = demoShopService.calculateTheGrossPriceForGivenVat(product);
        //then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    // Tutaj testuję czy mój customowy exception rusza na wroga gdy na surmach kompilator zagra.
    @Test
    void shouldThrowIncorrectVatExceptionWhenVatIsTooHigh() {
        //given
        Product product = generateTheProduct("Cola", "someCrapBasedOnWhichVatCanDiffer", "5.0", Category.DRINKS, Date.from(Instant.now()));
        Mockito.when(vatProvider.getVatForProductCategory(product.getSomeCrapBasedOnWhichVatCanDiffer())).thenReturn(BigDecimal.TEN); // Podatek cukrowy, lol.
        //then
        assertThatExceptionOfType(IncorrectVatException.class).isThrownBy(() ->
                demoShopService.calculateTheGrossPriceForGivenVat(product)).withMessage("VAT value cannot be higher than 100% of the base price.");
    }

    // Metodka prywatna dla testów generująca nam obiekty Product, gdyż tak jest bardziej estetycznie
    // niż za każdym razem strzelać nowe 'new'.
    // Product wymaga BigDecimala jako cenę, ale przyjmujemy Stringa, bo łatwiej, a potem już sami
    // sobie z tego BigDecimala robimy.

    private Product generateTheProduct(String productType, String someCrapBasedOnWhichVatCanDiffer, String productPrice, Category productCategory, Date date) {
        return new Product(UUID.randomUUID(), productType, someCrapBasedOnWhichVatCanDiffer, new BigDecimal(productPrice), productCategory, new Date());
    }

    @BeforeEach
    void setUp() {
        vatProvider = Mockito.mock(VatProvider.class); // Mockuję se interfejsiątko żeby mi dawało takie stawki VATu jakich będę potrzebował w testach.
        demoShopService = new DemoShopService(vatProvider);
    }
    // Tu na górze zwracam uwagę na kolejność. Mnie szlag trafił bo ciągle dostawałem nulla... shopService z parametrem
    // vatProvider implementowałem zanim implementowałem vatProvider. :/ W związku z tym, chciałem żeby tworzył mi
    // implementację serwisu z zależnością do czegoś co jeszcze nie istnieje. Zamiania kolejności implementacji
    // powyższych rozwiązała problem.

}