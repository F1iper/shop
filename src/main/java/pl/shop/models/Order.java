package pl.shop.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer", referencedColumnName = "uuid")
    private Customer customer;

    private Date ordered;

    private Date shipped;

    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "delivery_address")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "delivery_streetNumber")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "delivery_houseNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "delivery_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "delivery_city"))
    })
    private Address deliveryAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "billing_address")),
            @AttributeOverride(name = "streetNumber", column = @Column(name = "billing_streetNumber")),
            @AttributeOverride(name = "houseNumber", column = @Column(name = "billing_houseNumber")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "billing_postalCode")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city"))
    })
    private Address billingAddress;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "order",
            cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment")
    private Payment payment;
}
