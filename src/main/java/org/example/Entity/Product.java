package org.example.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TABLA_PRODUCTO")
public class Product {

    @Id
    @GeneratedValue
    private int idproducto;

    @Column(unique = true)
    private String name;

    private int quantity;

    private double price;


}
