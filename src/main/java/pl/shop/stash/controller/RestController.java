package pl.shop.stash.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.shop.stash.service.Service;

/**
 * Komencie wrzucam wyłącznie tymczasowe. Przypominam, że zgodnie z przykazanimi Wujka Boba,
 * kod ma się komentować sam, więc to tylko tak na start. :)
 *
 * Kontrolery dwa ze względu na rozdział na samo API oraz wersję dla użytkownika. RestController
 * to nasze API -> będzie można sobie testować np. w Postmanie dla fejmu.
 *
 * Zwracam uwagę na adnotację RequestMapping nad klasą. Oznacza to tyle co String w nawiasie mówi.
 * To jest API. W celu dostania się pod którykolwiek z endpointów, należy dodać tegoż właśnie Stringa
 * do URLa.
 * Wydaje mi się, że w warunkach bitewnych back-endowcy robiliby samo właśnie API (a więc RestController)
 * i na podstawie tego frontowcy robiliby resztę.
 * My natomiast frontowców chyba nie mamy, więc radzimy sobie sami i z tego powodu ThymeleafController. :)
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RestController {

    Service service;

    @GetMapping("/add")
    public int addInput(@RequestParam int numberOne,
                        @RequestParam int numberTwo) {
        return service.add(numberOne, numberTwo);
    }

    @GetMapping("/substract")
    public int substractInput(@RequestParam int numberOne,
                        @RequestParam int numberTwo) {
        return service.substract(numberOne, numberTwo);
    }

    @GetMapping("/multiply")
    public int multiplyInput(@RequestParam int numberOne,
                        @RequestParam int numberTwo) {
        return service.multiply(numberOne, numberTwo);
    }

    @GetMapping("/divide")
    public int divideInput(@RequestParam int numberOne,
                        @RequestParam int numberTwo) {
        return service.divide(numberOne, numberTwo);
    }
}
