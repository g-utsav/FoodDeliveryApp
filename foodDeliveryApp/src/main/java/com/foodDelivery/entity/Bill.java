package com.foodDelivery.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Setter
@Getter
@Data
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
