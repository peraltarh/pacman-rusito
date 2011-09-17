package vista;

import constantes.Constantes;
import modelo.Laberinto;
import modelo.ObjetoJuego;
import modelo.PuntoPoder;
import modelo.PuntoComun;
import modelo.Pared;
import titiritero.Dibujable;
import titiritero.Posicionable;
import titiritero.SuperficieDeDibujo;

public class VistaLaberinto implements Dibujable {
	
	Posicionable laberinto;
	Dibujable[][] dibujables;

	public VistaLaberinto(Laberinto unLaberinto){
		dibujables = new Dibujable[23][25];
		for(int i = 0; i < 23; i++){
			for(int j = 0; j < 25; j++){
				ObjetoJuego unaCelda = unLaberinto.getElemento(i, j);
				if( unaCelda instanceof Pared){
					dibujables[i][j] = new VistaPared((Pared) unaCelda);
					dibujables[i][j].setPosicionable(unaCelda);
				}else{
					if( unaCelda instanceof PuntoPoder){
						dibujables[i][j] = new VistaPuntoPoder((PuntoPoder)unaCelda);
						dibujables[i][j].setPosicionable(unaCelda);
					}else{
						if( unaCelda instanceof PuntoComun){
							dibujables[i][j] = new VistaPuntoComun((PuntoComun)unaCelda);
							dibujables[i][j].setPosicionable(unaCelda);
						}
					}
				}
			}
		}
		
		this.setPosicionable(unLaberinto);	
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		for(int i= 0; i< Constantes.LABERINTO_ALTO ; i++){
			for( int j=0; j < Constantes.LABERINTO_ANCHO; j++){
				dibujables[i][j].dibujar(superfice);
			}
		}
	}

	@Override
	public Posicionable getPosicionable() {
		return this.laberinto;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.laberinto = posicionable;
	}

}
