package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import constantes.Constantes;
import titiritero.Posicionable;

public class Laberinto implements Posicionable{
	
		private ObjetoJuego[][] miLaberinto;
		private PacMan pacMan;
		private int nroNivel;
		private ArrayList<Fantasma> fantasmas;
		private Fruta fruta;
		private int contadorPuntosEnElLaberinto = 0;
		
	public Laberinto(int nroNivel) {
	
			this.miLaberinto = new ObjetoJuego[Constantes.LABERINTO_ALTO][Constantes.LABERINTO_ANCHO];
			this.resetContadorPuntosEnElLaberito();
			this.nroNivel = nroNivel;
			this.fantasmas = new ArrayList<Fantasma>(4);
			this.cargarElementosLaberinto(nroNivel);
		}
	
	private void cargarElementosLaberinto(int numeroLaberinto){
			
			File file = new File("src/niveles/Nivel " + numeroLaberinto + ".csv");
		 
			BufferedReader bufRdr = null;
			try {
				bufRdr = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String line = null;
			int posX = 0;
			int posY = 0;
		 
			// Lee cada linea del texto.
			try {
				while((line = bufRdr.readLine()) != null)
				{	
				StringTokenizer st = new StringTokenizer(line,";");
				while (st.hasMoreTokens())
				{
					// Conseguir la siguiente Token y almacenarla en el Array.
					this.miLaberinto[posX][posY]=(generadorObjetosJuego(st.nextToken().charAt(0), posX, posY));
					posX++;
				}
				posX = 0;
				posY++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	private ObjetoJuego generadorObjetosJuego(char miIdObjetoJuego, int posX, int posY){
		
		ObjetoJuego objetoJuego = null;
		
		switch(miIdObjetoJuego){
			case 'w': objetoJuego = new Pared(this, posX,posY); break;
			
			case '.': objetoJuego = new PuntoComun(this, posX, posY); break;
			
			case 'O': objetoJuego = new PuntoPoder(this, posX, posY); break;
			
			case 'F': {	objetoJuego = new PuntoComun(this, posX, posY);
						agregarFantasma(new FantasmaDeambulador(this, posX, posY));
						agregarFantasma(new FantasmaCazador(this, posX, posY));
						agregarFantasma(new FantasmaEmboscador(this, posX, posY));
						agregarFantasma(new FantasmaPerseguidor(this, posX, posY));
						} break;
	
			case 'P': {	objetoJuego = new PuntoComun(this, posX, posY);
						this.pacMan = new PacMan(this, posX,posY);
						this.fruta = new Fruta(this, this.pacMan.getPosInicialX(), this.pacMan.getPosInicialY());
						} break;
		}
		
		return objetoJuego;
	}
	
	public void aumentarContadorPuntosEnElLaberinto() {
		this.contadorPuntosEnElLaberinto += 1;		
	}
	
	public void disminuirContadorPuntosEnElLaberinto() {
		this.contadorPuntosEnElLaberinto -= 1;		
	}
	
	public void resetContadorPuntosEnElLaberito() {
		this.contadorPuntosEnElLaberinto = 0;
	}
	
	public int getContadorPuntosEnElLaberito() {
		return(this.contadorPuntosEnElLaberinto);
	}
	
	public PacMan getPacMan(){
		return this.pacMan;
	}
	
	public int getAlto(){
		return Constantes.LABERINTO_ALTO;
	}
	
	public int getAncho(){
		return Constantes.LABERINTO_ANCHO;
	}
	
	public ObjetoJuego getElemento(int posX, int posY){
		if((posX > Constantes.LABERINTO_ALTO) || (posY > Constantes.LABERINTO_ANCHO)) {
			throw new PosicionFueraDeRangoException();
		}
		return this.miLaberinto[posX][posY];
	}
	
	public int getNroNivel() {
		return nroNivel;
	}
	
	private void agregarFantasma(Fantasma fantasma) {
		fantasmas.add(fantasma);
	}
	
	public Fantasma getFantasma(int pos) {
		return (this.fantasmas.get(pos));
	}
	
	public Fruta getFruta() {
		return this.fruta;
	}
	
	@Override
	public int getX() {
		return 0;
	}
	
	@Override
	public int getY() {
		return 0;	
	}

}//Fin Clase Laberinto.
