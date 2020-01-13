/**
 * 
 */
package square;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cormacCoolClasses.Player;
import square.Go;
/**
 * @author Brendan
 *
 */
public class TestGo {

	private static final Object PASS_GO_PAY = 2000;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	/**
	 * Testing the displaySquare Method
	 * @throws Exception
	 */
	@Test
	public void testDisplaySquare() throws Exception {
		Go g1 = new Go();
		g1.setName("GO!");
		g1.displaySquare();
	}
	/**
	 * Testing the getPASS_GO_PAY Method
	 * @throws Exception
	 */
	@Test
	public void testGetterPassGo() throws Exception {
		Go g1 = new Go();
		g1.setName("GO!");
		assertEquals(PASS_GO_PAY, Go.getPASS_GO_PAY());
		
	}
	/**
	 * Testing the displaySquare Method
	 * @throws Exception
	 */
	@Test
	public void testPlayerBalanceUpdate() throws Exception {
		Go g1 = new Go();
		Player p1 = new Player("John", 0, 1);
		g1.setName("GO!");
		Go.updateBalance(p1);
		assertEquals(Go.getPASS_GO_PAY(), p1.getCurrentBalance());
		
	}

}
