package projeto.brestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.brestore.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> { 
	
}
