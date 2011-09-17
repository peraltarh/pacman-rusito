package modelo;

import constantes.Constantes;

// Inky:
//		Forma de Perseguir: Inky persigue al PacMan copiando sus movimientos si este se encuentra a un radio
// mayor a 3 lugares, cuando PacMan está cerca, cambia su estrategia y empieza a invertir los movimientos.
//		Forma de Huir: Inky huye copiando los movimientos del PacMan si este está a un radio menor de
// 3 lugares, si está lejos, se queda quieto.

public class FantasmaPerseguidor extends Fantasma {

	public FantasmaPerseguidor(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
	}

	@Override
	public void huir(PacMan pacman) {
		if(Math.abs(this.getX()-this.getLaberinto().getPacMan().getX()) <= Constantes.RADIO_ACCION_FANTASMA_PERSEGUIDOR &&
				(Math.abs(this.getY()-this.getLaberinto().getPacMan().getY()) <= Constantes.RADIO_ACCION_FANTASMA_PERSEGUIDOR)){
			this.copiarMovimientoDePacMan(this.getLaberinto().getPacMan().getDireccion());
		}
	}

	public void perseguir(PacMan pacman) {
		if(Math.abs(this.getX()-this.getLaberinto().getPacMan().getX()) >= Constantes.RADIO_ACCION_FANTASMA_PERSEGUIDOR
			&& (Math.abs(this.getY()-this.getLaberinto().getPacMan().getY()) >= Constantes.RADIO_ACCION_FANTASMA_PERSEGUIDOR)){
			this.copiarMovimientoDePacMan(this.getLaberinto().getPacMan().getDireccion());
		}
		else {
			this.invertirMovimientoDePacMan(this.getLaberinto().getPacMan().getDireccion());
		}		
	}
	
}
