package constantes;

public class Constantes {

	// Constantes de Laberinto.
	
		public final static int LABERINTO_ANCHO = 25;
		public final static int LABERINTO_ALTO = 23;
		public final static int CANTIDAD_DE_FANTASMAS = 4;
	
	// Constantes de Direcciones.
	
		public final static char ARRIBA = 'U';
		public final static char ABAJO = 'D';
		public final static char IZQUIERDA = 'L';
		public final static char DERECHA = 'R';
	
	// Constantes de Nombres de Archivo.
	
		// * Fantasmas:
		
		public final static String FANTASMA_CAZADOR = "Fantasma Blinky.jpg";
		public final static String FANTASMA_PERSEGUIDOR = "Fantasma Inky.jpg";
		public final static String FANTASMA_DEAMBULADOR = "Fantasma Clyde.jpg";
		public final static String FANTASMA_EMBOSCADOR = "Fantasma Pinky.jpg";
		public final static String FANTASMA_ASUSTADO = "Fantasma Asustado.jpg";
		
		// * PacMan:
		
			// Modo Normal:
		
				public final static String PACMAN_ARRIBA = "PacMan Arriba.jpg";
				public final static String PACMAN_ABAJO = "PacMan Abajo.jpg";
				public final static String PACMAN_IZQUIERDA = "PacMan Izquierda.jpg";
				public final static String PACMAN_DERECHA = "PacMan Derecha.jpg";

			// Modo Super:
				
				public final static String SUPER_PACMAN_ARRIBA = "Super PacMan Arriba.jpg";
				public final static String SUPER_PACMAN_ABAJO = "Super PacMan Abajo.jpg";
				public final static String SUPER_PACMAN_IZQUIERDA = "Super PacMan Izquierda.jpg";
				public final static String SUPER_PACMAN_DERECHA = "Super PacMan Derecha.jpg";
		
		// * Pared:
		
		public final static String PARED = "Pared.jpg";
		
		// * Puntos:
		
		public final static String PUNTO_PODER = "Punto Poder.jpg";
		public final static String PUNTO_COMUN = "Punto Comun.jpg";
			
		// * Fruta:
			
		public final static String FRUTA = "Fruta.jpg";
		
	// Constantes de Jugador.
		
		public final static int JUGADOR_VIDAS = 3;
		public final static int JUGADOR_NIVEL = 0;
		public final static int JUGADOR_SCORE = 0;
		
	// Constantes de Fantasmas.
		
		public final static int RADIO_ACCION_FANTASMA_PERSEGUIDOR = 3;
		public final static int RADIO_ACCION_FANTASMA_EMBOSCADOR = 5;
		
	// Constantes de Puntajes.
		
		public final static int VALOR_PUNTO_COMUN = 5;
		public final static int VALOR_PUNTO_PODER = (VALOR_PUNTO_COMUN * 2);
		public final static int VALOR_FRUTA = VALOR_PUNTO_COMUN * 10;
		public final static int VALOR_FANTASMA = VALOR_PUNTO_COMUN * 20;
		
	// Constantes tiempo Fantasmas en estadoDebil
		
		public final static int VALOR_FANTASMA_ESTADO_DEBIL = (VALOR_PUNTO_COMUN * 15);
		
	// Constantes Controlador PacMan.
		
		public final static int INTERVALO_SIMULACION = 250;
		
	// Constantes de Fruta.
		
		public final static int PUNTOS_FALTANTES_APARICION_FRUTA = 50;
		
	// Constantes de Panel Inicial.
		
		public final static int PANEL_INICIAL_ALTO = 500;
		public final static int PANEL_INICIAL_ANCHO = 650;
		
		// * Intro:
		
		public final static String IMAGEN_INTRO = "Panel Inicio.jpg";
	
	// Constantes de Diálogo Créditos.
		
		public final static int DIALOGO_CREDITOS_ALTO = 150;
		public final static int DIALOGO_CREDITOS_ANCHO = 350;
		public final static int DIALOGO_CREDITOS_POSX = 500;
		public final static int DIALOGO_CREDITOS_POSY = 300;
		public static final String DIALOGO_CREDITOS_TITULO = "Creditos";
		public static final String DIALOGO_CREDITOS_VERSION = "Version 2.0";
		
	// Constantes de Diálogo Jugar de Nuevo.
		
		public final static int DIALOGO_JUGAR_DE_NUEVO_ALTO = 200;
		public final static int DIALOGO_JUGAR_DE_NUEVO_ANCHO = 250;
		public final static int DIALOGO_JUGAR_DE_NUEVO_POSX = 500;
		public final static int DIALOGO_JUGAR_DE_NUEVO_POSY = 300;
		public static final String DIALOGO_JUGAR_DE_NUEVO_TITULO = "¿Reintentar?";

	// Constantes de Panel Estadística.
		
		public final static int PANEL_ESTADISTICA_ALTO = 400;
		public final static int PANEL_ESTADISTICA_ANCHO = 200;
		
	// Constantes de Ventana Juego.
		
		public final static int VENTANA_JUEGO_ALTO = 665;
		public final static int VENTANA_JUEGO_ANCHO = 820;
		public static final String VENTANA_JUEGO_TITULO = "PacMan - Algoritmos y Programación III (75.07)";
		public final static int VENTANA_JUEGO_PANEL_ALTO = 580;
		public final static int VENTANA_JUEGO_PANEL_ANCHO = 629;
		public final static int VENTANA_JUEGO_POSX = 225;
		public final static int VENTANA_JUEGO_POSY = 60;
		
	// Constantes de Ventana Principal.
		
		public static final int VENTANA_PRINCIPAL_ANCHO = 600;
		public static final int VENTANA_PRINCIPAL_ALTO = 500;
		public final static int VENTANA_PRINCIPAL_POSX = 350;
		public final static int VENTANA_PRINCIPAL_POSY = 150;
		public static final String VENTANA_PRINCIPAL_TITULO = "PacMan";
		
	// Niveles.
		
		public static final int CANTIDAD_DE_NIVELES = 9;
		
}
