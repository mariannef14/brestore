package projeto.brestore.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projeto.brestore.config.exceptions.Erro;
import projeto.brestore.model.Produto;
import projeto.brestore.repository.ProdutoRepository;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    // =*=*=*=*=* Retornar lista de produtos =*=*=*=*=*
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public List<Produto> Get() {
        return produtoRepository.findAll();
    }

    //=*=*=*=*=* Cadastrar produto =*=*=*=*=*
    @RequestMapping(value = "/produtos/cadastrar/", method =  RequestMethod.POST)
    public Produto Post(@Valid @RequestBody Produto produto)
    {
        return produtoRepository.save(produto);
    }
 
    // =*=*=*=*=* Atualizar produto =*=*=*=*=*
    @RequestMapping(value = "/produtos/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Produto> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Produto novoProduto)
    {
        Optional<Produto> antigoProduto = produtoRepository.findById(id);
        if(antigoProduto.isPresent()){
            Produto produto = antigoProduto.get();
            produto.setNomeProduto(novoProduto.getNomeProduto());
            produto.setCategoriaProduto(novoProduto.getCategoriaProduto());
            produto.setEstadoProduto(novoProduto.getEstadoProduto());
            produto.setPrecoProduto(novoProduto.getPrecoProduto());
            produtoRepository.save(produto);

            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // =*=*=*=*=* Apagar produto =*=*=*=*=*
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> Delete(@PathVariable(value = "id") long id) throws Erro
    {
        Optional<Produto> produto = produtoRepository.findById(id);
        try{
            if(produto.isPresent()){
                produtoRepository.delete(produto.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{

                throw new Erro("O produto não foi encontrado");
            }
        }catch(Erro e){
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        
         }
        
    }

}