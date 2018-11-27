package br.com.pecapreco.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
	// usar a estratégia SINGLETON

	private UtilJPA() {
		super();
	}
	
	// criar a fábrica de EntityManager para o banco da aplicação
	private static EntityManagerFactory fabrica = 
						Persistence.createEntityManagerFactory("banco");
	
	public static EntityManager criarEntityManager()
	{
		return fabrica.createEntityManager();
	}

}
