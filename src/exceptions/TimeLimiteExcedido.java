package exceptions;

@SuppressWarnings("serial")
public class TimeLimiteExcedido extends Exception {
	private final static Integer LIMITE_TIME = 33;
	
	public TimeLimiteExcedido() {
		super("Limite de jogadores excedido. O time pode ter no m�ximo " + LIMITE_TIME + " jogadores.");
	}
}
