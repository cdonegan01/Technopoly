package square;

/**
 * @author Brendan
 *
 */
public abstract class Square {

	// Instance Vars
	protected SquareNames name;
	protected static int MIN_NO_LETTERS = 3;
	
	// Constructors
	/**
	 * Default Constructor
	 */
	public Square() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param name
	 * @throws Exception 
	 */
	public Square(SquareNames name) throws Exception {
		super();
		this.setName(name);
	}

	// Methods

	/**
	 * @return the name
	 */
	public SquareNames getName() {
		return name;
	}

	/**
	 * @param square1 the name to set
	 * @throws Exception 
	 */
	public void setName(SquareNames square1) throws Exception {
		this.name = square1;
	}
	/**
	 * Method to display the name of the square
	 */
	public void displaySquare() {
		System.out.println("Name : \t\t\t\t\t"+getName());
	}
	

}

