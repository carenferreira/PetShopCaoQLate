package cfs.petshop.caoqlate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import cfs.petshop.caoqlate.model.Cliente;
import cfs.petshop.caoqlate.model.Usuario;

public class UsuarioDAO {
	EntityManager manager;

	public UsuarioDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public Usuario validaLogin(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		Query query = manager.createQuery(" SELECT u FROM Usuario u where u.login = :login and u.senha = :senha ",
				Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		List<Usuario> usuarios = query.getResultList();
		if (usuarios.size() == 0)
			return null;
		else 
			return usuarios.get(0);
			
	}
	
	public Cliente buscaCliente(String usuario) {
	    CriteriaBuilder builder = manager.getCriteriaBuilder();
	    CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
	    Root<Cliente> root = query.from(Cliente.class);

	    // Buscando cliente pelo login
	    Subquery<String> subquery = query.subquery(String.class);
	    Root<Usuario> usuarioRoot = subquery.from(Usuario.class);
	    subquery.select(usuarioRoot.get("login"));
	    subquery.where(builder.equal(usuarioRoot.get("login"), usuario));
	    query.where(builder.in(root.get("email")).value(subquery));

	    try {
	        return manager.createQuery(query).getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

}
