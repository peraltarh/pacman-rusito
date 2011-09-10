package vista;

import constantes.Constantes;
import modelo.Pared;
import titiritero.vista.Imagen;

public class VistaPared extends Imagen{
	
	public VistaPared(Pared unaPared){
		super();
		this.setNombreArchivoImagen(Constantes.PARED);
		this.setPosicionable(unaPared);
	}

}
