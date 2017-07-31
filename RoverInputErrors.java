package MarsRovers;

public class RoverInputErrors extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public RoverInputErrors(String msg){
		super();
		this.message = msg;
	}
}
