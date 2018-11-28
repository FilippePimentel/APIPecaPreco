package br.com.pecapreco.modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="id_cliente_fk", nullable= false)
	private Integer id_cliente;
	
	@Column(name = "placa_carro_fk",nullable = false, length=50)
	private String placa_carro;

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

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getPlaca_carro() {
		return placa_carro;
	}

	public void setPlaca_carro(String placa_carro) {
		this.placa_carro = placa_carro;
	}

	@Override
	public String toString() {
		return "OBD [id=" + id + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", datahora=" + datahora + ", id_cliente="
				+ id_cliente + ", placa_carro=" + placa_carro + "]";
	}

	public OBD(Integer id, Float s1, Float s2, Float s3, String datahora, Integer id_cliente, String placa_carro) {
		super();
		this.id = id;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.datahora = datahora;
		this.id_cliente = id_cliente;
		this.placa_carro = placa_carro;
	}

	public OBD() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datahora == null) ? 0 : datahora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
		result = prime * result + ((placa_carro == null) ? 0 : placa_carro.hashCode());
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
		if (id_cliente == null) {
			if (other.id_cliente != null)
				return false;
		} else if (!id_cliente.equals(other.id_cliente))
			return false;
		if (placa_carro == null) {
			if (other.placa_carro != null)
				return false;
		} else if (!placa_carro.equals(other.placa_carro))
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
	
	

	
}
