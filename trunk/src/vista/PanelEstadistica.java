package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;

import constantes.Constantes;
import modelo.Jugador;
import titiritero.vista.Panel;

public class PanelEstadistica extends Panel{

	private static final long serialVersionUID = 1L;
	private Label etiquetaPuntaje = null;
	private Label etiquetaNivel = null;
	private Label etiquetaVidasRestantes = null;
	
	public PanelEstadistica() {
		super(Constantes.PANEL_ESTADISTICA_ANCHO,Constantes.PANEL_ESTADISTICA_ALTO);
		initialize();
	}

	private void initialize() {
		setBackground(Color.black);
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.insets = new Insets(11, 0, 15, 0);
		gridBagConstraints2.gridy = 1;
		gridBagConstraints2.ipadx = 59;
		gridBagConstraints2.ipady = 32;
		gridBagConstraints2.gridwidth = 3;
		gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints2.gridx = 1;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.ipadx = 59;
		gridBagConstraints1.ipady = 32;
		gridBagConstraints1.insets = new Insets(11, 0, 15, 0);
		gridBagConstraints1.gridy = 2;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.ipadx = 59;
		gridBagConstraints.ipady = 32;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(11, 0, 15, 0);
		gridBagConstraints.gridy = 0;
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(2);	
		setLayout(new GridBagLayout());
		add(getEtiquetaPuntaje(), gridBagConstraints);
		add(getEtiquetaVidasRestantes(), gridBagConstraints1);
		add(getEtiquetaNivel(), gridBagConstraints2);
		etiquetaNivel.setVisible(true);
	}
	
	private Label getEtiquetaPuntaje() {
		if (etiquetaPuntaje == null) {
			etiquetaPuntaje = new Label();
			etiquetaPuntaje.setText("Puntaje: " + String.valueOf(0));
			etiquetaPuntaje.setForeground(Color.white);
			etiquetaPuntaje.setVisible(true);
		}
		return etiquetaPuntaje;
	}
	private Label getEtiquetaNivel() {
		if (etiquetaNivel == null) {
			etiquetaNivel = new Label();
			etiquetaNivel.setText("Nivel: " + String.valueOf(1));
			etiquetaNivel.setForeground(Color.white);
		}
		return etiquetaNivel;
	}
	private Label getEtiquetaVidasRestantes() {
		if (etiquetaVidasRestantes == null) {
			etiquetaVidasRestantes = new Label();
			etiquetaVidasRestantes.setText("Vidas restantes: " + String.valueOf(3));
			etiquetaVidasRestantes.setForeground(Color.white);
		}
		return etiquetaVidasRestantes;
	}
	
	public void actualizarEstadistica(int nivel, int puntaje, int vidasRestantes){
		this.etiquetaNivel.setText("Nivel: " + String.valueOf(Jugador.instance().getNivel()));
		this.etiquetaPuntaje.setText("Puntaje: " + String.valueOf(Jugador.instance().getScore()));
		this.etiquetaVidasRestantes.setText("Vidas Restantes: " + String.valueOf(Jugador.instance().getCantidadVidas()));
	}
	
}
