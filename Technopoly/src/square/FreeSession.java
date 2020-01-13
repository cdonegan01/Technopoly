/**
 * 
 */
package square;

/**
 * @author Brendan
 *
 */
public class FreeSession extends Square {
	
	// Instance Vars
	private String message = "You Have Been Granted A Free PC Session!";
	
	// Constructors
	/**
	 * Default Constructors
	 */
	public FreeSession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @throws Exception 
	 */
	public FreeSession(SquareNames name, String message) throws Exception {
		super(name);
		this.message = message;
		// TODO Auto-generated constructor stub
	}
	// Methods

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see square.Square#displaySquare()
	 */
	@Override
	public void displaySquare() {
		// TODO Auto-generated method stub
		super.displaySquare();
		System.out.println(message);
	}
	

}
