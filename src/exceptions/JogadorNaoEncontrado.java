package exceptions;

@SuppressWarnings("serial")
public class JogadorNaoEncontrado extends Exception {
	public JogadorNaoEncontrado() {
		super("Jogador n�o encontrado");
	}
}
