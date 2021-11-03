package projeto.brestore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@Email
	@Column(unique = true)
	@NotBlank
	private String email;
	
	@Size(min = 4, message = "O nome deve conter 4 caracteres no mínimo")
	@NotBlank
	private String nome;
	
	@Column(unique = true, length = 15)
	@Size(min = 6, message = "A senha deve conter 6 caracteres no mínimo e 15 caracteres no máximo")
	@NotBlank
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedido;

	public Usuario() {}

	public Usuario(String email, String nome, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// public List<Pedido> getPedido() {
    //     return pedido;
    // }

    // public void setPedido(List<Pedido> pedido) {
    //     this.pedido = pedido;
    // }

}
