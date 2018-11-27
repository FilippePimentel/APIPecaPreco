package br.com.pecapreco.modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.pecapreco.modelo.model.Carro;
import br.com.pecapreco.modelo.model.Cliente;

public class CarroDAO extends JpaDAO<Carro> {
	
	
	public Carro buscarPorModelo(String modelo) {
		String conector = " where ";
		String jpql = "from Carro d";

		if (modelo != null) {
			jpql = jpql + conector + "d.modelo = :modelo";
		}

		TypedQuery<Carro> comando = this.getEntityManager().createQuery(jpql, Carro.class);

		if (modelo != null) {
			comando.setParameter("modelo", modelo);
		}

		return comando.getSingleResult();
	}
	
	public Carro buscarPorPlaca(String placa) {
		
		String conector = " where ";
		String jpql = "from Carro car";

		if (placa != null) {
			jpql = jpql + conector + "car.placa = :placa";
		}

		TypedQuery<Carro> comando = this.getEntityManager().createQuery(jpql, Carro.class);

		if (placa != null) {
			comando.setParameter("placa", placa);
		}

		return comando.getSingleResult();
	}
	
}
