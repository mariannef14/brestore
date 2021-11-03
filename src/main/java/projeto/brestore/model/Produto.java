package projeto.brestore.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 50, message = "O nome do produto pode conter até 50 caracteres no máximo")
    @Column(name = "Nome", nullable = false, length = 50)
    private String nomeProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "Categoria", nullable = false)
    private EnumCategoriaProduto categoriaProduto;
    
    @Column(name = "Preço", nullable = false)
    private Double precoProduto;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Estado", nullable = false)
    private EnumEstadoProduto estadoProduto;

    @Size(max = 30, message = "A cor do produto pode conter até 30 caracteres no máximo")
    @Column(name = "Cor", nullable = false, length = 30)
    private String corProduto;

    @Size(max = 5, message = "O tamanho do produto pode conter até 5 caracteres no máximo")
    @Column(name = "Tamanho", nullable = false, length = 5)
    private String tamanhoProduto;


    @ManyToMany(mappedBy = "produto")
    private List<Pedido> pedido;

    public Produto(){}

    public Produto(String nomeProduto, EnumCategoriaProduto categoriaProduto, Double precoProduto, EnumEstadoProduto estadoProduto, String corProduto, String tamanhoProduto, List<Pedido> pedido){

        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.precoProduto = precoProduto;
        this.estadoProduto = estadoProduto;
        this.corProduto = corProduto;
        this.tamanhoProduto = tamanhoProduto;
       this.pedido = pedido;
        
    }

    public long getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public EnumCategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(EnumCategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public EnumEstadoProduto getEstadoProduto(){
        return estadoProduto;
    }

    public void setEstadoProduto(EnumEstadoProduto estadoProduto){
        this.estadoProduto= estadoProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public String getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(String tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }
 
    // public List<Pedido> getPedido() {
    //     return pedido;
    // }

    // public void setPedido(List<Pedido> pedido) {
    //     this.pedido = pedido;
    // }

    public void setId(long id) {
        this.id = id;
    }
  
}


