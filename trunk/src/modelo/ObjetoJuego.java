package modelo;

public abstract class ObjetoJuego implements titiritero.Posicionable{

	private boolean activo;
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	private Laberinto laberinto;
	
	// Tener en cuenta que X = COLUMNAS   Y = FILAS
	public ObjetoJuego(Laberinto laberinto, int row, int col){
		this.setActivo(true);
		this.setLaberinto(laberinto);
		this.setPosX(row);
		this.setPosY(col);
		this.setAlto(20);
		this.setAncho(20);
	}

	public void vivir(){}
	
	public int getX() {
		return this.getPosX();
	}

	public int getY() {
		return this.getPosY();
	}
	
	public int getAlto(){
		return this.alto;
	}
	
	public int getAncho(){
		return this.ancho;
	}
	
	public boolean estaActivo(){
		return this.isActivo();
	}
	
	public void activar() {
		this.setActivo(false);
	}
	
	public boolean sePuedePasar() {
		if(this instanceof Pared) {
			return false;
		}
		return true;
	}

	protected void setActivo(boolean activo) {
		this.activo = activo;
	}

	protected boolean isActivo() {
		return activo;
	}

	protected void setPosX(int posX) {
		this.posX = posX;
	}

	protected int getPosX() {
		return posX;
	}

	protected void setPosY(int posY) {
		this.posY = posY;
	}

	protected int getPosY() {
		return posY;
	}

	protected void setAlto(int alto) {
		this.alto = alto;
	}

	protected void setAncho(int ancho) {
		this.ancho = ancho;
	}

	protected void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}

	protected Laberinto getLaberinto() {
		return laberinto;
	}

}
