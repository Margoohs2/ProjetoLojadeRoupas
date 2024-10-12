package br.edu.unichristus.data.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String size;
    private Integer quantity;
    private String color;
    private String description;

}
