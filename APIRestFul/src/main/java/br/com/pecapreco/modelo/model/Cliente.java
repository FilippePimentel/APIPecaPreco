package br.com.pecapreco.modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.pecapreco.http.CarroPorClienteHTTP;
import br.com.pecapreco.http.ClienteHTTP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * 
 * Classe responsável por conter os atributos do Objeto Cliente
 * @author FilippePimentel
 *
 */
@Entity
@Table(name = "tab_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue (generator = "id_cliente", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_cliente", sequenceName = "SEQ_CLIENTE",initialValue=110, allocationSize=1)
	@Column(name="id_cliente")
	private Integer Id;
	@Column (name="nome_cliente",nullable = false, unique=true, length=50)
	private String nome;
	@Column (name="cpf_cliente", nullable = false, unique=true, length=11)
	private String cpf;
	@Column (name="usuario_cliente", nullable = false,length=50)
	private String usuario;
	@Column (name="senha_cliente", nullable = false,length=20)
	private String senha;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Carro> carros;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((carros == null) ? 0 : carros.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (carros == null) {
			if (other.carros != null)
				return false;
		} else if (!carros.equals(other.carros))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", nome=" + nome + ", cpf=" + cpf + ", usuario=" + usuario + ", senha=" + senha
				+ ", carros=" + carros + "]";
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ClienteHTTP criarJsonComCarros() {
		
		List<CarroPorClienteHTTP> c = carros.stream().map(Carro::criarJsonSemCliente).collect(Collectors.toList());
		return new ClienteHTTP(Id, nome, cpf, usuario, senha,
				 c);
	}
	
}
