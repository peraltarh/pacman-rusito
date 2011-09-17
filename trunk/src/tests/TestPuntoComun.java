package tests;

import constantes.Constantes;
import modelo.Jugador;
import modelo.Laberinto;
import junit.framework.TestCase;

public class TestPuntoComun extends TestCase {
	
	private Laberinto laberinto;

	@Override
	public void setUp() throws Exception {
		laberinto = new Laberinto(0);
	}
	
	public void testActivar() {
		assertTrue(this.laberinto.getElemento(1, 1).estaActivo());
		assertEquals (Jugador.instance().getScore() , Constantes.JUGADOR_SCORE);
		
		this.laberinto.getElemento(1, 1).activar();
		assertFalse(this.laberinto.getElemento(1, 1).estaActivo());
		assertEquals (Jugador.instance().getScore() , Constantes.VALOR_PUNTO_COMUN);
	}

}
