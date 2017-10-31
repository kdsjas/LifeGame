import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeGameTest {
	private static LifeGame lifegame = new LifeGame();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testNextWorld() {
		lifegame.nextWorld();
	}

}
