package tests;

import constantes.Constantes;
import modelo.Laberinto;
import junit.framework.TestCase;

public class TestFantasma extends TestCase {
	
	private Laberinto laberinto;

	@Override
	public void setUp() throws Exception {
		this.laberinto = new Laberinto(0);	
		for(int i = 0 ; i <= 3 ; i++) {
			this.laberinto.getFantasma(i).setVelocidad(1);
		}
	}
	
	public void testDireccionInicialFantasma() {
		for(int i = 0 ; i <= 3 ; i++) {
			assertEquals(this.laberinto.getFantasma(i).getDireccion() , Constantes.ABAJO);
		}
	}
	
	public void testVelocidadInicialFantasma() {
		for(int i = 0 ; i <= 3 ; i++) {
			assertEquals(this.laberinto.getFantasma(i).getVelocidad() , 1);
		}
	}
	
	public void testEstaEnLaMismaPosicionQuePacman() {
		for(int i = 0 ; i <= 3 ; i++) {
			this.laberinto.getFantasma(i).setVelocidad(2);
		}
		for(int i = 0 ; i <= 3 ; i++) {
			assertEquals(this.laberinto.getFantasma(i).getVelocidad() , 2);
		}
	}
	
	public void testEstadoNormalInicialFantasma() {
		for(int i = 0 ; i <= 3 ; i++) {
			assertFalse(this.laberinto.getFantasma(i).estaHuyendo());
		}
	}
	
	//le asigno a los 4 Fantasmas que cambien su estado a Débil y le indico en un tiempo de 0
	//por lo tanto el cambio a estadoNormal es instantáneo.
	public void testCambiarEstadoDebilFantasma() {
		for(int i = 0 ; i <= 3 ; i++) {
			this.laberinto.getFantasma(i).estadoDebil(0);
		}
		for(int i = 0 ; i <= 3 ; i++) {
			assertTrue(this.laberinto.getFantasma(i).estaHuyendo());
		}
		
		for(int i = 0 ; i <= 3 ; i++) {
			this.laberinto.getFantasma(i).jugarTurno();
		}
		for(int i = 0 ; i <= 3 ; i++) {
			assertFalse(this.laberinto.getFantasma(i).estaHuyendo());
		}
	}

}
