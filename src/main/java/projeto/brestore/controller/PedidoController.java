package projeto.brestore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projeto.brestore.model.Pedido;
import projeto.brestore.repository.PedidoRepository;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    
   
     //=*=*=*=*=* Colocar produto no carrinho =*=*=*=*=*
    @RequestMapping(value = "/produtos/carrinho", method =  RequestMethod.POST)
    public Pedido Post(@Valid @RequestBody Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

}