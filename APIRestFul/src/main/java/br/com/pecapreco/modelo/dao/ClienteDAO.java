package br.com.pecapreco.modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pecapreco.modelo.model.Cliente;



public class ClienteDAO extends JpaDAO<Cliente>{

	public List<Cliente> listar(String nome){
		String conector = " where ";
		String jpql = "from Cliente d";
		
			if(nome!=null) {
				
				jpql= jpql + conector +"d.nome like :nome";
			}
			
			jpql = jpql + " order by d.nome";
			
			TypedQuery<Cliente> comando =  this.getEntityManager().createQuery(jpql, Cliente.class);
			
			if (nome != null) {
			comando.setParameter("nome", "%" + nome + "%");
			}
		return comando.getResultList();
	}
	
	public Cliente buscarPorNome(String nome){
		String conector = " where ";
		String jpql = "from Cliente d";
		
			if(nome!=null) {
				
				jpql= jpql + conector +"d.nome = :nome";
			}
			
			TypedQuery<Cliente> comando =  this.getEntityManager().createQuery(jpql, Cliente.class);
			
			if (nome != null) {
			comando.setParameter("nome", nome);
			}
		
			return comando.getSingleResult();
	}
	
	public Cliente login(String usuario, String senha){
		String conector = " where ";
		String jpql = "from Cliente c";
		
			if(usuario!=null && senha!=null) {
				
				jpql= jpql + conector +"c.usuario = :usuario and c.senha = :senha";
			}
			
			TypedQuery<Cliente> comando =  this.getEntityManager().createQuery(jpql, Cliente.class);
			
			if (usuario!=null && senha!=null) {
			comando.setParameter("usuario", usuario);
			comando.setParameter("senha", senha);
			}
			return comando.getSingleResult();
	}
}
