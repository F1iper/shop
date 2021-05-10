package pl.shop.exceptions;

import org.springframework.stereotype.Component;

/**
 * Autorski exceptionik, który miotamy gdy coś nie sztymuje z wartością VATu.
 */

@Component
public class IncorrectVatException extends Throwable{

    private String message;

    public IncorrectVatException() {
    }

    public IncorrectVatException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
