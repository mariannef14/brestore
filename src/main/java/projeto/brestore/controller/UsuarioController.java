package projeto.brestore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.brestore.dto.UsuarioLogin;
import projeto.brestore.dto.UsuarioResposta;
import projeto.brestore.dto.UsuarioRespostaToken;
import projeto.brestore.model.Usuario;
import projeto.brestore.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
		
	@Autowired
	private UsuarioService usuarioService;
	
	// ** Cadastrar Usuário **
	@PostMapping
	public ResponseEntity<UsuarioResposta> register(@Valid @RequestBody Usuario usuarioEntrada, HttpServletRequest req) {	
		return usuarioService.cadastrar(usuarioEntrada);
	}
	
	// ** Login (Receber Bearer Token) **
	@PostMapping("/login")
	public ResponseEntity<UsuarioRespostaToken> login(@Valid @RequestBody UsuarioLogin dadosLogin) {
		return usuarioService.login(dadosLogin);
	}
	
	// ** Teste **
	@GetMapping("/teste")
	public ResponseEntity<String> getNomePessoaLogada(HttpServletRequest requisicao) {
		return usuarioService.getNomePessoaLogada(requisicao);
	}

}
