package br.edu.unichristus.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_product")
@Data
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 50)
    private String size;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, length = 30)
    private String color;

    @Column(length = 255)
    private String description;
}



