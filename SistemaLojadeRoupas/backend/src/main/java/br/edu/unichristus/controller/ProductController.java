package br.edu.unichristus.controller;

import br.edu.unichristus.data.dto.ProductDTO;
import br.edu.unichristus.data.dto.ProductLowDTO;
import br.edu.unichristus.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Cadastra os dados de um produto | role: [ADMIN]",
                        tags = "Product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do produto é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada. ")
    })
    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO product){
        return service.save(product);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO product){
        return service.save(product);
    }

    @GetMapping("/all")
    public List<ProductDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
       return service.findById(id);
    }

}
