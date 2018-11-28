package br.com.pecapreco.http;

import br.com.pecapreco.modelo.dao.CarroDAO;
import br.com.pecapreco.modelo.model.Carro;
import br.com.pecapreco.modelo.model.Cliente;

public class OBDConverter {

	private Integer id;
	private Float s1 ;

	private Float s2;
	private Float s3;
	private String datahora;
	private Cliente cliente;
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
	public String toString() {
		return "OBDConverter [id=" + id + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", datahora=" + datahora
				+ ", cliente=" + cliente + ", carro=" + carro + "]";
	}
	
	public OBDConverter(Float s1, Float s2, Float s3, String datahora, String placa) {
		
		CarroDAO carDAO = new CarroDAO(); 
		Carro car = new Carro(); 
		try {
		car=carDAO.buscarPorPlaca(placa);
		}catch(Exception ex) {
			System.out.println("Erro: "+ex);
			car.setCliente(null);
		}
		
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.datahora = datahora;
		this.cliente = car.getCliente()==null?null:car.getCliente();
		this.carro = car==null ? null :car;
	}
	public OBDConverter() {
		// TODO Auto-generated constructor stub
	}
	
}
