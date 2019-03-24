package susalud.backend.dominio.sistema.exception;

public class SistemaException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message;

	public SistemaException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
