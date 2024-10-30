package br.edu.unichristus.data.dto;

import br.edu.unichristus.data.model.Client;
import br.edu.unichristus.data.model.Product;
import lombok.Data;
@Data
public class SaleDTO {
    private Client client;
    private Product product;
    private int quantity;
    private double totalvalue;
}
