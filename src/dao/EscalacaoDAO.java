package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Campeonato;
import model.Escalacao;
import model.Jogador;

public class EscalacaoDAO {
	static final String ARQUIVO = "escalacao.txt";
	static final String SEQUENCE = "sequence_escalacao.txt";

	JogadorDAO jogadorDAO = new JogadorDAO();
	CampeonatoDAO campeonatoDAO = new Campeonato();

	
	public Escalacao get(Integer id) {
		Escalacao retorno = null;
		Escalacao j = null;

		try (BufferedReader buffer_entrada = new BufferedReader(new FileReader(ARQUIVO))) {
			String linha;

			while ((linha = buffer_entrada.readLine()) != null) {
				String[] dados = linha.split(";");

				j = new Escalacao();
				j.setId(Integer.parseInt(dados[0]));
				j.setFinalizado(Boolean.parseBoolean(dados[1]));

				if (dados.length > 1 && !dados[1].equals("")) {
					String[] idJogadores = dados[2].split("-");
					for (String s : idJogadores) {
						Integer idJogador = Integer.parseInt(s);
						Jogador jogador = jogadorDAO.get(idJogador);

						j.getListaJogador().add(jogador);
					}
				}
				if (id.equals(j.getId())) {
					retorno = j;
					break;
				}
			}

			return null;
		} catch (Exception e) {
			System.out.println("ERRO ao ler a Estacalacao '" + j.getId() + "' do disco rígido!");
			e.printStackTrace();
		}
		return retorno;
	}

	@SuppressWarnings("resource")
	public void add(Escalacao t) {

		try {
			BufferedReader bufferInSequence = new BufferedReader(new FileReader(SEQUENCE));
			BufferedWriter bufferOutEscalacao = new BufferedWriter(new FileWriter(ARQUIVO, true));

			Integer generatedId;
			String linha = bufferInSequence.readLine();
			if (linha != null) {
				generatedId = Integer.parseInt(linha);
				bufferInSequence.close();

				BufferedWriter bufferOutSequence = new BufferedWriter(new FileWriter(SEQUENCE, false));
				bufferOutSequence.write(Integer.toString(generatedId + 1));
				bufferOutSequence.flush();
			} else {
				generatedId = 1;

				BufferedWriter bufferOutSequence = new BufferedWriter(new FileWriter(SEQUENCE, false));
				bufferOutSequence.write(Integer.toString(generatedId + 1));
				bufferOutSequence.flush();
			}

			String separadorDeAtributo = ";";
			bufferOutEscalacao.write(generatedId + separadorDeAtributo);
			bufferOutEscalacao.write(t.getId() + separadorDeAtributo);
			
			for(int i = 0; i<t.getListaJogador().size();i++) {
				Jogador jogador = t.getListaJogador().get(i);
				if (i != t.getListaJogador().size() - 1) {
					bufferOutEscalacao.write(jogador.getId() + "-");
				} else {
					bufferOutEscalacao.write(jogador.getId() + "");
				}
				
			}
			
			bufferOutEscalacao.write(System.getProperty("line.separator"));
			bufferOutEscalacao.flush();

		} catch (Exception e) {
			System.out.println("Erro ao Adicionar o Jogador");
			e.printStackTrace();
		}
	}

	public void update(Escalacao t) throws NumberFormatException, IOException {
			saveToFile(t);
		
	}


//	public void delete(Escalacao t) throws NumberFormatException, IOException {
//		List<Escalacao> escalacao = getAll();
//			saveToFile(t);
//		}
//
//	}

	public List<Escalacao> getAll() throws FileNotFoundException, NumberFormatException, IOException {

		List<Escalacao> escalacao = new ArrayList<Escalacao>();
		Escalacao j = null;
		BufferedReader buffer_entrada = new BufferedReader(new FileReader(ARQUIVO));
		String linha;

		while ((linha = buffer_entrada.readLine()) != null) {
			String[] dados = linha.split(";");

			j = new Escalacao();
			j.setId(Integer.parseInt(dados[0]));
			j.setFinalizado(Boolean.parseBoolean(dados[1]));

			if (dados.length > 1 && !dados[1].equals("")) {
				String[] idJogadores = dados[2].split("-");
				for (String s : idJogadores) {
					Integer idJogador = Integer.parseInt(s);
					Jogador jogador = jogadorDAO.get(idJogador);

					j.getListaJogador().add(jogador);
				}

			}

			buffer_entrada.close();
		}
		return escalacao;

	}

	public void saveToFile(Escalacao t) throws IOException {
		BufferedWriter buffer_saida = new BufferedWriter(new FileWriter(ARQUIVO, false));
		String separador = ";";
		buffer_saida.write(t.getId() + separador);
		
		for(int i = 0; i<t.getListaJogador().size();i++) {
			Jogador jogador = t.getListaJogador().get(i);
			if (i != t.getListaJogador().size() - 1) {
				buffer_saida.write(jogador.getId() + "-");
			} else {
				buffer_saida.write(jogador.getId());
			}
			
		}
		buffer_saida.write(System.getProperty("line.separator"));
		
		buffer_saida.flush();
		buffer_saida.close();
	}
}
