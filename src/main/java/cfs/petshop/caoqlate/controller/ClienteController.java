package cfs.petshop.caoqlate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cfs.petshop.caoqlate.dao.AgendamentosDAO;
import cfs.petshop.caoqlate.dao.DAO;
import cfs.petshop.caoqlate.model.Agendamentos;
import cfs.petshop.caoqlate.model.Cao;
import cfs.petshop.caoqlate.model.Cliente;
import cfs.petshop.caoqlate.model.Servicos;
import cfs.petshop.caoqlate.model.TipoServico;
import cfs.petshop.caoqlate.model.Usuario;

@Controller
public class ClienteController {
	
	@RequestMapping("menu")
	public String paginaInicial() {
		return "cliente/menu-cliente";
	}
	
	@RequestMapping("cadastroCao")
	public String formularioAddCao() {
		return "cliente/cadastro-cao";
	}
	
	@RequestMapping("adicionaCao")
	public String adiciona(@RequestParam("cliente") String idCliente,
						   @RequestParam("nome") String nomeCao,
						   @RequestParam("raca") String raca,
						   @RequestParam("porte") String porte) {
		DAO<Cliente> dao = new DAO<>(Cliente.class); 
		Cliente cliente = dao.buscaPorId(Long.parseLong(idCliente));
		Cao cao = new Cao();
		cao.setNome(nomeCao);
		cao.setRaca(raca);
		cao.setPorte(porte);
		cao.setCliente(cliente);
		cliente.getCaes().add(cao);
		dao.altera(cliente);
		return "redirect:menu";
	}
	
	@RequestMapping("agendarServico")
	public String agendarServico(Model model) {
		DAO<TipoServico> dao = new DAO<>(TipoServico.class);
		model.addAttribute("servicos",dao.listaTodos());
		return "cliente/agendar-servico";
	}
	
	@RequestMapping("realizaAgendamento")
	public String realizaAgendamento(@RequestParam("selectedServicos") List<String> selectedServicos,
									 @RequestParam("data") String data,
									 @RequestParam("selectedCao") String caoId,
									 @RequestParam("cliente") String clienteId) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(data);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AgendamentosDAO dataValida = new AgendamentosDAO();
        List<Agendamentos> l = dataValida.buscaAgendamentosDate(calendar);
		if(l.size() == 0) {
			Agendamentos agendamento = new Agendamentos();
			Double valor = 0d;
			int numServico = 0;
			List<Servicos> existingServicos = new ArrayList<>();
			for(String servico : selectedServicos) {
				TipoServico existingServico = new DAO<TipoServico>(TipoServico.class).buscaPorId(Long.parseLong(servico));
				Servicos s = new Servicos();
				s.setTipoServico(existingServico);
				existingServicos.add(s);
				valor += existingServico.getPreco();
				numServico ++;
			}
	        
	        agendamento.setData(calendar);
	        Cao cao = new DAO<Cao>(Cao.class).buscaPorId(Long.parseLong(caoId));
	        agendamento.setCao(cao);
	        
	        if(numServico >= 3) {
	        	valor = valor * 0.9;
	        }
	        agendamento.setValor(valor);
	         
			Cliente cliente = new DAO<>(Cliente.class).buscaPorId(Long.parseLong(clienteId));
	        agendamento.setCliente(cliente);
	        
	        agendamento.setServicos(existingServicos);
	        
	        DAO<Agendamentos> dao = new DAO<>(Agendamentos.class);
	        dao.adiciona(agendamento);
			return "redirect:menu";
		}else {
			
			return "redirect:agendarServico";
		}
		
	}
	
	@RequestMapping("editarPerfil")
	public String editarPerfil() {
		return "cliente/edita-perfil";
	}
	
	@RequestMapping("alterarPerfil")
	public String alterarPerfil(Cliente cliente) {
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.altera(cliente);
		return "redirect:menu";
	}
	
	@RequestMapping("trocarSenha")
	public String alteraUsuario(Usuario user) {
		DAO<Usuario> dao = new DAO<>(Usuario.class);
		dao.altera(user);
		return "redirect:menu";
	}
	
	@RequestMapping("servicosPendentes")
	public String servicosPendentes() {
		return "cliente/listar-pendentes";
	}
	
	@ResponseBody
	@RequestMapping("removeAgendamentoAjax")
	public void removeAgendamentoAjax(Agendamentos agendamento) {
		DAO<Agendamentos> dao = new DAO<>(Agendamentos.class);
		dao.remove(agendamento);
	}
	
	@RequestMapping("servicosPrestados")
	public String servicosPrestados() {
		return "cliente/lista-realizados";
	}
	
}
