package tests;

import constantes.Constantes;
import modelo.Jugador;
import modelo.Laberinto;
import junit.framework.TestCase;

public class TestPuntoPoder extends TestCase {
	
	private Laberinto laberinto;

	@Override
	public void setUp() throws Exception {
		laberinto = new Laberinto(0);
	}
	
	public void testActivar() {
		assertTrue(this.laberinto.getElemento(2, 2).estaActivo());
		assertEquals (Jugador.instance().getScore() , Constantes.JUGADOR_SCORE);
		
		this.laberinto.getElemento(2,2).activar();
		assertFalse(this.laberinto.getElemento(2, 2).estaActivo());
		assertEquals (Jugador.instance().getScore() , 5);
		
		for(int i = 0 ; i <= 3 ; i++) {
			assertTrue(this.laberinto.getFantasma(i).estaHuyendo());
		}
	}
	
	

}
