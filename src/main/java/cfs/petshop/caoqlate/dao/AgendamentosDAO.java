package cfs.petshop.caoqlate.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cfs.petshop.caoqlate.model.Agendamentos;
import cfs.petshop.caoqlate.model.Cliente;

public class AgendamentosDAO {
	EntityManager manager;

	public AgendamentosDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public List<Agendamentos> buscaAgendamentosPendentes(Cliente cliente) {
		Query query = manager.createQuery(
				"SELECT a FROM Agendamentos a " +
						"WHERE a.realizado = false AND a.cliente = :cliente", Agendamentos.class);

		query.setParameter("cliente", cliente);

		return query.getResultList();
	}
	
	public List<Agendamentos> buscaAgendamentosRealizados(Cliente cliente) {
		Query query = manager.createQuery(
				"SELECT a FROM Agendamentos a " +
						"WHERE a.realizado = true AND a.cliente = :cliente", Agendamentos.class);

		query.setParameter("cliente", cliente);

		return query.getResultList();
	}

	public List<Agendamentos> buscaAgendamentosDate(Calendar date) {
		Query query = manager.createQuery(
				"SELECT a FROM Agendamentos a " +
						"WHERE a.data = :date", Agendamentos.class);

		query.setParameter("date", date);

		return query.getResultList();
	}
	
	public List<Agendamentos> agendamentosPorData(Calendar dataInicio){
		Query query = manager.createQuery("SELECT a FROM Agendamentos a "
				+ "WHERE a.realizado = false AND a.data > :dataInicio ORDER BY a.data", Agendamentos.class);
		query.setParameter("dataInicio", dataInicio);
		return query.getResultList();
	}
	
	public List<Agendamentos> agendamentosPorPeriodo(Calendar dataInicio, Calendar dataFim){
		Query query = manager.createQuery("SELECT a FROM Agendamentos a "
                + "WHERE a.realizado = true AND a.data BETWEEN :dataInicio AND :dataFim ORDER BY a.data", Agendamentos.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        
        return query.getResultList();
	}

}
