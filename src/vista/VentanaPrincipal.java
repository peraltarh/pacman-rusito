package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import constantes.Constantes;

public class VentanaPrincipal extends JFrame{
	
	private PanelInicial panelInicial = new PanelInicial();
	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal() {
		super();
		initialize();
	}

	private void initialize() {
		setSize(new Dimension(Constantes.VENTANA_PRINCIPAL_ANCHO, Constantes.VENTANA_PRINCIPAL_ALTO));
		setResizable(false);
		setLocation(Constantes.VENTANA_PRINCIPAL_POSX,Constantes.VENTANA_PRINCIPAL_POSY);
		setTitle(Constantes.VENTANA_PRINCIPAL_TITULO);
		this.add(panelInicial,BorderLayout.CENTER);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(362, 20, 8, 10);
		constraints.gridwidth = 1;
		constraints.ipadx = 17;
		constraints.ipady = 5;
		constraints.anchor = GridBagConstraints.SOUTH;
		this.panelInicial.add(getBotonComenzar(), constraints);
	    //this.panelInicial.add(getBotonCreditos(), constraints);
	    this.addWindowListener(new java.awt.event.WindowAdapter() {	
		@Override
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.out.println("windowClosing()"); 
			System.exit(NORMAL);
			}
		});	
	}
	
	public JButton getBotonComenzar() {
		
		JButton botonComenzar = new JButton();
		botonComenzar.setText("Comenzar");
		botonComenzar.addActionListener(new java.awt.event.ActionListener() {	
			public void actionPerformed(java.awt.event.ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						setVisible(false);
						VentanaJuego ventana = new VentanaJuego();
						ventana.setLocation(Constantes.VENTANA_JUEGO_POSX, Constantes.VENTANA_JUEGO_POSY);
						ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ventana.setVisible(true);
						// TODO: Agregar Key Listener para comenzar juego...
						ventana.comenzar();
					}
				});
			}
		});
		return botonComenzar;
	}

	public JButton getBotonCreditos() {
		JButton botonCreditos = new JButton();
		botonCreditos.setText("Creditos");
		botonCreditos.addActionListener(new java.awt.event.ActionListener() {	
			public void actionPerformed(java.awt.event.ActionEvent e) {
						@SuppressWarnings("unused")
						DialogoCreditos dialogoCreditos = new DialogoCreditos();			
			}
		});
	return botonCreditos;
	}

	public void paintComponent(Graphics g){
		Dimension dimension = new Dimension(600,600);
		ImageIcon imagenFondo = new  ImageIcon(getClass().getResource(Constantes.IMAGEN_INTRO));
		g.drawImage(imagenFondo.getImage(),0, 0, dimension.width ,dimension.height , null);
		
		paintComponent(g);
	}
	
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		
	}	
}
