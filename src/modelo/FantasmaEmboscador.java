package modelo;

import constantes.Constantes;

// Pinky:
// 		Forma de Perseguir: Pinky realiza la estrategia de copiar los movimientos de PacMan siempre y cuando
// este esté relativamente cerca a un radio de 5 lugares, se la otra forma Pinky se queda quieto.
// 		Forma de Huir: La manera de Huir es simple, a todo momento invierte los movimientos de PacMan.

public class FantasmaEmboscador extends Fantasma {

	public FantasmaEmboscador(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
	}

	public void huir(PacMan pacman) {
		this.invertirMovimientoDePacMan(this.getLaberinto().getPacMan().getDireccion());
	}

	public void perseguir(PacMan pacman) {
		if(Math.abs(this.getX()-this.getLaberinto().getPacMan().getX()) >= Constantes.RADIO_ACCION_FANTASMA_EMBOSCADOR &&
				(Math.abs(this.getY()-this.getLaberinto().getPacMan().getY()) >= Constantes.RADIO_ACCION_FANTASMA_EMBOSCADOR)){
		}
		else {
			this.copiarMovimientoDePacMan(this.getLaberinto().getPacMan().getDireccion());
		}
	}
	
}
