package br.com.pecapreco.modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pecapreco.modelo.model.OBD;

public class ObdDAO extends JpaDAO<OBD>{
	
	public List<OBD> buscarOBDPorPlaca(String placa){
		String conector = " where ";
		String jpql = "from OBD d";
		
			if(placa!=null) {
				
				jpql= jpql + conector +"d.placa_carro = :placa";
			}
			
			jpql = jpql + " order by d.id";
			
			TypedQuery<OBD> comando =  this.getEntityManager().createQuery(jpql, OBD.class);
			
			if (placa != null) {
			comando.setParameter("placa", placa);
			}
		
			return comando.getResultList();
	}
	
}
