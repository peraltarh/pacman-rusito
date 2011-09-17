package modelo;

// Clyde:
// 		Forma de Perseguir: La manera de Perseguir de Clyde se realiza a través de un proceso aletorio.
// 		Forma de Huir: la manera es similar a la de Perseguir.

public class FantasmaDeambulador extends Fantasma {

	public FantasmaDeambulador(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		estadoNormal();
	}

	public void huir(PacMan pacman) {
		this.moverseAleatoriamente();
	}

	public void perseguir(PacMan pacman) {
		this.moverseAleatoriamente();
	}
	
}
