package modelo;

import constantes.Constantes;

public class Jugador {
	private static Jugador INSTANCE = null;
	private int score;
	private int vidas;
	private int nivel;
	private String nombre;
	
	private Jugador() {
		this.score = 0;
		this.nivel = Constantes.JUGADOR_NIVEL;
		this.vidas = Constantes.JUGADOR_VIDAS;
		this.cambiarNombre("Player");
	}
	
	public static Jugador instance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Jugador();
        }
    }
	
	public void aumentarScore(int unScore) {
		this.score += unScore;		
	}
	
	public void decrementarScore(int unScore) {
		this.score -= unScore;
		if(this.score < 0) {
			this.score = 0;
		}
	}
	
	public int getScore() {
		return (this.score);
	}
	
	public int getNivel(){
		return (this.nivel);
	}

	public void aumentarNivel() {
		this.nivel += 1;		
	}	
	
	public void incrementarVidas() {
		this.vidas += 1;
	}
	
	public void decrementarVidas() {
		this.vidas -= 1;
		if(this.vidas <= 0) {
			this.vidas = 0;
		}
	}
	
	public int getCantidadVidas() {
		return (this.vidas);
	}

	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
