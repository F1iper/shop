package pl.shop.models;

// 'User' is used by spring security, it also feels very generic. Customer fits better =]


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Uuid;

    private String username;


    @CreatedDate
    private LocalDate registeredAt;

    @ManyToMany
    @JoinTable(
            name = "user_products_bought",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    Set<Product> productsBought = new HashSet<>();


    Category favouriteCategory;

//todo
//    Set<Order> orders = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true)
    private CustomerDetails customerDetails;


}
