package cfs.petshop.caoqlate.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cfs.petshop.caoqlate.model.Cao;
import cfs.petshop.caoqlate.model.Cliente;

public class ClienteDAO {
	public List<Cao> getCaoListByClienteId(Long clienteId) {
	    EntityManager em = new JPAUtil().getEntityManager();
	    try {
	        Cliente cliente = em.find(Cliente.class, clienteId);
	        if (cliente != null) {
	            return cliente.getCaes();
	        }
	        return Collections.emptyList(); 
	    } finally {
	        em.close();
	    }
	}
	public List<Cao> buscaCaesPorCliente(Long clienteId) {
		EntityManager manager = new JPAUtil().getEntityManager();
	    String jpql = "SELECT c FROM Cao c WHERE c.cliente.id = :clienteId";
	    TypedQuery<Cao> query = manager.createQuery(jpql, Cao.class);
	    query.setParameter("clienteId", clienteId);

	    return query.getResultList();
	}
}
