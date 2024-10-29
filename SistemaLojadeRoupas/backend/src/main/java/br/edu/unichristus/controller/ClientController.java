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

    @Operation(summary = "Cadastra os dados de um cliente | role: [ADMIN]",
            tags = "Client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "O limite de caracteres do nome do cliente é 150"),
            @ApiResponse(responseCode = "400", description = "Exception não tratada. ")
    })
    @PostMapping
    public ClientDTO create(@RequestBody ClientDTO client){
        return service.save(client);
    }

    @PutMapping
    public ClientDTO update(@RequestBody ClientDTO client){
        return service.save(client);
    }

    @GetMapping("/all")
    public List<ClientLowDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

}