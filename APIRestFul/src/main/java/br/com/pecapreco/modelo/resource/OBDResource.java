package br.com.pecapreco.modelo.resource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.MAX;
import org.json.JSONArray;
import org.json.JSONObject;

import br.com.pecapreco.http.CarroHTTP;
import br.com.pecapreco.http.OBDConverter;
import br.com.pecapreco.modelo.dao.CarroDAO;
import br.com.pecapreco.modelo.dao.ObdDAO;
import br.com.pecapreco.modelo.model.Carro;
import br.com.pecapreco.modelo.model.OBD;

/**
 * Classe responsável por conter os métodos REST para OBD
 * 
 * @author FilippePimentel
 */

//http://localhost:9090/APIRestFul/rest/obd
@Path("/obd")
public class OBDResource {

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/enviarListaDeDados")
	public void receberListaDeDados(String ArrayJsonOBD) {
		
		ObdDAO obdDao = new ObdDAO();
		JSONArray jarray = new JSONArray(ArrayJsonOBD);
		

		if (!jarray.isEmpty()) {
			Carro car = retornarCarro(jarray.getJSONObject(1).getString("placa"));
			for (int i = 0 ; i < jarray.length(); i++) {
				OBD obd = new OBD();
				obd.setS1(jarray.getJSONObject(i).getFloat("s1")); // speed Km/h
				obd.setS2(jarray.getJSONObject(i).getFloat("s2")); // fuel L
				obd.setS3(jarray.getJSONObject(i).getFloat("s3")); // temperature ºC
				obd.setDatahora(jarray.getJSONObject(i).getString("dataHora"));
				obd.setId_cliente(car.getCliente().getId());
				obd.setPlaca_carro(car.getPlaca());
				
				obdDao.salvar(obd);
			}
		}
	}

	public Carro retornarCarro(String placa) {
		CarroDAO carDao = new CarroDAO();
		return carDao.buscarPorPlaca(placa);
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/enviarDados")
	public void receberDados(String JsonOBD) {
		try {
			JSONObject JsonObj = new JSONObject(JsonOBD);
			OBDConverter OBDcon = new OBDConverter(JsonObj.getFloat("s1"), // speed Km/h
					JsonObj.getFloat("s2"), // fuel L
					JsonObj.getFloat("s3"), // temperature ºC
					JsonObj.getString("dataHora"), JsonObj.getString("placa"));

			OBD obd = new OBD();

			obd.setPlaca_carro(OBDcon.getCarro().getPlaca());
			obd.setS1(OBDcon.getS1());
			obd.setS2(OBDcon.getS2());
			obd.setS3(OBDcon.getS3());
			obd.setId_cliente(OBDcon.getCliente().getId());
			obd.setDatahora(OBDcon.getDatahora());

			ObdDAO obdDao = new ObdDAO();

			obdDao.salvar(obd);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@GET
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/pedirDados")
	public List<OBD> enviarDados(@QueryParam("placa") String placa) {
		ObdDAO obdDao = new ObdDAO();
		return obdDao.buscarOBDPorPlaca(placa);
	}

}
