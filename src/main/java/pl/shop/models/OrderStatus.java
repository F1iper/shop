package pl.shop.models;

public enum OrderStatus {

    NEW,
    WAITING_FOR_PAYMENT,
    WAITING_FOR_PRODUCT,
    READY_TO_SHIP,
    SHIPPED,
    DELIVERED,
    CLOSED;
}
