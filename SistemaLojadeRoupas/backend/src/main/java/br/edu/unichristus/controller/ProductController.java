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

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do produto é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada. ")
    })

    @Operation(summary = "Cadastra os dados de um produto",
            tags = "Product")
    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO product){
        return service.save(product);
    }

    @Operation(summary = "Atualiza os dados de um produto",
            tags = "Product")
    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO product){
        return service.save(product);
    }

    @Operation(summary = "Recupera os dados de todos os produtos",
            tags = "Product")
    @GetMapping("/all")
    public List<ProductDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Deleta um produto baseado em seu id",
            tags = "Product")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Recupera os dados de um produto baseado em seu id",
            tags = "Product")
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
       return service.findById(id);
    }

}
