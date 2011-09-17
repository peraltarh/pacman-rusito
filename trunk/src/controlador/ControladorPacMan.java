package controlador;

import java.util.ArrayList;

import constantes.Constantes;
import modelo.Juego;
import modelo.Jugador;
import modelo.Laberinto;
import modelo.PosicionInvalidaException;
import titiritero.ControladorJuego;
import titiritero.Dibujable;
import titiritero.ObjetoVivo;
import titiritero.SuperficieDeDibujo;
import vista.VistaFantasma;
import vista.VistaFruta;
import vista.VistaLaberinto;
import vista.VistaPacMan;
	
	public class ControladorPacMan implements ObjetoVivo{

		private ControladorJuego controlador = null;
		private Juego juego;
		private Laberinto laberinto;
		private ArrayList<ObjetoVivo> objetosVivos;
		private ArrayList<Dibujable> dibujables;
		private SuperficieDeDibujo superficieDeDibujo;
		
		public ControladorPacMan(SuperficieDeDibujo superficieDeDibujo){
			this.superficieDeDibujo = superficieDeDibujo;
			nuevoControladorPacMan();
		}

		private void nuevoControladorPacMan() {
			this.juego = new Juego();
			this.dibujables = new ArrayList<Dibujable>();
			this.objetosVivos = new ArrayList<ObjetoVivo>();
			this.laberinto = this.juego.getLaberinto();
			controlador = new ControladorJuego();
			
			this.dibujables.addAll(getDibujables());
			for(int i = 1; i <= this.dibujables.size(); i++){
				controlador.agregarDibujable(dibujables.get(i-1));
			}
			ObjetoVivo pacMan = laberinto.getPacMan();
			
			this.objetosVivos.add(pacMan);
			
			for (int i = 1; i <= Constantes.CANTIDAD_DE_FANTASMAS; i++){
				this.objetosVivos.add(laberinto.getFantasma(i-1));
			}
			this.objetosVivos.add(laberinto.getFruta());
			
			for(int i = 1; i <= this.objetosVivos.size(); i++){			
				controlador.agregarObjetoVivo(this.objetosVivos.get(i-1));
			}
			controlador.setIntervaloSimulacion(Constantes.INTERVALO_SIMULACION);
			controlador.setSuperficieDeDibujo(this.superficieDeDibujo);
			controlador.agregarObjetoVivo(this);
		}
		
		public void comenzar(){
			controlador.comenzarJuegoAsyn();
		}
		
		public void detener() {
			controlador.detenerJuego();
		}

		@Override
		public void vivir() {
			for (ObservadorDeEstadisticas observador : this.observadores) 
				observador.seActualizaronLasEstadisticas(Jugador.instance().getNivel(),Jugador.instance().getScore(),Jugador.instance().getCantidadVidas());
		
			if(this.juego.nivelCompletado()){
				detener();
				nuevoControladorPacMan();
				comenzar();
			}
		}

		public void agregarObservadorDeEstadisticas(ObservadorDeEstadisticas observador) {
			this.observadores.add(observador);
		}
		
		private ArrayList<ObservadorDeEstadisticas> observadores = new ArrayList<ObservadorDeEstadisticas>();
	
	private ArrayList<Dibujable> getDibujables() {
		ArrayList<Dibujable> listaDibujables = new ArrayList<Dibujable>();
		listaDibujables.add(new VistaLaberinto(this.laberinto));
		listaDibujables.add(new VistaFruta(this.laberinto.getFruta()));
		listaDibujables.add(new VistaFantasma(this.laberinto.getFantasma(0),Constantes.FANTASMA_DEAMBULADOR));
		listaDibujables.add(new VistaFantasma(this.laberinto.getFantasma(1),Constantes.FANTASMA_CAZADOR));
		listaDibujables.add(new VistaFantasma(this.laberinto.getFantasma(2),Constantes.FANTASMA_EMBOSCADOR));
		listaDibujables.add(new VistaFantasma(this.laberinto.getFantasma(3),Constantes.FANTASMA_PERSEGUIDOR));	
		listaDibujables.add(new VistaPacMan(this.laberinto.getPacMan()));
		
		return listaDibujables;
	}
	
	public Juego getJuego(){
		return this.juego;
	}

	public void moverPacMan(char c) {
		try {		
			switch(c) {
			
				case Constantes.ARRIBA: this.laberinto.getPacMan().setArriba(); break;
				
				case Constantes.ABAJO: this.laberinto.getPacMan().setAbajo(); break;
				
				case Constantes.IZQUIERDA: this.laberinto.getPacMan().setIzquierda(); break;
				
				case Constantes.DERECHA: this.laberinto.getPacMan().setDerecha(); break;
			}
		}
		catch (PosicionInvalidaException e) {
		}		
	}
}
