package modelo;

import constantes.Constantes;

public class Fruta extends ObjetoDinamico {
	
	private int valor = Constantes.VALOR_FRUTA; // TODO: Reasignar valor por defecto en constructor sino...
	
	public Fruta(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		this.setActivo(false);
		this.setDireccion(Constantes.ABAJO);
	}
	
	public void aparecer(){
		this.setActivo(true);
	}

	protected void accionEspecial() {
		Jugador.instance().incrementarVidas();
		this.getLaberinto().getPacMan().cambiarEstadoPoderoso();
	}
	
	@Override
	public void activar() {
		this.setActivo(false);
		Jugador.instance().aumentarScore(this.valor);
		this.accionEspecial();
	}

	@Override
	protected void comer() {
		if(this.estaEnLaMismaPosicionQuePacMan() && this.isActivo() == true) {
			this.activar();
		}
	}

	@Override
	public void jugarTurno() {
		this.mover();
		this.moverseAleatoriamente();
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
	public boolean estaVisible() {
		return this.isActivo();
	}
	
	protected boolean estaEnLaMismaPosicionQuePacMan() {
		if(this.getPosX() == this.getLaberinto().getPacMan().getX() && 
			this.getPosY() == this.getLaberinto().getPacMan().getY()) {
			return (true);
		}
		else {
			return (false);
		}
	}

	@Override
	protected void morir() {		
	}
	
}