package tests;

import constantes.Constantes;
import junit.framework.TestCase;
import modelo.Jugador;

public class TestJugador extends TestCase {

	@Override
	public void setUp() throws Exception {
	}
	
	public void testCantidadDeVidasIniciales() {
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS);
	}
	
	//como la clase Jugador es un Singleton mantiene los atributos seteados.
	public void testIncrementarVidas() {
		Jugador.instance().incrementarVidas();
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS+1);
		
		Jugador.instance().incrementarVidas();
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS+2);
	}
	
	public void testDecrementarVidas() {
		Jugador.instance().decrementarVidas();
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS+1);
		
		Jugador.instance().decrementarVidas();
		assertEquals(Jugador.instance().getCantidadVidas() , Constantes.JUGADOR_VIDAS);
	}
	
	public void testValorScoreInicial() {
		assertEquals(Jugador.instance().getScore() , 0);
	}
	
	public void testNivelInicial() {
		assertEquals(Jugador.instance().getNivel() , Constantes.JUGADOR_NIVEL);
	}
	
	public void testPasarNivel() {
		Jugador.instance().aumentarNivel();
		assertEquals(Jugador.instance().getNivel() , Constantes.JUGADOR_NIVEL+1);
	}
	
	public void testAumentarScore() {
		Jugador.instance().aumentarScore(25);
		assertEquals(Jugador.instance().getScore() , 25);
	}
	
	public void testNombreInicial() {
		assertEquals (Jugador.instance().getNombre() , "Player");
	}
	
	public void testCambiarNombre() {
		Jugador.instance().cambiarNombre("Pepe");
		assertEquals (Jugador.instance().getNombre() , "Pepe");
	}	

}
