package tests;


import modelo.Laberinto;
import junit.framework.TestCase;

public class TestPared extends TestCase {
	
	private Laberinto laberinto;

	@Override
	public void setUp() throws Exception {
		this.laberinto = new Laberinto(0);	
	}
	
	public void testElementoLaberintoSePuedePasar() {
		assertFalse(this.laberinto.getElemento(0, 0).sePuedePasar());
		assertTrue(this.laberinto.getElemento(1, 1).sePuedePasar());
	}

}
