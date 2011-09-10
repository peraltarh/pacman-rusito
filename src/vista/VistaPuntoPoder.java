package vista;

import constantes.Constantes;
import modelo.PuntoPoder;
import titiritero.SuperficieDeDibujo;
import titiritero.vista.Imagen;

public class VistaPuntoPoder extends Imagen{

	PuntoPoder puntoPoder;
	Imagen imagen;

	public VistaPuntoPoder(PuntoPoder puntoPoder){
		super();
		this.puntoPoder = puntoPoder;
		this.setPosicionable(this.puntoPoder);
		this.setNombreArchivoImagen(Constantes.PUNTO_PODER);	
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if (this.puntoPoder.estaActivo()){
			super.dibujar(superfice);	
		}
	}
	
}
