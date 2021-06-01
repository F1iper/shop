package pl.shop.models;

import javax.persistence.Embeddable;

@Embeddable
public enum Payment {

    CASH,
    TRANSFER,
    PAYPAYL,
    CARD
}
