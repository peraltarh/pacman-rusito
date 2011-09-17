package vista;

import constantes.Constantes;
import modelo.Fruta;
import titiritero.SuperficieDeDibujo;
import titiritero.vista.Imagen;

public class VistaFruta extends Imagen {
	
	Fruta fruta;
	public VistaFruta(Fruta fruta){
		this.fruta = fruta;
		this.setPosicionable(fruta);
		this.setNombreArchivoImagen(Constantes.FRUTA);
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficie){
		if(this.fruta.estaVisible())
			super.dibujar(superficie);
	}

}
