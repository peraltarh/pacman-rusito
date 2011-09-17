package modelo;

import constantes.Constantes;
import titiritero.ObjetoVivo;


public abstract class ObjetoDinamico extends ObjetoJuego implements ObjetoVivo{
	
	private int velocidad;
	private char direccion;
	private boolean estadoNormal;
	private int posInicialX;
	private int posInicialY;
	
	public ObjetoDinamico(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		setPosInicialX();
		setPosInicialY();
		this.setEstadoNormal(true);
	}

	@Override
	public void vivir(){
		this.jugarTurno();	
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void setArriba(){
		if(!getLaberinto().getElemento(getPosX(), getPosY()-1).sePuedePasar()) {
			throw new PosicionInvalidaException();
		}
		else {
		this.setDireccion(Constantes.ARRIBA);
		}
	}
	
	public void setAbajo(){
		if(!getLaberinto().getElemento(getPosX(), getPosY()+1).sePuedePasar()) {
			throw new PosicionInvalidaException();
		}
		else {
		this.setDireccion(Constantes.ABAJO);
		}
	}
	
	public void setIzquierda(){
		if(!getLaberinto().getElemento(getPosX()-1, getPosY()).sePuedePasar()) {
			throw new PosicionInvalidaException();
		}
		else {
		this.setDireccion(Constantes.IZQUIERDA);
		}
	}
	
	public void setDerecha(){
		if(!getLaberinto().getElemento(getPosX()+1, getPosY()).sePuedePasar()) {
			throw new PosicionInvalidaException();
		}
		else {
		this.setDireccion(Constantes.DERECHA);
		}
	}
	
	public void mover(){
		
		int nuevaPosX = this.getPosX();
		int nuevaPosY = this.getPosY();
		this.comer();
		
		switch(getDireccion()){
	
			case Constantes.ARRIBA :{
						nuevaPosX = this.getPosX();
						nuevaPosY = this.getPosY() - 1;
					}; break;
			case Constantes.ABAJO :{
						nuevaPosX = this.getPosX();
						nuevaPosY = this.getPosY() + 1;
					}; break;
			case Constantes.IZQUIERDA :{
						nuevaPosX = this.getPosX() - 1;
						nuevaPosY = this.getPosY();
					}; break;
			case Constantes.DERECHA :{
						nuevaPosX = this.getPosX() + 1;
						nuevaPosY = this.getPosY();
					}; break;
		}

		//TODO reemplazar por un try catch movimientoinvalidoexception() para mejorar implementaciones
		//del pacman y fantasmas.
		// Reviso si hay algún tipo de Pared que no permita que cambie de posicion.
		ObjetoJuego objetoJuego = null;
		try {
			objetoJuego = this.getLaberinto().getElemento(nuevaPosX, nuevaPosY);
		}
		catch (PosicionFueraDeRangoException e) {
		}
		if (!objetoJuego.sePuedePasar()){
			//Pruebo moverlo en la direccion en la que se desplazaba.	
		} else {

			this.setPosX(nuevaPosX);
			this.setPosY(nuevaPosY);
			this.comer();
		}		
	}
	
	protected void moverseAleatoriamente() {
		int dir = (int) (Math.random () * (5 - 1) + 1);
		try {
			switch(dir){
				case 1: {
					this.setArriba();
				}break;
				case 2: {
					this.setAbajo();
					}break;
				case 3: {
					this.setIzquierda();						
				}break;
				case 4: {
					this.setDerecha();					
				}break;
			}
		}
		catch (PosicionInvalidaException e) {
			this.moverseAleatoriamente();
		}
	}
	
	protected abstract void morir();
	
	private void setPosInicialX(){
		this.posInicialX = getPosX();
	}
	
	private void setPosInicialY(){
		this.posInicialY = getPosY();
	}
	
	public void retornarPosInicial(){
		this.setPosX(this.getPosInicialX());
		this.setPosY(this.getPosInicialY());
	}		
	
	public char getDireccion() {
		return (this.direccion);
	}
	
	protected abstract void comer();
	
	public abstract void jugarTurno();

	public int getVelocidad() {
		return (this.velocidad);
	}

	protected void setDireccion(char direccion) {
		this.direccion = direccion;
	}

	protected void setEstadoNormal(boolean estadoNormal) {
		this.estadoNormal = estadoNormal;
	}

	protected boolean isEstadoNormal() {
		return estadoNormal;
	}

	protected void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	protected int getPosInicialX() {
		return posInicialX;
	}

	protected void setPosInicialY(int posInicialY) {
		this.posInicialY = posInicialY;
	}

	protected int getPosInicialY() {
		return posInicialY;
	}
	
}
