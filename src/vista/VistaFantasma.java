package vista;

import constantes.Constantes;
import modelo.Fantasma;
import titiritero.SuperficieDeDibujo;
import titiritero.vista.Imagen;

public class VistaFantasma extends Imagen {
	Fantasma fantasma;
	String imagen;
	
	public VistaFantasma(Fantasma fantasma, String imagen){
		super();
		this.setNombreArchivoImagen(imagen);
		this.setPosicionable(fantasma);
		this.fantasma = fantasma;
		this.imagen = imagen;
		
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.fantasma.estaHuyendo()){
			this.setNombreArchivoImagen(Constantes.FANTASMA_ASUSTADO);			
		}else
			this.setNombreArchivoImagen(this.imagen);
		super.dibujar(superfice);
		
	}
	

}
