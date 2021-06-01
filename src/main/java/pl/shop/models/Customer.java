package pl.shop.models;

// 'User' is used by spring security, it also feels very generic. Customer fits better =]


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String username;


    @CreatedDate
    private LocalDate registeredAt;

    @ManyToMany
    @JoinTable(
            name = "customer_products_bought",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> productsBought = new HashSet<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "favourite_category")
    private Category favouriteCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer", orphanRemoval = true)
    private CustomerDetails customerDetails;


}
