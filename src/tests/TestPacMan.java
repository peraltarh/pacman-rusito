package tests;

import constantes.Constantes;
import modelo.Laberinto;
import modelo.PosicionInvalidaException;
import junit.framework.TestCase;

public class TestPacMan extends TestCase {

	private Laberinto laberinto;

	@Override
	public void setUp() throws Exception {
		this.laberinto = new Laberinto(0);
		//le seteo la velocidad en 1 ya que el los objetos dinámicos se mueven con velocidad igual al 
		//número del nivel, en este caso 0.
		this.laberinto.getPacMan().setVelocidad(1);
	}
	
	public void testDireccionIncial() {
		assertEquals(this.laberinto.getPacMan().getDireccion() , Constantes.ABAJO);
	}
	
	public void testEstadoPacmanInicial() {
		assertTrue(this.laberinto.getPacMan().estaEnModoNormal());		
	}
	
	public void testEstadoPoderoso() {
		this.laberinto.getPacMan().cambiarEstadoPoderoso();
		assertFalse(this.laberinto.getPacMan().estaEnModoNormal());		
	}
	
	public void testMoverArriba() {
		assertEquals(this.laberinto.getPacMan().getY() , 15);
		try {
			this.laberinto.getPacMan().setArriba();
		}
		catch (PosicionInvalidaException e) {
		}
		
		this.laberinto.getPacMan().jugarTurno();
		//como estoy en el nivel 0, el PacMan no puede moverse arriba porque hay una Pared
		//y termina moviendose abajo (movimiento incial)
		assertEquals(this.laberinto.getPacMan().getY() , 16);
	}

	public void testMoverAbajo() {
		assertEquals(this.laberinto.getPacMan().getY() , 15);
		
		try {
			this.laberinto.getPacMan().setAbajo();
		}
		catch (PosicionInvalidaException e) {
		}
		
		this.laberinto.getPacMan().jugarTurno();
		assertEquals(this.laberinto.getPacMan().getY() , 16);
	}
	
	public void testMoverDerecha() {
		assertEquals(this.laberinto.getPacMan().getX() , 11);
		
		try {
			this.laberinto.getPacMan().setDerecha();
		}
		catch (PosicionInvalidaException e) {
		}
		
		this.laberinto.getPacMan().jugarTurno();
		assertEquals(this.laberinto.getPacMan().getX() , 12);
	}
	
	public void testMoverIzquierda() {
		assertEquals(this.laberinto.getPacMan().getX() , 11);
		
		try {
			this.laberinto.getPacMan().setIzquierda();
		}
		catch (PosicionInvalidaException e) {
		}
		
		this.laberinto.getPacMan().jugarTurno();
		assertEquals(this.laberinto.getPacMan().getX() , 10);
	}
	
	public void testComer() {
		assertTrue(this.laberinto.getElemento(11, 15).estaActivo());
		
		this.laberinto.getPacMan().setDerecha();
		this.laberinto.getPacMan().jugarTurno();
		assertFalse(this.laberinto.getElemento(12, 15).estaActivo());
	}
	
	public void testRetornarPosInicial() {
		assertEquals(this.laberinto.getPacMan().getX() , 11);
		assertEquals(this.laberinto.getPacMan().getY() , 15);
		
		try {
		this.laberinto.getPacMan().setIzquierda();
		this.laberinto.getPacMan().jugarTurno();
		this.laberinto.getPacMan().setAbajo();
		this.laberinto.getPacMan().jugarTurno();
		}
		catch (PosicionInvalidaException e) {
		}
		assertEquals(this.laberinto.getPacMan().getX() , 10);
		assertEquals(this.laberinto.getPacMan().getY() , 16);
		
		this.laberinto.getPacMan().retornarPosInicial();
		assertEquals(this.laberinto.getPacMan().getX() , 11);
		assertEquals(this.laberinto.getPacMan().getY() , 15);	
	}

}
