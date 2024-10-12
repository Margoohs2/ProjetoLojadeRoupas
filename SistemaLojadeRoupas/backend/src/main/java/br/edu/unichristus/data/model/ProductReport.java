package br.edu.unichristus.data.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tb_ProductReport")
@Data
public class ProductReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private double totalvalue;
}
