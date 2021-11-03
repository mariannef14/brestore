package projeto.brestore.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToMany;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM")
    @Column(name = "Data", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "Endereço", nullable = false)
    private String enderecoPedido;
    
    @Column(name = "Total", nullable = false)
    private Double totalPedido;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "Pedido_Produto",
               joinColumns = @JoinColumn(
               name = "idPedido",  nullable = false, referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(
               name = "idProduto",  nullable = false, referencedColumnName = "id"))
    private List<Produto> produto;

    public Pedido(){}

    public Pedido(LocalDateTime dataPedido, String enderecoPedido, Double totalPedido, Usuario usuario){

        this.dataPedido = dataPedido;
        this.enderecoPedido = enderecoPedido;
        this.totalPedido = totalPedido;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = LocalDateTime.now();
    }

    public String getEnderecoPedido() {
        return enderecoPedido;
    }

    public void setEnderecoPedido(String enderecoPedido) {
        this.enderecoPedido = enderecoPedido;
    }
 
    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario= usuario;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
  
}



