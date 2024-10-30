package br.edu.unichristus.data.dto;

import lombok.Data;
@Data
public class SaleDTO {
    private String itemName;
    private int quantitySold;
    private double totalValue;
}
