package br.com.pecapreco.http;

public class CarroConverter {
	private  Integer 	Id;
	private  String 	placa;
	private  String 	modelo;
	private  String 	marca;
	private  Integer 	ano;
	private  Float 	kmLitro;
	
	
	
	public CarroConverter() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Float getKmLitro() {
		return kmLitro;
	}
	public void setKmLitro(Float kmLitro) {
		this.kmLitro = kmLitro;
	}
	
	
	
	
}



