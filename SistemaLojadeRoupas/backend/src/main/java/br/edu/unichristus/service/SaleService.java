package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.SaleDTO;
import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.data.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private br.edu.unichristus.repository.SaleRepository repository;

    public List<SaleDTO> generateSalesReport() {

        List<Sale> productReports = repository.findAll();

        return productReports.stream().map(productReport -> {
            SaleDTO dto = new SaleDTO();
            dto.setItemName(productReport.getProduct().getName());
            dto.setQuantitySold(productReport.getQuantity());
            dto.setTotalValue(productReport.getQuantity() * productReport.getProduct().getPrice());
            return dto;
        }).collect(Collectors.toList());
    }

    public Map<Product, Integer> generateProductReport() {
        return Map.of();
    }
}
