package br.com.pecapreco.modelo.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONObject;

import br.com.pecapreco.http.CarroHTTP;
import br.com.pecapreco.modelo.dao.CarroDAO;
import br.com.pecapreco.modelo.dao.ClienteDAO;
import br.com.pecapreco.modelo.model.Carro;
/**
 * Classe responsável por conter os métodos REST para Carro 
 * 
 * @author FilippePimentel
 */

//http://localhost:9090/APIRestFul/rest/carro
@Path("/carro")
public class CarroResource {
	private final CarroDAO carDao = new CarroDAO();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(CarroHTTP carHTTP) {

		Carro car = new Carro();
		//ClienteDAO cliDAO = new ClienteDAO();
		
		try {
			car.setPlaca(carHTTP.getPlaca());
			car.setMarca(carHTTP.getMarca());
			car.setModelo(carHTTP.getModelo());
			car.setAno(carHTTP.getAno());
			car.setKmLitro(carHTTP.getKmLitro());
			//car.setCliente(cliDAO.lerPorId(carHTTP.getId_cliente()));
			carDao.salvar(car);
			
			return "Registro cadastrado com sucesso!";
		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	@GET
	@Path("/listarTodos")
	@Produces("application/json; charset=UTF-8")
	public List<CarroHTTP> listarTodos() {
		
		List<Carro> carros 	= carDao.lerTodos();
		List<CarroHTTP> carros2 = new ArrayList<CarroHTTP>();
		
		for(Carro car: carros) {
			
			carros2.add(car.criarJsonComCliente());
		}
		return carros2;
	}

	@GET
	@Path("/buscarPelaPlaca")
	@Produces("application/json")
	public Carro buscarCarroPelaPlaca(@QueryParam("placa") String placa) {

		Carro car = new Carro();
		try {
			car = carDao.buscarPorPlaca(placa);
		} catch (Exception ex) {
			car = null;
		}
		return car;
	}
	
	
	@GET
	@Path("/buscarPeloModelo")
	@Produces("application/json")
	public Carro buscarCarroPelaModelo(@QueryParam("modelo") String modelo) {

		Carro car = new Carro();
		try {
			car = carDao.buscarPorModelo(modelo);
		} catch (Exception ex) {
			car = null;
		}
		return car;
	}
	
	@GET
	@Path("/buscarPorID")
	@Produces("application/json")
	public Carro buscarCarroPeloId(@QueryParam("id") String id) {
		return carDao.lerPorId(Integer.parseInt(id));
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir")
	public String excluirCarro(String RestId) {
		try {
			JSONObject JsonObj = new JSONObject(RestId);
			Carro car = carDao.lerPorId(JsonObj.getInt("id"));
			carDao.excluir(car);
			return "Registro Excluido com sucesso!";
		} catch (Exception e) {
			return "Erro ao excluir o registro : " + e.getMessage();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/atualizar")
	public String atualizarCarro(String JsonCar) {
		try {
			CarroHTTP carHTTP = null;
			ClienteDAO cliDAO = new ClienteDAO();
			carHTTP = converterJSON(JsonCar, carHTTP, cliDAO);
			
			Carro car = carDao.lerPorId(carHTTP.getId());
			car.setPlaca(carHTTP.getPlaca());
			car.setMarca(carHTTP.getMarca());
			car.setModelo(carHTTP.getModelo());
			car.setAno(carHTTP.getAno());
			car.setKmLitro(carHTTP.getKmLitro());
			car.setCliente(cliDAO.lerPorId(carHTTP.getId_cliente()));
			
			carDao.salvar(car);
			return "Registro Atualizado com sucesso!";
		} catch (Exception e) {
			return "Erro ao atualizar o registro " + e.getMessage();
		}
	}
	
	public CarroHTTP converterJSON(String json, CarroHTTP carHTTP, ClienteDAO cliDAO) {
//				JSONObject JsonObj = new JSONObject(json);
				
//		carHTTP.setId(JsonObj.getInt("id"));
//		carHTTP.setMarca(JsonObj.getString("marca"));
//		carHTTP.setModelo(JsonObj.getString("modelo"));
//		carHTTP.setAno(JsonObj.getInt("ano"));
//		carHTTP.setKmLitro(JsonObj.getFloat("kmLitro"));
//		carHTTP.setPlaca(JsonObj.getString("placa"));
//		//carHTTP.setId_cliente(1);
				
				
		return null;
	}
	
}
