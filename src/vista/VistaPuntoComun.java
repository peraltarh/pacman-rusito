package vista;

import constantes.Constantes;
import modelo.PuntoComun;
import titiritero.SuperficieDeDibujo;
import titiritero.vista.Imagen;

public class VistaPuntoComun extends Imagen{

	Imagen imagen;
	PuntoComun punto;

	public VistaPuntoComun(PuntoComun unPunto){
		super();
		this.punto = unPunto;
		this.setPosicionable(unPunto);
		this.setNombreArchivoImagen(Constantes.PUNTO_COMUN);	
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if (this.punto.estaActivo()){
			super.dibujar(superfice);			
		}
	}

}
