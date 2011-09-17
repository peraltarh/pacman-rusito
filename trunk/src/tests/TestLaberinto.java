package tests;

import constantes.Constantes;
import junit.framework.TestCase;
import modelo.*;

public class TestLaberinto extends TestCase {

	// El Laberinto se carga desde un archivo.csv, a partir del archivo.csv de prueba
	// se verifica la carga correcta del laberinto. 	

	private Laberinto laberinto;
	
	@Override
	public void setUp() {
		// Se carga el laberinto 0 (que siempre sera de prueba), ya que el mismo nunca 
		// puede ser llamado desde el Juego.
		laberinto = new Laberinto(0);
	}
	
	public void testCargaCorrecta() {

		// Los ObjetosJuego en el laberinto de prueba se encuentran ordenados de la siguiente manera:
		// PacMan, FantasmaCazador, FantasmaDeambulador, Fantasma Perseguidor, Fantasma Emboscador, 
		// Punto Común, Punto Poder, Fruta y luego todo el laberinto estará lleno de Objetos Pared.
		
		assertTrue(laberinto.getElemento(0,0) instanceof Pared);
		assertTrue(laberinto.getPacMan() instanceof PacMan);
		for(int i = 0 ; i <= 3 ; i++) {
			assertTrue(laberinto.getFantasma(i) instanceof Fantasma);
		}
		assertTrue(laberinto.getElemento(1,1) instanceof PuntoComun);
		assertTrue(laberinto.getElemento(2,2) instanceof PuntoPoder);
		assertTrue(laberinto.getFruta() instanceof Fruta);
	}
	
	public void testDimensionesLaberinto() {
		assertEquals(this.laberinto.getAlto() , Constantes.LABERINTO_ALTO);
		assertEquals(this.laberinto.getAncho() , Constantes.LABERINTO_ANCHO);
	}
	
	public void testNumeroNivelLaberinto() {
		assertEquals(this.laberinto.getNroNivel() , 0);
	}
	
	public void testContadorPuntosEnElLaberinto() {
		assertEquals(this.laberinto.getContadorPuntosEnElLaberito() , 443);
	}

}
