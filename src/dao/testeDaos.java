package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Escalacao;
import model.Estatistica;
import model.Jogador;
import model.Partida;
import model.Time;
import dao.PartidaDAO;


public class testeDaos {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//TESTE DE ESTATISTICA
//		Estatistica estatistica = new Estatistica();
//
//		JogadorDAO jog = new JogadorDAO();
//		estatistica.setJogador(jog.get(3));
//		estatistica.setAssistencias(99);
//		estatistica.setGols(1111111);
//		estatistica.setPasseDeBola(888);
//		estatistica.setId(null);
//
		EstatisticaDAO dao = new EstatisticaDAO();
//		dao.add(estatistica);
//
//	
//		try {
//			dao.add(estatistica);
//			//dao.update(estatistica);//IO necessário para esse tipo método.
//			//dao.delete(estatistica);
//			System.out.println(dao.get(11).toJson().toString());
//			List<Estatistica> lista = dao.getAll();
//			for(Estatistica e : lista) {
//				System.out.println(e.toJson().toString());
//			}
//		} catch (NumberFormatException | IOException e ) {
//			e.printStackTrace();
//		}
//		
//		
		//TESTE DE PARTIDA
		
		//no GETALL não está puxando pois está com erro no Json
		//no DELETE está deixando o ID.
		
		
		
		Partida partida = new Partida();
		PartidaDAO daopartida = new PartidaDAO();
//		partida.setId(50);
		
//		partida.inserirEstatistica(dao.get(29));
//		partida.inserirEstatistica(dao.get(30));
//		partida.inserirEstatistica(dao.get(31));
//		
//		daopartida.add(partida);
		
		
//		try {
//			for(Partida p : daopartida.getAll()) {
//				System.out.println(p.toJson().toString());
//			}
//			
//			System.out.println(daopartida.getAll().toString());
//			daopartida.delete(partida);
			
//			partida.inserirEstatistica(dao.get(29));
//			partida.inserirEstatistica(dao.get(30));
//			partida.inserirEstatistica(dao.get(31));
//			daopartida.update(partida);
		
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		
	
		
//	}
		
		
//		TESTE ESCALAÇÃO
		
		EscalacaoDAO daoEscalacao = new EscalacaoDAO();
		Escalacao escalacao = new Escalacao();
		JogadorDAO daoJogador = new JogadorDAO();
		CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
		
//		escalacao.incluirJogador(daoJogador.get(19));
//		escalacao.incluirJogador(daoJogador.get(27));
//		escalacao.incluirJogador(daoJogador.get(28));
//
//		escalacao.setCampeonato(campeonatoDAO.get(1));
//		
//		daoEscalacao.add(escalacao);
		
		
		   try {
//			for(Escalacao esc : daoEscalacao.getAll()) {
//				   System.out.println(esc.toJson().toString());
//			   }
//			   System.out.println(daoEscalacao.get(0).toJson().toString());
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
