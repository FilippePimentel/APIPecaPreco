package br.com.pecapreco.modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.pecapreco.http.CarroHTTP;
import br.com.pecapreco.http.CarroPorClienteHTTP;

@Entity
@Table(name = "tab_carro")
public class Carro {

	@Id
	@GeneratedValue (generator = "id_carro", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_carro", sequenceName = "SEQ_CARRO",initialValue=101, allocationSize=1)
	@Column(name="id_carro")
	private Integer Id;
	
	@Column (name="placa_carro",nullable = false, unique=true, length=50)
	private String placa;
	
	@Column (name="modelo_carro", nullable = false, unique=true,length=50)
	private String modelo;
	
	@Column (name="marca_carro",length=50, nullable = false)
	private String marca;
	
	@Column (name="kmlitro_carro", columnDefinition = "NUMERIC(15,2)", nullable = false)
	private Float kmLitro;
	
	@ManyToOne	//Um cliente pode ter vários carros
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	
	
	public Float getKmLitro() {
		return kmLitro;
	}

	public void setKmLitro(Float kmLitro) {
		this.kmLitro = kmLitro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Column (name="ano_carro", nullable = false)
	private Integer ano;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((kmLitro == null) ? 0 : kmLitro.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (kmLitro == null) {
			if (other.kmLitro != null)
				return false;
		} else if (!kmLitro.equals(other.kmLitro))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [Id=" + Id + ", placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", kmLitro="
				+ kmLitro + ", cliente=" + cliente + ", ano=" + ano + "]";
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
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	   public CarroPorClienteHTTP criarJsonSemCliente() {
	        return new CarroPorClienteHTTP(Id, placa, modelo, marca, ano, kmLitro);
	    }
	   
	   public CarroHTTP criarJsonComCliente() {
		
		   return new CarroHTTP(
				    Id,  placa,  modelo,  marca,  ano,  kmLitro
					, cliente == null? null:cliente.getId()
					, cliente == null? null:cliente.getNome()
					, cliente == null? null:cliente.getCpf()
					, cliente == null? null:cliente.getUsuario()
					, cliente == null? null:cliente.getSenha() 		);
	   }
}
