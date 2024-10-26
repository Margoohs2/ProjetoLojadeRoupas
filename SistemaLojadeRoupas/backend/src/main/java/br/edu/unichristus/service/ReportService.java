package br.edu.unichristus.service;

//import dos relatorios
import br.edu.unichristus.data.dto.ProductReportDTO;
import br.edu.unichristus.data.model.Product;
import br.edu.unichristus.data.model.ProductReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

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

    public void printSalesReport() {
        List<ProductReportDTO> report = generateSalesReport();

        logger.info("----- Relatório de Vendas -----");

        report.forEach(dto -> {
            logger.info("Produto: {}", dto.getItemName());
            logger.info("Quantidade Vendida: {}", dto.getQuantitySold());
            logger.info("Valor Total: R$ {}", dto.getTotalValue());
            logger.info("-----------------------------");
        });

        double valorTotalGeral = report.stream()
                .mapToDouble(ProductReportDTO::getTotalValue)
                .sum();

        logger.info("Valor Total Geral de Vendas: R$ {}", valorTotalGeral);
        logger.info("----- Fim do Relatório -----");
    }
}
