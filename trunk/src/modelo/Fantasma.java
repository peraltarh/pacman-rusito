package modelo;

import constantes.Constantes;

public abstract class Fantasma extends ObjetoDinamico implements Estrategia {
	
		private int tiempoHuida = 0;

		public Fantasma(Laberinto laberinto, int posX, int posY) {
			super(laberinto, posX, posY);
			this.setDireccion(Constantes.ABAJO);
			this.estadoNormal();
		}
		
		public void estadoDebil(int tiempo){
			this.setEstadoNormal(false);
			this.tiempoHuida = tiempo;
		}
		
		protected void aumentarVelocidad(int incremento){
			this.setEstadoNormal(true);
			this.setVelocidad(this.getVelocidad() + incremento);
		}
		
		protected void reducirVelocidad(int decremento){
			this.setVelocidad(this.getVelocidad() - decremento);
				if(this.getVelocidad() < 0) {
					this.setVelocidad(0);
				}
		}
		
		@Override
		protected void comer(){
			if(estaEnLaMismaPosicionQuePacMan()){
				if (this.isEstadoNormal()==true){
					matar();
				}
				else{
					morir();
				}
			}
		}
		
		private void matar(){
			Jugador.instance().decrementarVidas();
			Jugador.instance().decrementarScore(100);
			this.getLaberinto().getPacMan().morir();
			regresarFantasmasACasa();
		}
		
		@Override
		protected void morir(){
			retornarPosInicial();
			Jugador.instance().aumentarScore(100);
		}
		
		private void regresarFantasmasACasa(){
			for(int i = 0 ; i <= 3 ; i++) {
				this.getLaberinto().getFantasma(i).retornarPosInicial();
			}
		}

		protected boolean estaEnLaMismaPosicionQuePacMan() {
			if(this.getPosX() == this.getLaberinto().getPacMan().getX() && 
				this.getPosY() == this.getLaberinto().getPacMan().getY()) {
				return (true);
			}			
			return (false);
		}
		
		protected void decidirEstrategia() {
			if(this.isEstadoNormal()==true) {
				this.perseguir(this.getLaberinto().getPacMan());
			}
			else {
				if (this.tiempoHuida > 0){
					this.huir(this.getLaberinto().getPacMan());
					this.tiempoHuida -= this.getVelocidad();
				} else {
					this.estadoNormal();
				}
			}
		}
		
		public boolean estaHuyendo() {
			if (this.isEstadoNormal() == true){
				return false;
			} 
			return true;
		}
		
		protected void copiarMovimientoDePacMan(char dir) {
			try {
				switch (dir) {
					case Constantes.ARRIBA: this.setArriba(); break;
					case Constantes.ABAJO: this.setAbajo(); break;
					case Constantes.DERECHA: this.setDerecha(); break;
					case Constantes.IZQUIERDA: this.setIzquierda(); break;
				}
			}
			catch (PosicionInvalidaException e) {
			}
		}
		
		protected void invertirMovimientoDePacMan(char dir) {
			try {
				switch (dir) {
					case Constantes.ARRIBA: this.setAbajo(); break;
					case Constantes.ABAJO: this.setArriba(); break;
					case Constantes.DERECHA: this.setIzquierda(); break;
					case Constantes.IZQUIERDA: this.setDerecha(); break;
				}
			}
			catch (PosicionInvalidaException e) {
			}
		}
		
		protected void estadoNormal() {
			this.setVelocidad(this.getLaberinto().getNroNivel());
			if(this.getVelocidad() >= 3) {
				this.setVelocidad(3);
			}
			this.setEstadoNormal(true);
		}
		
		@Override
		public void jugarTurno() {
			this.decidirEstrategia();
			for(int i = 1 ; i <= this.getVelocidad() ; i++) {
				this.mover();	
			}
		}
		
}
