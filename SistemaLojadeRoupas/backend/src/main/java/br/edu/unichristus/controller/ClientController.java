package br.edu.unichristus.controller;

import br.edu.unichristus.data.dto.ClientDTO;
import br.edu.unichristus.data.dto.ClientLowDTO;
import br.edu.unichristus.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do cliente é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada. ")
    })
    @Operation(summary = "Cadastra os dados de um cliente",
            tags = "Client")
    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO client){
        return service.save(client);
    }

    @Operation(summary = "Atualiza os dados de um cliente",
            tags = "Client")
    @PutMapping
    public ClientDTO update(@RequestBody ClientDTO client){
        return service.save(client);
    }

    @Operation(summary = "Recupera os dados de todos os clientes",
            tags = "Client")
    @GetMapping("/all")
    public List<ClientLowDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Deleta um cliente baseado em seu id",
            tags = "Client")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Recupera os dados de um cliente baseado em seu id",
            tags = "Client")
    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

}

//teste