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

import br.com.pecapreco.http.ClienteHTTP;
import br.com.pecapreco.modelo.dao.ClienteDAO;
import br.com.pecapreco.modelo.model.Cliente;

/**
 * Classe responsável por conter os métodos REST para cliente 
 * 
 * @author FilippePimentel
 */
//http://localhost:9090/APIRestFul/rest/cliente

@Path("/cliente")
public class ClienteResource {

	private final ClienteDAO cliDao = new ClienteDAO();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(ClienteHTTP cliHTTP) {

		Cliente cli = new Cliente();

		try {
			cli.setNome(cliHTTP.getNome());
			cli.setUsuario(cliHTTP.getUsuario());
			cli.setSenha(cliHTTP.getSenha());
			cli.setCpf(cliHTTP.getCpf());
			cliDao.salvar(cli);

			return "Registro cadastrado com sucesso!";
		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}

	@GET
	@Path("/listarTodos")
	@Produces("application/json; charset=UTF-8")
	public List<ClienteHTTP> listarTodos() {
		
		List<Cliente> clientes = cliDao.lerTodos();
		List<ClienteHTTP> clientesHTTP2 = new ArrayList<ClienteHTTP>();
		
		for(Cliente cli: clientes) {
			clientesHTTP2.add(cli.criarJsonComCarros());
		}
		return clientesHTTP2;
	}

	@GET
	@Path("/buscarPorNome")
	@Produces("application/json")
	public ClienteHTTP buscarClientePeloNome(@QueryParam("nome") String nome) {

		Cliente cli = new Cliente();
		try {
			cli = cliDao.buscarPorNome(nome);
		} catch (Exception ex) {
			cli = null;
		}
		return cli.criarJsonComCarros();
	}

	@GET
	@Path("/buscarPorID")
	@Produces("application/json")
	public ClienteHTTP buscarClientePeloId(@QueryParam("id") String id) {
		
		Cliente clic = cliDao.lerPorId(Integer.parseInt(id));
		
		return clic.criarJsonComCarros();
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir")
	public String Excluir(String RestId) {
		try {
			JSONObject JsonObj = new JSONObject(RestId);
			Cliente cli = cliDao.lerPorId(JsonObj.getInt("id"));
			cliDao.excluir(cli);
			return "Registro Excluido com sucesso!";
		} catch (Exception e) {
			return "Erro ao excluir o registro " + e.getMessage();
		}
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/atualizar")
	public String Atualizar(ClienteHTTP cliHTTP) {
		try {
			Cliente cli = cliDao.lerPorId(cliHTTP.getId());
			cli.setNome(cliHTTP.getNome());
			cli.setUsuario(cliHTTP.getUsuario());
			cli.setSenha(cliHTTP.getSenha());
			cli.setCpf(cliHTTP.getCpf());
			
			cliDao.salvar(cli);
			return "Registro Atualizado com sucesso!";
		} catch (Exception e) {
			return "Erro ao atualizar o registro " + e.getMessage();
		}
	}
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/login")
	public Boolean login(String loginRest) {
		try {
			JSONObject JsonObj = new JSONObject(loginRest);
			cliDao.login(JsonObj.getString("usuario"), JsonObj.getString("senha"));
			return true;
		} catch (Exception e) {
			//System.out.println(e);
			return false;
		}
		//{"usuario":"filippe@pimentel.com","senha":"123"}
	}
}