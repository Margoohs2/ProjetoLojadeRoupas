package br.edu.unichristus.service;

import br.edu.unichristus.dto.ItemReportDTO;
import br.edu.unichristus.data.model.Sale;
import br.edu.unichristus.data.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<ItemReportDTO> generateSalesReport() {
        // Fetching all sales
        List<Sale> sales = saleRepository.findAll();

        // Generating the report by aggregating data
        return sales.stream().map(sale -> {
            ItemReportDTO dto = new ItemReportDTO();
            dto.setItemName(sale.getProduct().getName());
            dto.setQuantitySold(sale.getQuantity());
            dto.setTotalValue(sale.getQuantity() * sale.getProduct().getPrice());
            return dto;
        }).collect(Collectors.toList());
    }
}
