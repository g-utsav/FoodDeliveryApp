package com.foodDelivery.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Bill {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer billId;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    LocalDateTime billDateTime;

    @NotNull
    Integer totalItems;
    @NotNull
    Integer totalCost;

}
