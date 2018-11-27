package br.com.pecapreco.http;

import java.util.List;

public class ClienteHTTP {
	private final Integer Id;
	private final String nome;
	private final String cpf;
	private final String usuario;
	private final String senha;

	 private final List<CarroPorClienteHTTP> carros;

	public ClienteHTTP(Integer id, String nome, String cpf, String usuario, String senha,
			List<CarroPorClienteHTTP> carros) {
		super();
		Id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
		this.carros = carros;
	}

	public Integer getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public List<CarroPorClienteHTTP> getCarros() {
		return carros;
	}
	 
}
