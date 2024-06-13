package br.com.mjv.produto.converters;

import br.com.mjv.produto.dto.ProdutoDTO;
import br.com.mjv.produto.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoConverter implements EntityConverter<Produto, ProdutoDTO> {

    @Override
    public ProdutoDTO entityToDTO(Produto produto) {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setValor(produto.getValor());
        produtoDTO.setQuantidade(produto.getQuantidade());
        return produtoDTO;
    }

    @Override
    public Produto dtoToEntity(ProdutoDTO produtoDTO, Produto produto) {
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());
        produto.setQuantidade(produtoDTO.getQuantidade());
        return produto;
    }

}
