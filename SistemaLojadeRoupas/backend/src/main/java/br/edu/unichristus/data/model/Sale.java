package br.edu.unichristus.data.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tb_ProductReport")
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    private Client client;
    @ManyToOne
    private Product product;
    private int quantity;
    private double totalvalue;
}
