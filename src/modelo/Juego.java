package modelo;

import constantes.Constantes;

public class Juego {
		private Laberinto laberinto;
	
	public Juego(){
		this.cargarNuevoNivel();
	}
	
	public Laberinto getLaberinto() {
		return laberinto;
	}

	public boolean nivelCompletado() {
		if(this.laberinto.getContadorPuntosEnElLaberito() == Constantes.PUNTOS_FALTANTES_APARICION_FRUTA) {
			this.laberinto.getFruta().aparecer();
		}
		if(this.laberinto.getContadorPuntosEnElLaberito() == 0) {
			this.cargarNuevoNivel();
			return (true);
		}
		return false;
	}

	public void cargarNuevoNivel() {
		Jugador.instance().aumentarNivel();
		this.laberinto = new Laberinto(Jugador.instance().getNivel());
		
	}

	public boolean juegoGanado() {
		if (Jugador.instance().getNivel() == Constantes.CANTIDAD_DE_NIVELES) {
			return true;
		}
		return false;
	}

}
