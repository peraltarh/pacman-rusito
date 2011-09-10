package vista;

import constantes.Constantes;
import modelo.PacMan;
import titiritero.vista.Imagen;
import titiritero.SuperficieDeDibujo;

public class VistaPacMan extends Imagen{
	PacMan pacMan;

	public VistaPacMan(PacMan pacMan){
		super();
		this.pacMan = pacMan;
		this.setPosicionable(pacMan);
		this.setNombreArchivoImagen(this.elegirImagen());
	}

	private String elegirImagen(){
		String miImagen = null;
		if(this.pacMan.estaEnModoNormal()){
			switch (this.pacMan.getDireccion()){
			
				case Constantes.ARRIBA: miImagen = Constantes.PACMAN_ARRIBA; break;
				
				case Constantes.ABAJO: miImagen = Constantes.PACMAN_ABAJO; break;
				
				case Constantes.IZQUIERDA: miImagen = Constantes.PACMAN_IZQUIERDA; break;
				
				case Constantes.DERECHA: miImagen = Constantes.PACMAN_DERECHA; break;
			}
		}else{
			switch (this.pacMan.getDireccion()){
			
				case Constantes.ARRIBA: miImagen = Constantes.SUPER_PACMAN_ARRIBA; break;
				
				case Constantes.ABAJO: miImagen = Constantes.SUPER_PACMAN_ABAJO; break;
				
				case Constantes.IZQUIERDA: miImagen = Constantes.SUPER_PACMAN_IZQUIERDA; break;
				
				case Constantes.DERECHA: miImagen = Constantes.SUPER_PACMAN_DERECHA; break;
			}
		}
		return miImagen;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
			this.setNombreArchivoImagen(this.elegirImagen());
			super.dibujar(superfice);
	}
	
}
