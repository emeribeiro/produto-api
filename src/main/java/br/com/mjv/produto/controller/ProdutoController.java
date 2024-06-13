package br.com.mjv.produto.controller;

import br.com.mjv.produto.dto.ProdutoDTO;
import br.com.mjv.produto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/listar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista todos os produtos cadastrados."),
            @ApiResponse(responseCode = "400", description = "Não existe produtos cadastrados.")
    })
    @Operation(description = "Lista todos os produtos cadastrados.")
    public List<ProdutoDTO> listar() {
        return service.listar();
    }

    @GetMapping(value = "/buscar/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto com o ID indicado."),
            @ApiResponse(responseCode = "400", description = "Não existe produto com o ID indicado.")
    })
    @Operation(description = "Busca o produto por ID.")
    public ProdutoDTO buscar(@PathVariable(required = true) Long id) throws Exception {
        return service.buscar(id);
    }

    @PostMapping("/cadastrar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto em processo de criação."),
            @ApiResponse(responseCode = "400", description = "A solicitação não pode ser processada.")
    })
    @Operation(description = "Efetua o cadastro do produto.")
    public void cadastrar(@RequestBody ProdutoDTO produtoDTO) {
        service.salvarOuAtualizar(produtoDTO);
    }

    @PutMapping("/atualizar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto em processo de edição."),
            @ApiResponse(responseCode = "400", description = "A solicitação não pode ser processada.")
    })
    @Operation(description = "Permite editar o produto.")
    public void atualizar(@RequestBody ProdutoDTO produtoDTO) {
        service.salvarOuAtualizar(produtoDTO);
    }

    @DeleteMapping(value = "excluir/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto em processo de remoção."),
            @ApiResponse(responseCode = "400", description = "A solicitação não pode ser processada.")
    })
    @Operation(description = "Permite excluir o produto por id.")
    public void excluir(@PathVariable(required = true) Long id) throws Exception {
        service.excluir(id);
    }

}
