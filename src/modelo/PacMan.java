package modelo;

import constantes.Constantes;
import titiritero.ObjetoVivo;
import titiritero.Posicionable;

public class PacMan extends ObjetoDinamico implements Posicionable, ObjetoVivo {
	
	public PacMan(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		this.setDireccion(Constantes.ABAJO);
		cambiarEstadoNormal();
	}
	
	// Para el cambio de estado se puede hacer un getCantidadTurnosJugados() pedido por PuntoPoder
	// Cuando PacMan jugo una cantidad de turnos X lo vuelve a cambiar de Estado.
	
	@Override
	protected void comer(){
		try {
			this.getLaberinto().getElemento(this.getPosX(), this.getPosY()).activar();
		}
		catch (PosicionFueraDeRangoException e) {
		}
	}
	
	public void cambiarEstadoPoderoso(){
		this.setVelocidad(this.getVelocidad() + 1);
		this.setEstadoNormal(false);
	}
	
	public void cambiarEstadoNormal(){
		this.setVelocidad(1);
		this.setEstadoNormal(true);
	}
	
	public boolean estaEnModoNormal(){
		return this.isEstadoNormal();
	}

	@Override
	public void jugarTurno() {
		for(int i = 1 ; i <= this.getVelocidad() ; i++) {
			this.mover();	
		}
	}

	@Override
	protected void morir() {
		this.cambiarEstadoNormal();
		this.retornarPosInicial();
	}
	
}