package projeto.brestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.brestore.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> { 
	
}
