package it.java.tutor.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "price", nullable = false)
    private double price;

}
