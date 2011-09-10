package tests;

import constantes.Constantes;
import modelo.Fruta;
import modelo.Jugador;
import modelo.Laberinto;
import junit.framework.TestCase;

public class TestFruta extends TestCase {
	
	private Laberinto laberinto;
	@SuppressWarnings("unused")
	private Fruta fruta;

	@Override
	public void setUp() throws Exception {
		this.laberinto = new Laberinto(0);	
	}
	
	public void testEstadoInicial() {
		assertFalse (this.laberinto.getFruta().estaActivo());
	}
	
	public void testPosicionInicial() {
		assertEquals (this.laberinto.getFruta().getX() , 11);
		assertEquals (this.laberinto.getFruta().getY() , 15);
	}
	
	public void testAparecerFruta() {
		this.laberinto.getFruta().aparecer();
		assertTrue(this.laberinto.getFruta().estaActivo());
	}
	
	//al activar la Fruta esta aumenta el score del Jugador en 50 y le suma un vida.
	public void testActivar() {
		assertFalse(this.laberinto.getFruta().estaActivo());
		
		this.laberinto.getFruta().aparecer();
		assertTrue(this.laberinto.getFruta().estaActivo());
		
		this.laberinto.getFruta().activar();
		assertFalse(this.laberinto.getFruta().estaActivo());
		assertEquals(Jugador.instance().getScore() , Constantes.VALOR_FRUTA);
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS+1);
		
	}

}
