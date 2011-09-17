package modelo;
import modelo.Juego;

public class Main {

	private static Juego juego;
	public static void main(String[] args) {
		juego = new Juego();
		juego.getLaberinto();
		
//		for (int i = 0; i<=23; i++){
//			for (int j = 0; j<=23; j++){
//				System.out.println(laberinto.getPosicion(i, j).toString());
//			}
//		}
	}

}
