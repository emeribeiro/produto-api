package br.com.mjv.produto.converters;

public interface EntityConverter<E, D> {

    D entityToDTO(E entity);

    E dtoToEntity(D dto, E entity);

}
