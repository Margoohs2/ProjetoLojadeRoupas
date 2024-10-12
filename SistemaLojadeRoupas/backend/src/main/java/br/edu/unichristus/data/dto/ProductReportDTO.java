package br.edu.unichristus.data.dto;

import lombok.Data;
@Data
public class ProductReportDTO {
    private String itemName;
    private int quantitySold;
    private double totalValue;
}
