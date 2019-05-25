package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Escalacao implements JsonFormatter {

	private Integer id;
	private boolean finalizado;
	private List<Jogador> listaJogador;
	private Campeonato campeonato;

	public Escalacao() {
		this.setFinalizado(false);
		this.listaJogador = new ArrayList<Jogador>();
	}

	public void incluirJogador(Jogador jogador) {
		if (listaJogador.size() < 11) {
			this.listaJogador.add(jogador);

		} else {
			System.out.println("Escalação Completa");
		}
	}



	public void finalizarEscalacao() {
		if (listaJogador.size() == 11)
			setFinalizado(true);
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public List<Jogador> getListaJogador() {
		return listaJogador;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public void setListaJogador(List<Jogador> listaJogador) {
		this.listaJogador = listaJogador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("listaJogadores",toJsonArray());
		obj.put("estaSuspenso", this.finalizado);
		obj.put("campeonato",this.campeonato);

		return obj;
	}
	
	@Override // exemplo de time
	public JSONArray toJsonArray() {
		JSONArray array = new JSONArray();
		for (Jogador j : this.listaJogador) {
			array.put(j.toJson());
		}
		return array;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Escalacao) obj).id;
	}
}
