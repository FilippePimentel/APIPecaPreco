package br.com.pecapreco.modelo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 
 * Classe responsável por conter os atributos do Objeto Obd
 * @author FilippePimentel
 *
 */
@Entity
@Table(name = "tab_obd")
public class OBD {
	
	@Id
	@GeneratedValue (generator = "id_obd", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "id_obd", sequenceName = "SEQ_OBD",initialValue=110, allocationSize=1)
	@Column(name="id_obd")
	private Integer id;
	@Column (name="s1_obd", columnDefinition = "NUMERIC(15,2)")
	private Float s1 ;
	@Column (name="s2_obd", columnDefinition = "NUMERIC(15,2)")
	private Float s2;
	@Column (name="s3_obd", columnDefinition = "NUMERIC(15,2)")
	private Float s3;
	
	@Column(name="data_obd", nullable= false)
	private String datahora;
	
	@ManyToOne	//Um cliente pode ter várias consultas OBD
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;
	@ManyToOne	//Um carro pode estar várias consultas OBD
	@JoinColumn(name = "id_carro_fk")
	private Carro carro;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getS1() {
		return s1;
	}
	public void setS1(Float s1) {
		this.s1 = s1;
	}
	public Float getS2() {
		return s2;
	}
	public void setS2(Float s2) {
		this.s2 = s2;
	}
	public Float getS3() {
		return s3;
	}
	public void setS3(Float s3) {
		this.s3 = s3;
	}
	public String getDatahora() {
		return datahora;
	}
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((datahora == null) ? 0 : datahora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((s1 == null) ? 0 : s1.hashCode());
		result = prime * result + ((s2 == null) ? 0 : s2.hashCode());
		result = prime * result + ((s3 == null) ? 0 : s3.hashCode());
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
		OBD other = (OBD) obj;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (datahora == null) {
			if (other.datahora != null)
				return false;
		} else if (!datahora.equals(other.datahora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (s1 == null) {
			if (other.s1 != null)
				return false;
		} else if (!s1.equals(other.s1))
			return false;
		if (s2 == null) {
			if (other.s2 != null)
				return false;
		} else if (!s2.equals(other.s2))
			return false;
		if (s3 == null) {
			if (other.s3 != null)
				return false;
		} else if (!s3.equals(other.s3))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OBD [id=" + id + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", datahora=" + datahora + ", cliente="
				+ cliente + ", carro=" + carro + "]";
	}
	

	
}
