package cfs.petshop.caoqlate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import cfs.petshop.caoqlate.model.TipoServico;

@Controller
public class AdministradorController {
	
	@RequestMapping("menuAdm")
	public String paginaInicialAdm() {
		return "adm/menu";
	}
	
	@RequestMapping("cadastroServico")
	public String cadastroServico() {
		return "adm/cadastro-servico";
	}
	
	@RequestMapping("adicionaServico")
	public String adicionaServico(TipoServico servico) {
		DAO<TipoServico> dao = new DAO<>(TipoServico.class);
		dao.adiciona(servico);
		return "redirect:menuAdm";
	}
	
	@RequestMapping("alterarServico")
	public String alteraServico(Model model) {
		DAO<TipoServico> dao = new DAO<>(TipoServico.class);
		model.addAttribute("servicos",dao.listaTodos());
		return "adm/altera-servico";
	}
	
	@RequestMapping("mostraServico")
	public String mostraServico(TipoServico servico, Model model) {
		DAO<TipoServico> dao = new DAO<>(TipoServico.class);
		TipoServico servicoAlterar = dao.buscaPorId(servico.getId());
		model.addAttribute("servico",servicoAlterar);
		return "adm/edita-servico";
	}
	
	@RequestMapping("editaServico")
	public String editaServico(TipoServico servico) {
		DAO<TipoServico> dao = new DAO<>(TipoServico.class);
		dao.altera(servico);
		return "redirect:alterarServico";
	}
	
	@RequestMapping("agendaDeServicos")
	public String agendaDeServico() {
		return "adm/agenda-servicos";
	}
	
	@RequestMapping("buscaPorData")
	public String buscaPorData(@RequestParam String data, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(data);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		List<Agendamentos> agendamentos = new AgendamentosDAO().agendamentosPorData(calendar);
		model.addAttribute("agendamentos", agendamentos);
		return "adm/agenda-servicos";
	}
	
	@RequestMapping("lancarServico")
	public String lancarServico() {
		return "adm/lancar-servico";
	}
	
	@RequestMapping("buscaPorDataFinalizacao")
	public String buscaPorDataFinalizacao(@RequestParam String data, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(data);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		List<Agendamentos> agendamentos = new AgendamentosDAO().buscaAgendamentosDate(calendar);
		model.addAttribute("agendamentos", agendamentos);
		return "adm/lancar-servico";
	}
	
	@ResponseBody
	@RequestMapping("servicoRealizado")
	public void servicoRealizado(Agendamentos agendamento) {
		DAO<Agendamentos> dao = new DAO<>(Agendamentos.class);
		agendamento = dao.buscaPorId(agendamento.getId());
		agendamento.setRealizado(true);
		dao.altera(agendamento);
	} 
	
	@RequestMapping("relatorioDeServicos")
	public String relatorioDeServicos() {
		return "adm/relatorio-servicos";
	}
	
	@RequestMapping("buscaPorIntervalo")
	public String buscaPorIntervalo(@RequestParam String dataInicio, 
									@RequestParam String dataFim, Model model, Model valor) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendarInicio = Calendar.getInstance();
        try {
            Date date = sdf.parse(dataInicio);
            calendarInicio.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Calendar calendarFim = Calendar.getInstance();
        try {
            Date date = sdf.parse(dataFim);
            calendarFim.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        List<Agendamentos> agendamentos = new AgendamentosDAO().agendamentosPorPeriodo(calendarInicio,calendarFim);
        System.out.println(agendamentos.size());
		model.addAttribute("agendamentos", agendamentos);
		
		Double valorTotal = 0d;
		for(Agendamentos a : agendamentos) {
			valorTotal += a.getValor();
		}
		
		valor.addAttribute("valotTotal", valorTotal);
		return "adm/relatorio-servicos";
        
	}
	
}

