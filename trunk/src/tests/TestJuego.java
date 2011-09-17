package tests;


import modelo.Juego;
import junit.framework.TestCase;

public class TestJuego extends TestCase{
	
	private Juego juego;

	@Override
	public void setUp() throws Exception {
		this.juego = new Juego();
	}
	
	public void testNivelCompletadoInicialmente() {
		assertFalse(this.juego.nivelCompletado());
	}
	
	public void testJuegoGanadoInicialmente() {
		assertFalse(this.juego.juegoGanado());
	}

}
