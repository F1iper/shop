package pl.shop.stash.service;

@org.springframework.stereotype.Service
public class Service {

    /**
     * Kilka demo metodek do prezentacji Thymeleafa. Obecnie to one są wołane w HTMLu 'home'.
     */

    public int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    public int substract(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    public int multiply(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    public int divide(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }
}
