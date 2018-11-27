package br.com.pecapreco.http;

public final class CarroPorClienteHTTP {
	private final Integer 	Id;
	private final String 	placa;
	private final String 	modelo;
	private final String 	marca;
	private final Integer 	ano;
	private final Float 	kmLitro;
	public CarroPorClienteHTTP(Integer id, String placa, String modelo, String marca, Integer ano, Float kmLitro) {
		super();
		Id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.kmLitro = kmLitro;
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
	
	
}
