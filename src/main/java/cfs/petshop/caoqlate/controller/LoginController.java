package cfs.petshop.caoqlate.controller;

import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfs.petshop.caoqlate.dao.DAO;
import cfs.petshop.caoqlate.dao.UsuarioDAO;
import cfs.petshop.caoqlate.model.Cliente;
import cfs.petshop.caoqlate.model.EmailInfo;
import cfs.petshop.caoqlate.model.EmailSender;
import cfs.petshop.caoqlate.model.Usuario;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		Usuario usuarioLogado = new UsuarioDAO().validaLogin(usuario); 
		if (usuarioLogado != null){
			session.setAttribute("usuarioLogado", usuarioLogado);
			if(usuarioLogado.getTipo() == 1)
				return "redirect:menu";
			else if(usuarioLogado.getTipo() == 2)
				return "redirect:menuAdm";
		}
		return "redirect:cadastroCliente";
	}
	
	@RequestMapping("cadastroCliente")
	public String formularioAddCliente() {
		return "cliente/cadastro-cliente";
	}
	
	@RequestMapping("adicionaCliente")
	public String adicionaCliente(Cliente cliente) {
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.adiciona(cliente);
		return "cliente/cadastro-usuario";
	}
	
	@RequestMapping("emailConfirmacao")
	public String emailConfirmacao(Usuario user) {
		EmailInfo info = new EmailInfo();
		String message = (String.format("Estamos quase lá! Para concluir seu cadastro basta acessar:"
				+ "http://localhost:8080/PetShopCaoQLate/adicionaUsuario"));
		try {
			EmailSender.sendEmail(info.getSmtpHost(),info.getSmtpPorta(),info.getUser(),info.getSenha(),info.getFrom(),
					user.getLogin(),"Nova Conta!", message);
		} catch (EmailException i) {
			i.printStackTrace();
		}
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		user.setTipo(1);
		dao.adiciona(user);
		return "email-confirmacao";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adicionaUsuario(Usuario user) {
		return "redirect:loginForm";
	}
	
	@RequestMapping ("logout")
	public String logout (HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
	}
}
