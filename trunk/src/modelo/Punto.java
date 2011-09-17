package modelo;

public abstract class Punto extends ObjetoEstatico {
	
	private static int valor;
	private static int puntosComidos;
	
	public Punto(Laberinto laberinto, int posX, int posY) {
		super(laberinto, posX, posY);
		this.getLaberinto().aumentarContadorPuntosEnElLaberinto();
	}
	
	protected abstract void accionEspecial();
	
	@Override
	public void activar() {
		if(this.isActivo()) {
			this.setActivo(false);
			Jugador.instance().aumentarScore(getValor());
			this.getLaberinto().disminuirContadorPuntosEnElLaberinto();
			this.accionEspecial();
		}
	}

	protected static void setValor(int valor) {
		Punto.valor = valor * Jugador.instance().getNivel();
	}

	protected static int getValor() {
		return valor;
	}

	protected static void setPuntosComidos(int puntosComidos) {
		Punto.puntosComidos = puntosComidos;
	}

	protected static int getPuntosComidos() {
		return puntosComidos;
	}
	
}