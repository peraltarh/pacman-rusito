package modelo;

import constantes.Constantes;

public class PuntoComun extends Punto {
	
	public PuntoComun(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		setValor(Constantes.VALOR_PUNTO_COMUN);
	}

	@Override
	protected void accionEspecial() {
	}
	
}
