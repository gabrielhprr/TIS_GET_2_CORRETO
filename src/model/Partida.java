package model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

import org.json.JSONObject;

import exceptions.LimiteEstatisticaJogador;

public class Partida implements JsonFormatter {
	private Integer id;
	static final int LIMITE_ESTATISTICA_JOGADOR = 18;

	private List<Estatistica> estatisticasJogador;

	public Partida() {
		this.estatisticasJogador = new ArrayList<Estatistica>();
	}

	public Integer getId() {
		return id;
	}

	public List<Estatistica> getEstatisticasJogador() {
		return estatisticasJogador;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEstatisticasJogador(List<Estatistica> estatisticasJogador) {
		this.estatisticasJogador = estatisticasJogador;
	}

	public void inserirEstatistica(Estatistica estatistica) throws LimiteEstatisticaJogador {

		if (estatisticasJogador.size() < 18 && estatistica != null) {
			estatisticasJogador.add(estatistica);
		}else {
			throw new LimiteEstatisticaJogador();
		}

	}

	@Override
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.id);
		obj.put("estatisticas", this.estatisticasJogador.toArray());
		return obj;
	}

	@Override // exemplo de time
	public JSONArray toJsonArray() {
		JSONArray array = new JSONArray();
		for (Estatistica j : this.estatisticasJogador) {
			array.put(j.toJson());
		}
		return array;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Partida) obj).id;
	}
}
