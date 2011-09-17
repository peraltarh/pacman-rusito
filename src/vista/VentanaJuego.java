package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import modelo.Jugador;
import constantes.Constantes;
import controlador.AdaptadorDeTeclado;
import controlador.ControladorPacMan;
import controlador.ObservadorDeEstadisticas;
import titiritero.vista.Panel;

public class VentanaJuego extends JFrame implements ObservadorDeEstadisticas {

	private static final long serialVersionUID = 1L;
	private JPanel panelContenedor = null;
	private JToolBar barraBotones = null;
	private JMenuItem botonReiniciar = null;
	private JMenuItem botonDetener = null;
	private JMenuItem botonCreditos = null;
	private Panel panelFondoControlador = null;
	private ControladorPacMan controlador = null;
	private PanelEstadistica panelEstadisticas = null;
	private boolean juegoPausado;

	public VentanaJuego() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(Constantes.VENTANA_JUEGO_ANCHO, Constantes.VENTANA_JUEGO_ALTO);
		this.setContentPane(getPanelContenedor());
		this.setTitle(Constantes.VENTANA_JUEGO_TITULO);
		this.juegoPausado = false;
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
				System.exit(NORMAL);
			}
		});
	}

	private JToolBar getBarraBotones() {
		if (barraBotones == null) {
			barraBotones = new JToolBar(SwingConstants.VERTICAL);
			barraBotones.setBounds(new Rectangle(600, 400, 200, 150));
			barraBotones.setBackground(Color.black);
			barraBotones.add(getBotonReiniciar());
			barraBotones.add(getBotonDetener());
			barraBotones.addSeparator(new Dimension (0,50));
			//barraBotones.add(getBotonCreditos());
			barraBotones.setBorderPainted(true);
			barraBotones.setFloatable(false);
		}
		return barraBotones;
	}

	private JMenuItem getBotonReiniciar() {
		if (botonReiniciar == null) {
			botonReiniciar = new JMenuItem("Reiniciar");
			botonReiniciar.setBackground(new Color(0, 0, 51));
            botonReiniciar.setForeground(Color.white);
			botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					detener();
					comenzar();
				}
			});
		}
		return botonReiniciar;
	}

	private JMenuItem getBotonDetener() {
		if (botonDetener == null) {
			botonDetener = new JMenuItem("Detener");
			botonDetener.setBackground(new Color(0, 0, 51));
			botonDetener.setForeground(Color.white);
			botonDetener.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(juegoPausado){
						controlador.comenzar(); 
						botonDetener.setText("Detener");
						juegoPausado = false;
					}else{
							controlador.detener();
							botonDetener.setText("Reanudar");
							juegoPausado = true;
					}
				}
			});
		}
		return botonDetener;
	}
	
	@SuppressWarnings("unused")
	private JMenuItem getBotonCreditos() {
		if (botonCreditos == null) {
			botonCreditos = new JMenuItem("Creditos");
			botonCreditos.setBackground(new Color(0, 0, 51));
			botonCreditos.setForeground(Color.white);
			botonCreditos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					}
			});
			botonCreditos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				controlador.detener();
				botonDetener.setText("Reanudar");
				juegoPausado = true;
				DialogoCreditos dialogoCreditos = new DialogoCreditos();
				}
			});
		}
		return botonCreditos;
	}

	void comenzar(){
		System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
		this.controlador = new ControladorPacMan(getSuperficieDeDibujo());
		addKeyListener(new AdaptadorDeTeclado(this.controlador));
		controlador.agregarObservadorDeEstadisticas(this);
		this.controlador.comenzar();
	}
	
	private void detener() {
		this.controlador.detener();	
	}

	private Panel getSuperficieDeDibujo() {
		if (panelFondoControlador == null) {
			panelFondoControlador = new Panel(Constantes.VENTANA_JUEGO_PANEL_ALTO, Constantes.VENTANA_JUEGO_PANEL_ANCHO);
			panelFondoControlador.setBackground(Color.black);
			panelFondoControlador.setLayout(new GridBagLayout());
			panelFondoControlador.setBounds(new Rectangle(2, 2, Constantes.VENTANA_JUEGO_PANEL_ALTO, Constantes.VENTANA_JUEGO_PANEL_ANCHO));
		}
		return panelFondoControlador;
	}

	private PanelEstadistica getPanelEstadistica() {
		if (panelEstadisticas == null) {
			panelEstadisticas = new PanelEstadistica();
			panelEstadisticas.setBounds(new Rectangle(620, 040, 150, 200));
		}
		return panelEstadisticas;
	}

	private JPanel getPanelContenedor() {
		if (panelContenedor == null) {
			panelContenedor = new JPanel();
			panelContenedor.setLayout(null);
			panelContenedor.setBackground(Color.black);
			panelContenedor.add(getBarraBotones(), null);
			panelContenedor.add(getSuperficieDeDibujo(), null);
			panelContenedor.add(getPanelEstadistica(), null);
		}
		return panelContenedor;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaJuego thisClass = new VentanaJuego();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				thisClass.comenzar();
			}
		});
	}

	@Override
	public void seActualizaronLasEstadisticas(int nivel, int puntaje, int vidas) {
		
		if (Jugador.instance().getCantidadVidas()== 0){
			 
			 DialogoJugarDeNuevo dialogoJugarDeNuevo = new DialogoJugarDeNuevo("GAME OVER");
			 this.controlador.detener();
			 this.setEnabled(false);
			 dialogoJugarDeNuevo.getBotonJugarDeNuevo().addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						setEnabled(true);
						comenzar();
					}});
		}
		else 
			if (controlador.getJuego().juegoGanado()){			 
				 DialogoJugarDeNuevo dialogoJugarDeNuevo = new DialogoJugarDeNuevo("¡Ganaste!");
				 this.controlador.detener();
				 this.setEnabled(false);
				 dialogoJugarDeNuevo.getBotonJugarDeNuevo().addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							setEnabled(true);
							comenzar();
						}
				});
		}
		else {
			this.panelEstadisticas.actualizarEstadistica(nivel, puntaje, vidas) ;
		}
	}
}  
