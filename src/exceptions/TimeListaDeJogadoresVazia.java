package exceptions;

@SuppressWarnings("serial")
public class TimeListaDeJogadoresVazia extends Exception {
	public TimeListaDeJogadoresVazia() {
		super("A��o inv�lida. A lista de jogadores est� vazia.");
	}
}
