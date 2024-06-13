package br.com.mjv.produto;

import br.com.mjv.produto.entity.Produto;
import br.com.mjv.produto.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("br.com.mjv.produto")
public class ProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProdutoRepository repository) {
		return args -> {
			Produto produto = new Produto();
			produto.setNome("IPHONE 13 PRO");
			produto.setQuantidade(8);
			produto.setValor(5000.0);
			repository.save(produto);

			Produto produto2 = new Produto();
			produto2.setNome("MACBOOK");
			produto2.setQuantidade(1);
			produto2.setValor(1000.0);
			repository.save(produto2);
		};
	}

}
