package service;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

import dao.EscalacaoDAO;
import model.Escalacao;

public class EscalacaoService {
	private EscalacaoDAO escalacaoDAO = new EscalacaoDAO();

	public String consultarEscalacao(Integer id, Request request) {
		try {
			Escalacao escalacao = escalacaoDAO.get(id);
			return escalacao.toJson().toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao consultar Escalacao";
		}
	}
	
	public String listarEscalacao(Request request) {
		try {
			return listaEscalacaoJSON().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao consultar Escalacao";
		}
	}
	
	public String adicionarEscalacao(Request request) {
		Query query = request.getQuery();

		try {
			Escalacao escalacao = new Escalacao();
			escalacao.setId(query.get("id"));
			escalacao.setListaJogador(query.get("Lista de Jogadores"));
			escalacao.setFinalizado(query.getBoolean("Finalizado"));
			
			escalacaoDAO.add(escalacao);

			return listaEscalacaoJSON().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao adicionar Escalacao";
		}
	}
	
	
	public String atualizarEscalacao(Request request) {
		Query query = request.getQuery();

		try {
			Escalacao escalacao = new Escalacao();
			escalacao.setId(query.get("id"));
			escalacao.setListaJogador(query.get("Lista de Jogadores"));
			escalacao.setFinalizado(query.getBoolean("Finalizado"));

			escalacaoDAO.update(escalacao);

			return listaEscalacaoJSON().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao atualizar Escalacao";
		}
	}
	
	public String removerEscalacao(Request request) {
		Query query = request.getQuery();
		
		try {
			Escalacao escalacao = new Escalacao();
			escalacao.setId(query.getInteger("id"));
			
			escalacaoDAO.delete(escalacao);
			
			return listaEscalacaoJSON().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao excluir Escalacao.";
		}
	}
	
	private JSONObject listaEscalacaoJSON() throws NumberFormatException, IOException {
		List<Escalacao> listaEscalacao = escalacaoDAO.getAll();

		JSONArray array = new JSONArray();
		for (Escalacao j : listaEscalacao) {
			array.put(j.toJson());
		}
		JSONObject obj = new JSONObject();
		obj.put("listaEscalacao", new JSONArray(listaEscalacao));

		return obj;
	}
}
	
	
	