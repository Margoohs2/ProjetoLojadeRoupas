package br.edu.unichristus.service;

import br.edu.unichristus.data.dto.ProductReportDTO;
import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.data.model.ProductReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private br.edu.unichristus.repository.SaleRepository repository;

    public List<ProductReportDTO> generateSalesReport() {

        List<ProductReport> productReports = repository.findAll();

        return productReports.stream().map(productReport -> {
            ProductReportDTO dto = new ProductReportDTO();
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

//teste