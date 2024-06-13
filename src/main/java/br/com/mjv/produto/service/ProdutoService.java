package br.com.mjv.produto.service;

import br.com.mjv.produto.converters.ProdutoConverter;
import br.com.mjv.produto.dto.ProdutoDTO;
import br.com.mjv.produto.entity.Produto;
import br.com.mjv.produto.exceptions.ValidacaoException;
import br.com.mjv.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ProdutoConverter converter;

    public void salvarOuAtualizar(ProdutoDTO produtoDTO) {
        if (Objects.isNull(produtoDTO.getId()))
            salvar(produtoDTO);
        else
            atualizar(produtoDTO);
    }

    public void salvar(ProdutoDTO produtoDTO) {
        Produto produto = converter.dtoToEntity(produtoDTO, new Produto());
        repository.save(produto);
    }

    public ProdutoDTO buscar(Long id) {
        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isPresent()) {
            return converter.entityToDTO(produtoOptional.get());
        }
        throw new ValidacaoException(
                String.format("Nao foi encontrado o produto com o id [%s].", id));
    }

    public List<ProdutoDTO> listar() {
        return repository.findAll().stream().map(converter::entityToDTO).toList();
    }

    public void excluir(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }


    public void atualizar(ProdutoDTO produtoDTO) {
        repository.findById(produtoDTO.getId())
                .ifPresent(produto -> repository.save(converter.dtoToEntity(produtoDTO, produto)));
    }
}
