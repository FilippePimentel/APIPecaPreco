package br.com.pecapreco.http;

public final class CarroHTTP {

	private final Integer 	Id;
	private final String 	placa;
	private final String 	modelo;
	private final String 	marca;
	private final Integer 	ano;
	private final Float 	kmLitro;
	
	private final Integer 	id_cliente;
	private final String 	nome_cliente;
	private final String 	cpf_cliente;
	private final String 	usuario_cliente;
	private final String 	senha_cliente;
	
	public CarroHTTP(Integer id, String placa, String modelo, String marca, Integer ano, Float kmLitro,
			Integer id_cliente, String nome_cliente, String cpf_cliente, String usuario_cliente, String senha_cliente) {
		super();
		Id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.kmLitro = kmLitro;
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.cpf_cliente = cpf_cliente;
		this.usuario_cliente = usuario_cliente;
		this.senha_cliente = senha_cliente;
	}



	public Integer getId() {
		return Id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public Integer getAno() {
		return ano;
	}

	public Float getKmLitro() {
		return kmLitro;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public String getUsuario_cliente() {
		return usuario_cliente;
	}

	public String getSenha_cliente() {
		return senha_cliente;
	}
}
