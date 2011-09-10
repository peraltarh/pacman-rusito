package modelo;

import constantes.Constantes;

public class PuntoPoder extends Punto {
	
	public PuntoPoder(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		setValor(Constantes.VALOR_PUNTO_PODER);
	}
	
	@Override
	protected void accionEspecial(){
		for(int i = 0 ; i <= 3 ; i++) {
			this.getLaberinto().getFantasma(i).estadoDebil(Constantes.VALOR_FANTASMA_ESTADO_DEBIL);
		}
	}
	
}
